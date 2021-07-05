package tests;

import POM.Application;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import java.time.Duration;

import static org.testng.AssertJUnit.assertEquals;

public class Test {
    private final Application app = new Application();
    private final String expectedURL = app.url + "/dashboard";
    private final String email = "z4yr1d3@esiix.com";
    private final String password = "Gds@1#63422";

    @BeforeSuite
    public void getHomePage() {
        app.homePage().openHomePage();
    }

    @AfterSuite
    public void quitDriver() {
        app.quitDriver();
    }

    @org.testng.annotations.Test()
    protected void logInTestNegative() {
        app.homePage().clickToLogInButton();
        app.logInPage().logIn(email, password);
        assertEquals(app.logInPage().isErrorMessagePresent(), "Credenciais de login inválidas\nclose");
    }

    @org.testng.annotations.Test()
    public void resetPasswordAndLogInWithNewPassword() {
        app.logInPage().resetPassword();
        app.resetPasswordPopUp().typeIntoEmailField();
        app.requests().getIdFromResponse();
        app.requests().getEmailBody();
        app.getPage(app.url + "/reset-password/" + app.requests().getKey());
        app.resetPasswordPage().typeIntoResetPassword(password, password);
        app.homePage().clickToLogInButton();
        app.getWait().withTimeout(Duration.ofSeconds(10));
        app.logInPage().logIn(email, password);
        app.getWait().until(ExpectedConditions.urlToBe(expectedURL));
        assertEquals(app.getDriver().getCurrentUrl(), expectedURL);
    }
}
