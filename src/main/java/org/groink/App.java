package org.groink;


import org.groink.redmine.domain.Issue;
import org.groink.redmine.domain.Issues;

import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.MediaType;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.StringReader;
import java.util.HashSet;

public class App
{

    protected static final String API_KEY = "ada0245726a7ecc45c074b785e4614808d17b202";
    protected static final int MAX_ITEM_NUMBER = 25;

    public static void main( String[] args )
    {

        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(Issues.class);
            Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
            HashSet<Issue> issuesSet = new HashSet<Issue>();
            int oldSetSize;
            int newSetSize;
            int pageNumber = 0;

            // let's paginate as long as new issues are added to the set
            do {
                pageNumber++;
                String responseEntity = fetchResponseEntity(pageNumber);

                StringReader reader = new StringReader(responseEntity);
                Issues issues = (Issues) unmarshaller.unmarshal(reader);

                oldSetSize = issuesSet.size();
                System.out.println(oldSetSize);
                issuesSet.addAll(issues.getIssues());
                newSetSize = issuesSet.size();
                System.out.println(newSetSize);

            } while (newSetSize > oldSetSize);

                System.out.println("issues =" + issuesSet.size());

        } catch (JAXBException e) {
            e.printStackTrace();
        }

    }

    /** If page number is too big, redmine fetches page 1, instead of returning 0 or null result **/
    protected static String fetchResponseEntity(int page) {
        // Redmine 1.0.0 forces us to use this ugly "page" number instead of the more convenient "offset" and "limit"
        // parameters which don't work with this old API version
        return ClientBuilder.newClient()
                    .target("http://redmine.adencf.local/").path("issues.xml")
                    .queryParam("key",API_KEY)
                    .queryParam("project_id", "21")
                    .queryParam("category_id", "479") //CV Search
                    .queryParam("status_id", "*")
                    .queryParam("page", page)
                    .request(MediaType.APPLICATION_XML).get(String.class);

        //  21 = Offres / Nomenclatures
        // 180 = Dispatch des offres
        // 181 = Recherche de CV
    }
}
