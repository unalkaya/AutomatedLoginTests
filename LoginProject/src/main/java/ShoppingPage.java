import Utils.ConfigReader;
import Utils.Page;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.Properties;

public class ShoppingPage extends Page {

    static Properties properties;
    static ShoppingPage shoppingPage;
    static ConfigReader configReader;

    static WebDriver driver;

    static String firstProductText;

    static int valueBeforeIncreaseProduct;

    private int TimeOutSeconds=3;



    private final By searchArea = By.xpath("//div[@role='combobox']/input");
    private final By searchBtn = By.xpath("//div[@class='searchBoxOld-yDJzsIfi_S5gVgoapx6f']");

    private final By firstProductAfterSearch = By.id("i0");

    private final By firstProductAddBasketBtn = By.xpath("//li[@id='i0']//div[@data-test-id='campaign']");

    private final By thirdProductAfterSearch = By.id("i2");

    private final By thirdProductAddBasketBtn = By.xpath("//li[@id='i2']//div[@data-test-id='campaign']");

    private final By myShoppingBasket = By.xpath("//div[@class='sf-OldMyAccount-ggPMlRFTcwMlAMeDSFfk']/a");

    private final By firstProductInMyBasket = By.xpath("//div[@class='product_name_3Lh3t']");

    private final By thirdProductInMyBasket = By.xpath("//div[@class='product_name_3Lh3t']");

    private final By increaseCountOfFirstProduct = By.xpath("//div[@class='container_HX1zs']//a[@aria-label='Ürünü Arttır']");

    private final By productValueElement = By.xpath("//input[@name='quantity']");

    private final By homePageBtn = By.xpath("//a[@title= 'Hepsiburada']");


    public static ShoppingPage getInstance(WebDriver webDriver){
        LoginPage.driver = webDriver;
        if (configReader == null)
            configReader = new ConfigReader();
        if (properties == null)
            properties = configReader.initialize_properties();
        if (shoppingPage == null)
            shoppingPage = new ShoppingPage();
        return shoppingPage;
    }

    public ShoppingPage search() {
        String searchWord = properties.getProperty("search");
        sendKeys(driver, searchArea, searchWord);
        return this;
    }

    public ShoppingPage searchClick(){
        click(driver, searchBtn);
        return this;
    }

    public ShoppingPage firstProductHover(){
        hover(driver,firstProductAfterSearch);
        return this;
    }

    public ShoppingPage firstProductAddBasketClick(){
        click(driver,firstProductAddBasketBtn);
        firstProductText = element(driver,firstProductAfterSearch).getText();
        return this;
    }

    public ShoppingPage thirdProductHover(){
        hover(driver,thirdProductAfterSearch);
        return this;
    }

    public ShoppingPage thirdProductAddBasketClick(){
        click(driver,thirdProductAddBasketBtn);
        return this;
    }

    public ShoppingPage myShoppingBasketClick(){
        click(driver,myShoppingBasket);
        waitForSecond();
        valueBeforeIncreaseProduct = Integer.parseInt(element(driver, productValueElement).getCssValue("value"));
        return this;
    }

    public ShoppingPage assertBasketFirstProduct(){
        String expectedText = element(driver,firstProductAfterSearch).getText();
        String errorMessage = "Prooducts are not same -- Searched one - Added one";
        String actualText;

        actualText = element(driver,firstProductInMyBasket).getText() ;
        Assert.assertTrue(errorMessage,actualText.equals(expectedText));

        return this;
    }

    public ShoppingPage assertBasketThirdProduct(){
        String expectedText = element(driver,thirdProductAfterSearch).getText();
        String errorMessage = "Prooducts are not same -- Searched one - Added one";
        String actualText;

        actualText = element(driver,thirdProductInMyBasket).getText() ;
        Assert.assertTrue(errorMessage,actualText.equals(expectedText));

        return this;
    }

    public ShoppingPage clickIncreaseProductNumber(){
        click(driver, increaseCountOfFirstProduct);
        return this;
    }


    public ShoppingPage assertIncreasementOfProduct(){
        int valueAfterIncreaseProduct = Integer.parseInt(element(driver, productValueElement).getCssValue("value"));
        String errorMessage = "Prooducts are not same -- Searched one - Added one";

        Assert.assertTrue(valueAfterIncreaseProduct>(valueBeforeIncreaseProduct));

        return this;
    }

    public ShoppingPage homePageButtonClick(){
        click(driver, homePageBtn);
        return this;
    }

    public ShoppingPage waitForSecond()
    {waitForSecond(driver,TimeOutSeconds);return this;}

}
