import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestFunctions {

    private WebDriver driver;

    private LoginPage loginSection;

    private ShoppingPage shoppingSection;

    public TestFunctions(WebDriver driver) {
        //WebDriverManager.chromedriver().setup();
        this.driver = driver;
        loginSection = LoginPage.getInstance(this.driver);
        shoppingSection = ShoppingPage.getInstance(this.driver);
    }

    public ShoppingPage shoppingSection(){
        return this.shoppingSection;
    }

    public LoginPage loginSection() {
        return this.loginSection;
    }




}
