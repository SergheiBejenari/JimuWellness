package POM.pages.common;

import POM.Application;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.openqa.selenium.support.ui.ExpectedConditions.elementToBeClickable;


public class BasePage {
    protected WebDriver driver;
    protected WebDriverWait wait;
    protected String baseUrl;
    protected final short defaultTimeout;

    protected BasePage(Application app) {
        this.baseUrl = app.url;
        this.driver = app.getDriver();
        this.wait = app.getWait();
        this.defaultTimeout = app.getDefaultTimeout();
        PageFactory.initElements(driver, this);
    }

    protected void type(By locator, String text) {
        driver.findElement(locator).click();
        if (text != null) {
            String existingText = driver.findElement(locator).getAttribute("value");
            if (!text.equals(existingText)) {
                wait.until(elementToBeClickable(locator));
                driver.findElement(locator).clear();
                driver.findElement(locator).sendKeys(text);
            }
        }
    }

    protected void click(By locator) {
        driver.findElement(locator).click();
    }
}
