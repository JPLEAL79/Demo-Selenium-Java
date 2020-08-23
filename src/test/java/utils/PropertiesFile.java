package utils;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesFile {

    public static Properties readPropertiesFile() {
        PropertiesFile prop = new PropertiesFile();
        Properties props = new Properties();
        try {
            InputStream input = new FileInputStream("./src/test/java/utils/config.properties");
            props.load(input);

        } catch (Exception e) {
            e.getStackTrace();
        }
        return props;

    }

}
