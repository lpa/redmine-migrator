package org.groink.redmine.domain;

import com.google.common.base.Objects;

import javax.xml.bind.annotation.XmlElement;
import java.util.List;

public class CustomFieldCollection {

    public CustomFieldCollection(List<CustomField> customFieldList) {
        this.customFieldList = customFieldList;
    }

    private List<CustomField> customFieldList;

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
    public int hashCode() {
        return Objects.hashCode(customFieldList);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        final CustomFieldCollection other = (CustomFieldCollection) obj;
        return Objects.equal(this.customFieldList, other.customFieldList);
    }

    @Override
    public String toString() {
        return Objects.toStringHelper(this)
                .add("customFieldList", customFieldList)
                .toString();
    }
}
