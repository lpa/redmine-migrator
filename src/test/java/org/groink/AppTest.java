package org.groink;

import org.groink.redmine.domain.*;
import org.joda.time.DateTime;
import org.junit.Test;

import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;

import static junit.framework.Assert.assertTrue;

public class AppTest
{

    private final static String APIKEY = "ada0245726a7ecc45c074b785e4614808d17b202";


    @Test
    public void testApp()
    {
        assertTrue( true );
    }

    @Test
    public void marshallingIssueShouldBeRight() throws JAXBException {
        JAXBContext context = JAXBContext.newInstance(Issue.class);
        Marshaller marshaller = context.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);

        Issue issue = createIssue();
        marshaller.marshal(issue, System.out);
    }

    private Issue createIssue() {
        Issue issue = new Issue();
        issue.setId(4326);
        //issue.setAuthor(new Author(1, "Joe"));
        issue.setProject(new Project(181, "Recherche de CV"));
        issue.setTracker(new Tracker(2, "Feature"));
        issue.setStatus(new Status(1, "New"));
        issue.setPriority(new Priority(4, "Normal"));
        issue.setCategory(new Category(1, "Email notifications"));
        issue.setSubject("Aggregate Multiple Issue Changes for Email Notifications");
        issue.setDescription("This is not to be confused with another useful proposed feature that\n" +
                "would do digest emails for notifications.");
        issue.setCreatedOn(new DateTime("2009-12-03T15:02:12.000Z"));
        issue.setStartDate(new DateTime("2009-12-03"));
        issue.setDueDate(new DateTime(2011, 5, 30, 11, 2, 30, 0));
        issue.setUpdatedOn(new DateTime("2010-01-03T12:08:41"));
        issue.setDoneRatio(0);

        List<CustomField> fieldsList = new ArrayList<CustomField>();
        fieldsList.add(new CustomField(2, "Resolution", "Duplicate"));
        fieldsList.add(new CustomField(3, "Texte", "Test"));
        fieldsList.add(new CustomField(6, "Boolean", "1"));
        fieldsList.add(new CustomField(7, "Date", "2010-01-12"));
        issue.setCustomFieldCollection(new CustomFieldCollection(fieldsList));
        return issue;
    }

    @Test
    public void getAnIssue(){

        String responseEntity = ClientBuilder.newClient()
                .target("http://redmine.adencf.local/").path("issues/3653.xml")
                .queryParam("key",APIKEY)
                .request(MediaType.APPLICATION_XML_TYPE).get(String.class);

        assertTrue(responseEntity != null);
        assertTrue(responseEntity.contains("<id>3653</id>"));

    }

    @Test
    public void getIssuesAboutCV(){

        String responseEntity = ClientBuilder.newClient()
                .target("http://redmine.adencf.local/").path("issues.xml")
                .queryParam("key",APIKEY)
                .queryParam("project_id","21")
                .queryParam("category_id","479")
                .request(MediaType.APPLICATION_XML_TYPE).get(String.class);

        assertTrue(responseEntity != null);
        assertTrue(responseEntity.contains("CV Search"));
    }



    @Test
    public void createAnIssue(){

        Issue myIssue = createIssue();
        Response response = ClientBuilder.newClient()
                .target("http://redmine.adencf.local/").path("issues.xml")
                .queryParam("key",APIKEY).request()
                .post(Entity.xml(myIssue));
        System.out.println(response.getStatus());
        System.out.println(response.readEntity(String.class));

    }

    @Test
    public void fetchResponseEntity_shouldReturnLessOrEqualMaxNumberOfIssues() throws JAXBException {

         // Given
         String responseEntity = App.fetchResponseEntity(1);
         JAXBContext jaxbContext = JAXBContext.newInstance(Issues.class);
         Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();

         // When
         StringReader reader = new StringReader(responseEntity);
         Issues issues = (Issues) unmarshaller.unmarshal(reader);
         int count = issues.getIssues().size();

         // Then
         assertTrue(count <= App.MAX_ITEM_NUMBER);
    }



        @Test
        public void fetchResponseEntity_shouldReturnLessOrEqualMaxNumberOfIssuesEvenWithTooBigPageNumber() throws JAXBException {

        // Given
        String responseEntity = App.fetchResponseEntity(100);
        JAXBContext jaxbContext = JAXBContext.newInstance(Issues.class);
        Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();

        //When
        StringReader reader = new StringReader(responseEntity);
        Issues issues = (Issues) unmarshaller.unmarshal(reader);
        int count = 0;

        for (Issue i : issues.getIssues()) {
            count++;
        }

        // Then
        assertTrue(count <= App.MAX_ITEM_NUMBER);

    }
}



