package softuni.exam.instagraphlite.util;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.File;

public class XmlParser {

    private XmlParser () {}

    public static <T> T getFromXml(Class<T>rootDtoClass, File file) throws JAXBException {
        Unmarshaller unmarshaller = JAXBContext.newInstance(rootDtoClass).createUnmarshaller();

        return (T) unmarshaller.unmarshal(file);
    }
}
