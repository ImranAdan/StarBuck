package org.adani.starbuck.utils;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.StringWriter;

public final class XMLUtils {


    public static <T> String toXMLString(T instance) throws JAXBException {

        JAXBContext context = JAXBContext.newInstance(instance.getClass());

        Marshaller marshaller = context.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);

        StringWriter writer = new StringWriter();
        marshaller.marshal(instance, writer);

        String xmlStr = writer.toString();
        return xmlStr;
    }

}
