package com.jch.xmlentity;

import javax.xml.bind.annotation.*;

@XmlRootElement( name = "template" )
@XmlAccessorType(XmlAccessType.NONE)
public class Template {

    Table eltable;
    @XmlElement( name = "el-table" )
    public void setEltable(Table eltable) {
        this.eltable = eltable;
    }

    public Table getEltable() {
        return eltable;
    }
}
