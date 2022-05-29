import Utils.ConfigReader;
import Utils.Page;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import java.util.Properties;

public class LoginPage extends Page {
    static Properties properties;
    static LoginPage loginSection;
    static ConfigReader configReader;
    static WebDriver driver;

    private final By loginBtn = By.className("green_flat");
    private final By email = By.id("email");
    private final By password = By.id("password");

    public static LoginPage getInstance(WebDriver webDriver){
        LoginPage.driver = webDriver;
        if (configReader == null)
            configReader = new ConfigReader();
        if (properties == null)
            properties = configReader.initialize_properties();
        if (loginSection == null)
            loginSection = new LoginPage();
        return loginSection;
    }

    public LoginPage setCorrectEmail() {
        String emailAddress = properties.getProperty("email");
        sendKeys(LoginPage.driver, email, emailAddress);
        return this;
    }

    public LoginPage setCorrectPassword() {
        String pass = properties.getProperty("pass");
        click(LoginPage.driver, password);
        sendKeys(LoginPage.driver, password,pass);
        return this;
    }

    public LoginPage setInCorrectEmail() {
        String emailAddress = properties.getProperty("incorrectEmail");
        sendKeys(LoginPage.driver, email,emailAddress);
        return this;
    }

    public LoginPage setInCorrectPassword() {
        String pass = properties.getProperty("incorrectPassword");

        click(LoginPage.driver, password);
        sendKeys(LoginPage.driver, password,pass);
        return this;
    }


    public LoginPage loginBtnClick(){
        click(LoginPage.driver, loginBtn);
        return this;
    }

    public LoginPage assertPageTitle(){

        String actualTitle = driver.getTitle();
        String expectedTitleName = properties.getProperty("expectedTitleName");
        Assert.assertTrue(actualTitle.contains(expectedTitleName));
        return this;
    }

}
