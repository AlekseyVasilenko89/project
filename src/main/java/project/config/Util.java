package project.config;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Util {
    public String getPropertiesValue(String propertiesName) {
        String propertiesValue = "";
        Properties properties = new Properties();

        try (InputStream inputStream = Thread.currentThread().getContextClassLoader().getResourceAsStream("config.properties")) {
            properties.load(inputStream);
            propertiesValue = properties.getProperty(propertiesName, "HIBERNATE");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return propertiesValue;
    }
}
