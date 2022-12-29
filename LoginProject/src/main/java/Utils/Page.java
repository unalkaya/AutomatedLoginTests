package Utils;

import org.checkerframework.checker.units.qual.A;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Properties;
import java.util.concurrent.TimeUnit;

public abstract class Page {
    public static final int EXPECTED_CONDITION_TIMEOUT = 15;

    public WebElement element(WebDriver driver, By by){
        WebElement element = driver.findElement(by);
        return element;
    }

    public void sendKeys(WebDriver driver, By by, String text){
        element(driver, by).sendKeys(text);
    }


    public void click(WebDriver driver, By by){
        element(driver, by).click();
    }

    public void hover(WebDriver driver,By by){
        Actions action = new Actions(driver);
        action.moveToElement(element(driver,by)).perform();
    }

    public void waitForSecond(WebDriver driver, int timeOut){driver.manage().timeouts().implicitlyWait(timeOut, TimeUnit.SECONDS);}
}
