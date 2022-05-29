package Utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Properties;

public abstract class Page {
    public static final int EXPECTED_CONDITION_TIMEOUT = 15;

    public WebElement element(WebDriver driver, By by){
//        WebDriverWait wait = new WebDriverWait(driver,EXPECTED_CONDITION_TIMEOUT);
//        return wait.until(ExpectedConditions.elementToBeClickable(by)).findElement(by);
        WebElement element = driver.findElement(by);
        return element;
    }

    public void sendKeys(WebDriver driver, By by, String text){
        element(driver, by).sendKeys(text);
    }


    public void click(WebDriver driver, By by){
        element(driver, by).click();
    }

}
