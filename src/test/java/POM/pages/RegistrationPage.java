package POM.pages;

import POM.Application;
import POM.pages.common.BasePage;
import lombok.Getter;
import org.openqa.selenium.By;

@Getter
public class RegistrationPage extends BasePage {

    private final By emailField = By.cssSelector("#email");
    private final By passwordField = By.cssSelector("#password");
    private final By confirmPasswordField = By.cssSelector("#confirm-password");
    private final By confirmationCheckBox = By.cssSelector("label[for='subscription']");
    private final By submitButton = By.cssSelector("button[type='submit']");
    private final By successMessage = By.cssSelector(".modal__form__title.modal__form__title--success");

    public RegistrationPage(Application app) {
        super(app);
    }

}
