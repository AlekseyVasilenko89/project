package project.db;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Util {
    public String getPropertiesValue(String propetiesName) {
        String propertiesValue= "";
        Properties properties= new Properties();

        try (InputStream inputStream= this.getClass().getResourceAsStream("config.properties")) {
            properties.load(inputStream);
            propertiesValue= properties.getProperty(propetiesName);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return propertiesValue;
    }
}
