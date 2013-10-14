package org.groink.common.jaxb;

import org.joda.time.DateTime;

import javax.xml.bind.annotation.adapters.XmlAdapter;

/**
 * Xml Adapter to marshall {@link DateTime} to {@link String} and vice versa.
 */
public class DateTimeAdapter extends XmlAdapter<String, DateTime> {

    public DateTime unmarshal(String v) throws Exception {
        return new DateTime(v);
    }

    public String marshal(DateTime v) throws Exception {
        return v.toString();
    }

}