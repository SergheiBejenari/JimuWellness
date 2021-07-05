package POM;

import POM.pages.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.DriverFactory;
import utils.PropertyReader;

import java.util.concurrent.TimeUnit;

public class Application {
    public final String url;
    private final short defaultTimeout;
    private WebDriver driver;
    private WebDriverWait wait;
    private HomePage homePage;
    private LogInPage logInPage;
    private DashBord dashBord;
    private ResetPasswordPopUp resetPasswordPopUp;
    private ResetPasswordPage resetPasswordPage;


    public Application() {
        url = PropertyReader.applicationProperties().getProperty("base.url");
        defaultTimeout = 30;
    }

    public void getPage(String url) {
        driver.get(url);
    }

    public WebDriver getDriver() {
        if (driver == null) {
            driver = new DriverFactory().getDriver();
            driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            driver.manage().window().maximize();
        }
        return driver;
    }

    public short getDefaultTimeout() {
        return defaultTimeout;
    }

    public WebDriverWait getWait() {
        if (wait == null) {
            wait = new WebDriverWait(driver, defaultTimeout);
        }
        return wait;
    }

    public void quitDriver() {
        driver.quit();
    }

    public HomePage homePage() {
        if (homePage == null) {
            homePage = new HomePage(this);
        }
        return homePage;
    }

    public LogInPage logInPage() {
        if (logInPage == null) {
            logInPage = new LogInPage(this);
        }
        return logInPage;
    }

    public ResetPasswordPopUp resetPasswordPopUp() {
        if (resetPasswordPopUp == null) {
            resetPasswordPopUp = new ResetPasswordPopUp(this);
        }
        return resetPasswordPopUp;
    }

    public ResetPasswordPage resetPasswordPage() {
        if (resetPasswordPage == null) {
            resetPasswordPage = new ResetPasswordPage(this);
        }
        return resetPasswordPage;
    }

    public DashBord dashBord() {
        if (dashBord == null) {
            dashBord = new DashBord(this);
        }
        return dashBord;
    }
}
