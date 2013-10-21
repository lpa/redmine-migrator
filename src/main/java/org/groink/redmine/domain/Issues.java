package org.groink.redmine.domain;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Issues {

    @XmlElement(name="issue")
    private List<Issue> issues;

    @Override
    public String toString() {
        return "Issues{" +
                "issues=" + issues +
                '}';
    }
}
