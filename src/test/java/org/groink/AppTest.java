package org.groink;

import org.groink.redmine.domain.Issue;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

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



        Issue issue = new Issue();
        issue.setId(1);
        issue.setAuthor(1, "Joe");

    }
}
