package com.jch.xmlentity;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import java.util.List;

@XmlRootElement( name = "el-table" )
public class Table {
    String data;
    String style;
    List<Column>list;
    @XmlAttribute(name="data",required =true)
    public void setData(String data) {
        this.data = data;
    }
    @XmlAttribute(name="style",required =true)
    public void setStyle(String style) {
        this.style = style;
    }
    @XmlElement(name="el-table-column",required =true)
    public void setList(List<Column> list) {
        this.list = list;
    }

    public String getData() {
        return data;
    }

    public String getStyle() {
        return style;
    }

    public List<Column> getList() {
        return list;
    }
}
