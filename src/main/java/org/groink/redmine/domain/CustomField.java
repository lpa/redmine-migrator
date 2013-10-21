package org.groink.redmine.domain;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlValue;

public class CustomField {

    int id;
    String name;
    String value;

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
    public String toString() {
        return "CustomField{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", value='" + value + '\'' +
                '}';
    }
}
