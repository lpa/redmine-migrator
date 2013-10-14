@XmlJavaTypeAdapters({
        @XmlJavaTypeAdapter(type=DateTime.class,
                value=DateTimeAdapter.class),
})
package org.groink.redmine.domain;

import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapters;

import org.groink.common.jaxb.DateTimeAdapter;
import org.joda.time.DateTime;