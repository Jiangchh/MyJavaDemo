package com.jch;

import com.jch.xmlentity.Column;
import com.jch.xmlentity.Table;
import com.jch.xmlentity.Template;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.File;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws JAXBException {
        List<Column>list=new ArrayList<Column>();
        Column column=new Column();
        column.setProp("id");
        column.setLabel("主键");
        Column column1=new Column();
        column1.setProp("userId");
        column1.setLabel("用户Id");
        Column column2=new Column();
        column2.setProp("roleId");
        column2.setLabel("角色Id");
        Column column3=new Column();
        column3.setProp("createTime");
        column3.setLabel("创建时间");
        Column column4=new Column();
        column4.setProp("updateTime");
        column4.setLabel("修改时间");
        list.add(column);
        list.add(column1);
        list.add(column2);
        list.add(column3);
        list.add(column4);

        Table table=new Table();
        table.setData("sysUserRole");
        table.setStyle("width: 100%");
        table.setList(list);
        Template spain = new Template();
        spain.setEltable(table);
        /* init jaxb marshaler */
        JAXBContext jaxbContext = JAXBContext.newInstance( Template.class );
        Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
        /* set this flag to true to format the output */
        jaxbMarshaller.setProperty( Marshaller.JAXB_FORMATTED_OUTPUT, true );
        /* marshaling of java objects in xml (output to file and standard output) */
        jaxbMarshaller.marshal( spain, new File( "SysUserRole.vue" ) );
        jaxbMarshaller.marshal( spain, System.out );

    }
}
