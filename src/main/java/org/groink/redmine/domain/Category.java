package org.groink.redmine.domain;

import com.google.common.base.Objects;

import javax.xml.bind.annotation.XmlAttribute;

/** org.groink.redmine.domain.Issue$Category is a non-static inner class, and JAXB can't handle those.
 *  so make them top level classes*/
public class Category {

    private int id;
    private String name;

    public Category() {
    }

    public Category(int id, String name) {
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
    public int hashCode() {
        return Objects.hashCode(id, name);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        final Category other = (Category) obj;
        return Objects.equal(this.id, other.id) && Objects.equal(this.name, other.name);
    }

    @Override
    public String toString() {
        return Objects.toStringHelper(this)
                .add("id", id)
                .add("name", name)
                .toString();
    }
}
