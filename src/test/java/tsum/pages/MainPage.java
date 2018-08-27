package tsum.pages;

import net.serenitybdd.core.pages.PageObject;
import net.thucydides.core.annotations.DefaultUrl;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@DefaultUrl("https://www.tsum.ru")
public class MainPage extends PageObject {

    ProfilePage profilePage;

    @FindBy(xpath = "//a[@data-popup='login']")
    WebElement loginForm;

    @FindBy(xpath = "//input[@formcontrolname='email']")
    WebElement emailInput;

    @FindBy(xpath = "//input[@formcontrolname='password']")
    WebElement passInput;

    @FindBy(xpath = "//button[@type='submit']/span[text()='Войти']")
    WebElement enterButton;

    @FindBy(xpath = "//div[@class='login__result login__error']")
    WebElement loginErrorText;

    @FindBy(xpath = "//a[@href='/personal/profile/']")
    WebElement profileName;

    public void openLoginForm() {
        loginForm.click();
    }

    public void enter() {
        enterButton.click();
    }

    public void fillInEmail(String email) {
        emailInput.sendKeys(email);
    }

    public void fillInPassword(String pass) {
        passInput.sendKeys(pass);
    }

    public String getLoginErrorText() {
        return loginErrorText.getText();
    }

    public void enterProfile() {
        profileName.click();
        waitFor(profilePage.header);
    }

    public String getProfileName() {
        return profileName.getText();
    }
}