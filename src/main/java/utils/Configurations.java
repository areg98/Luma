package utils;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Configurations {

    public static String URL;
    public static String BROWSER_TYPE;
    public static String TESTNG_XML;

    static {
        try {
            URL = getPropValues("url");
            BROWSER_TYPE = getPropValues("browser");
            TESTNG_XML = getPropValues("testng_xml");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    static InputStream inputStream;

    public static Properties getPropValues() throws IOException {
        Properties prop = new Properties();

        try {
            String propFileName = "config.property";
            inputStream = Configurations.class.getClassLoader().getResourceAsStream(propFileName);
            if (inputStream != null) {
                prop.load(inputStream);
            } else {
                throw new FileNotFoundException("property file '" + propFileName + "' not found in the classpath");
            }
        } catch (Exception e) {
            System.out.println("Exception: " + e);
        } finally {
            inputStream.close();
        }
        return prop;
    }

    public static String getPropValues(String key) throws Exception {
        if (System.getProperty(key) != null) {
            return System.getProperty(key);
        } else {
            return getPropValues().getProperty(key);
        }
    }
}
