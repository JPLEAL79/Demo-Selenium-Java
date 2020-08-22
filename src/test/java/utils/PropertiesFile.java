package utils;

import java.io.FileInputStream;
import java.io.InputStream;

public class PropertiesFile {

    public static void readPropertiesFile() {
        PropertiesFile prop = new PropertiesFile();
        try {
            InputStream input = new FileInputStream("C:/Users/jplea/repoJP/Demo-Selenium-Java/src/test/java/utils/config.properties");

        } catch (Exception e) {
            e.getStackTrace();
        }

    }

}
