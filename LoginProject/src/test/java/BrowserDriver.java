import Utils.ConfigReader;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.TestInstance;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Properties;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class BrowserDriver {

    static  WebDriver driver;
    TestFunctions testFunctions;
    Properties properties = new Properties();
    ConfigReader configReader;

    public void getValueOfProperty() {
        configReader = new ConfigReader();
        properties = configReader.initialize_properties();
    }

    @BeforeAll
    public void setUpDriver(){
        getValueOfProperty();
        String appUrl = properties.getProperty("appUrl");
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get(appUrl);
        testFunctions = new TestFunctions(driver);
    }

   /* @AfterAll
     public void tearDown(){
       driver.quit();
       }

    */


}
