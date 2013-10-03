package org.groink.redmine.domain;

import javax.xml.bind.annotation.XmlAttribute;

/** org.groink.redmine.domain.Issue$Category is a non-static inner class, and JAXB can't handle those.
 *  so make them top level classes*/
public class Priority {
    int id;
    String name;

    public Priority(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public Priority() {
    }

    @XmlAttribute
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @XmlAttribute
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
