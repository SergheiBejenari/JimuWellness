package POM.pages;

import POM.Application;
import POM.pages.common.BasePage;
import io.qameta.allure.Step;
import lombok.Getter;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

@Getter
public class ResetPasswordPage extends BasePage {

    private final By passwordField = By.cssSelector("#password");
    private final By confirmPasswordField = By.cssSelector("#confirm-password");
    private final By submitButton = By.cssSelector("button[type='submit']");
    private final By closePopUp = By.cssSelector(".modal__form__close");
    private final By successMessage = By.xpath("//div[@class='modal__form__title modal__form__title--success']");

    public ResetPasswordPage(Application app) {
        super(app);
    }

    @Step("type into reset password tab with credentials password: {newPassword} confirm password: {confirmPassword}")
    public void submitNewPassword(String newPassword, String confirmPassword) {
        type(passwordField, newPassword);
        type(confirmPasswordField, confirmPassword);
        click(submitButton);
        wait.until(ExpectedConditions.visibilityOfElementLocated(successMessage));
        driver.navigate().refresh();
        click(closePopUp);
    }

}
