package com.jch.xmlentity;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlType(propOrder = {"prop","label"})
@XmlRootElement( name = "el-table-column" )
public class Column {
    String prop;
    String label;
    @XmlAttribute(name="prop",required =true)
    public void setProp(String prop) {
        this.prop = prop;
    }
    @XmlAttribute(name="label",required =true)
    public void setLabel(String label) {
        this.label = label;
    }

    public String getProp() {
        return prop;
    }

    public String getLabel() {
        return label;
    }
}
