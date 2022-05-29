package Utils;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {

    private Properties properties;

    /**
     * This method is used to load the properties from config.properties file
     * @return it returns Properties prop object
     */
    public Properties initialize_properties() {

        properties = new Properties();
        try {
            FileInputStream ip = new FileInputStream("./src/test/config.properties");
            properties.load(ip);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return properties;

    }


}

