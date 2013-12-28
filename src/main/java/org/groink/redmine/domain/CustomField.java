package org.groink.redmine.domain;

import com.google.common.base.Objects;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlValue;

public class CustomField {

    private int id;
    private String name;
    private String value;

    public CustomField() {
    }

    public CustomField(int id, String name, String value) {
        this.id = id;
        this.name = name;
        this.value = value;
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

    @XmlValue
    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id, name, value);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        final CustomField other = (CustomField) obj;
        return Objects.equal(this.id, other.id) && Objects.equal(this.name, other.name) && Objects.equal(this.value, other.value);
    }

    @Override
    public String toString() {
        return Objects.toStringHelper(this)
                .add("id", id)
                .add("name", name)
                .add("value", value)
                .toString();
    }
}
