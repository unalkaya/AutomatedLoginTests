import Utils.ConfigReader;
import Utils.Page;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

import java.util.Properties;

public class LoginPage extends Page {
    static Properties properties;
    static LoginPage loginSection;
    static ConfigReader configReader;
    static WebDriver driver;

    private int TimeOutSeconds = 3;

    private final By myAccountBox = By.id("myAccount");

    private final By loginInMyAccountBtn = By.id("login");
    private final By loginBtn = By.id("btnLogin");
    private final By email = By.xpath("//input[@id='txtUserName']");
    private final By password = By.xpath("//input[@id='txtPassword']");

    private final By selectEmailBtn = By.xpath("//button[@name='btnEmailSelect']");

    private final By signOutBtn = By.xpath("//div[@class= 'sf-OldMyAccount-IMCbeURaRPyXfubeWCC7']/ul//li[last()]");

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

    public LoginPage waitForSecond()
    {waitForSecond(driver,TimeOutSeconds);return this;}

    public LoginPage myAccountHover() {
        hover(driver,myAccountBox);
        return this;
    }

    public LoginPage clickLoginInMyAccountButton(){
        click(driver, loginInMyAccountBtn);
        return this;
    }


    public LoginPage setCorrectEmail() {
        String emailAddress = properties.getProperty("email");
        sendKeys(driver, email, emailAddress);
        return this;
    }

    public LoginPage loginBtnClick(){
        click(driver, loginBtn);
        return this;
    }

    public LoginPage setCorrectPassword() {
        String pass = properties.getProperty("pass");
        click(driver, password);
        sendKeys(LoginPage.driver, password,pass);
        return this;
    }

    public LoginPage selectEmailBtnClick(){
        click(driver, selectEmailBtn);
        return this;
    }

    public LoginPage signOutClick(){
        click(driver,signOutBtn);
        return this;
    }

}
