package tracker.utils.storage;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.File;

public class JAXBConverter {

  public static <T> Object loadFromFile(File file, Class<T> classToConvert) {
    try {
      JAXBContext jaxbContext = JAXBContext.newInstance(classToConvert);
      Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
      System.out.println(file);
      return unmarshaller.unmarshal(file);
    } catch (Exception e) {
      e.printStackTrace();
      return null;
    }
  }

  public static <T> void saveToFile(File file, Class<T> classToConvert, T dataToSave) {
    try {
      JAXBContext jaxbContext = JAXBContext.newInstance(classToConvert);
      Marshaller marshaller = jaxbContext.createMarshaller();
      marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
      marshaller.marshal(dataToSave, file);
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

}
