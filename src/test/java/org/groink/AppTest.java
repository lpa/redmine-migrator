package org.groink;

import org.groink.redmine.domain.*;
import org.joda.time.DateTime;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

import java.util.ArrayList;
import java.util.List;

import static junit.framework.Assert.assertTrue;

@RunWith(JUnit4.class)
public class AppTest
{


    @Test
    public void testApp()
    {
        assertTrue( true );
    }

    @Test
    public void marshallingIssueShouldBeRight() throws JAXBException {
        JAXBContext context = JAXBContext.newInstance(Issue.class);
        Marshaller marshaller = context.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, new Boolean(true));

        Issue issue = new Issue();
        issue.setId(4326);
        //issue.setAuthor(new Author(1, "Joe"));
        issue.setProject(new Project(1, "Redmine"));
        issue.setTracker(new Tracker(2, "Feature"));
        issue.setStatus(new Status(1, "New"));
        issue.setPriority(new Priority(4, "Normal"));
        issue.setCategory(new Category(9, "Email notifications"));
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


        marshaller.marshal(issue, System.out);
    }

    @Test
    public void getAnIssue(){

        String apiKey = "ada0245726a7ecc45c074b785e4614808d17b202";

        /* Client client = ClientBuilder.newClient();
        WebTarget target = client.target("http://redmine.adencf.local/");
        WebTarget issueTarget = target.path("issues/3653.xml");
        issueTarget.queryParam("key",apiKey);

        Invocation.Builder invocationBuilder = issueTarget.request(MediaType.APPLICATION_XML_TYPE);
        Response response = invocationBuilder.get();

        System.out.println(response.getStatus());
        System.out.println(response.readEntity(String.class)); */


        String responseEntity = ClientBuilder.newClient()
                .target("http://redmine.adencf.local/").path("issues/3653.xml")
                .queryParam("key",apiKey)
                .request(MediaType.APPLICATION_XML_TYPE).get(String.class);

        System.out.println(responseEntity);





    }
}
