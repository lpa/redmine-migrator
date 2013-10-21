package org.groink;


import org.groink.redmine.domain.Issues;

import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.MediaType;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.StringReader;

public class App
{

    protected static final String API_KEY = "ada0245726a7ecc45c074b785e4614808d17b202";

    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );

        //  21 = Offres / Nomenclatures
        // 180 = Dispatch des offres
        // 181 = Recherche de CV

        String responseEntity = ClientBuilder.newClient()
                .target("http://redmine.adencf.local/").path("issues.xml")
                .queryParam("key",API_KEY)
                .queryParam("project_id","21")
                .queryParam("category_id","479")
                .request(MediaType.APPLICATION_XML).get(String.class);

        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(Issues.class);
            Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();

            StringReader reader = new StringReader(responseEntity);
            Issues issues = (Issues) unmarshaller.unmarshal(reader);

            System.out.println(issues.toString());

        } catch (JAXBException e) {
            e.printStackTrace();
        }









    }
}
