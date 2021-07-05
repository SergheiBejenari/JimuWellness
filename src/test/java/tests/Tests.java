package tests;

import org.testng.annotations.Test;
import utils.Requests;

import static org.testng.AssertJUnit.assertEquals;

public class Tests extends TestBase {
    private final Requests requests = new Requests();
    private final String email = "z4yr1d3@esiix.com";
    private final String password = "Hge^%#kjw8978d";

    @Test
    protected void logInTestNegative() {
        app.homePage().openHomePage();
        app.homePage().clickLogInButton();
        app.logInPage().logIn(email, password);
        assertEquals(app.logInPage().getErrorMessage(), "Credenciais de login inválidas\nclose");
    }

    @Test
    public void resetPasswordAndLogInWithNewPassword() {
        app.logInPage().clickToResetPasswordButton();
        app.resetPasswordPopUp().typeIntoEmailField(email);
        requests.getIdFromResponse();
        requests.getEmailBody();
        app.getPage(app.url + "/reset-password/" + requests.getKey());
        app.resetPasswordPage().submitNewPassword(password, password);
        app.homePage().clickLogInButton();
        app.logInPage().logIn(email, password);
        app.dashBord().waitForDisplayed();
    }
}
