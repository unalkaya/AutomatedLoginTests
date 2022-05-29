import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class TestFunctions {

    private WebDriver driver;

    private LoginPage loginSection;

    private final By signInBtn = By.className("btnSignIn");

    public TestFunctions(WebDriver driver) {
        this.driver = driver;
        loginSection = LoginPage.getInstance(this.driver);
    }

    public LoginPage loginSection() {
        return this.loginSection;
    }

    public TestFunctions signInBtnClick(){
        WebElement signinButton = driver.findElement(signInBtn);
        signinButton.click();
        return this;
    }


}
