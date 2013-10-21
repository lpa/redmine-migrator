package org.groink.redmine.domain;

import javax.xml.bind.annotation.XmlElement;
import java.util.List;

public class CustomFieldCollection {

    public CustomFieldCollection(List<CustomField> customFieldList) {
        this.customFieldList = customFieldList;
    }

    List<CustomField> customFieldList;

    public CustomFieldCollection() {
    }


    @XmlElement(name = "custom_field")
    public List<CustomField> getCustomFieldList() {
        return customFieldList;
    }

    public void setCustomFieldList(List<CustomField> customFieldList) {
        this.customFieldList = customFieldList;
    }

    @Override
    public String toString() {
        return "CustomFieldCollection{" +
                "customFieldList=" + customFieldList +
                '}';
    }
}
