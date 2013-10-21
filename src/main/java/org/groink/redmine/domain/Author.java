package org.groink.redmine.domain;

import javax.xml.bind.annotation.XmlAttribute;

/** org.groink.redmine.domain.Issue$Category is a non-static inner class, and JAXB can't handle those.
 *  so make them top level classes*/
public class Author {
    int id;
    String name;

    public Author() {
    }

    public Author(int id, String name) {
        this.id = id;
        this.name = name;
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

    @Override
    public String toString() {
        return "Author{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
