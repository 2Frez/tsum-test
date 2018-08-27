package tsum.pages;

import net.serenitybdd.core.pages.PageObject;
import net.thucydides.core.annotations.DefaultUrl;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@DefaultUrl("https://www.tsum.ru/password/forgot/")
public class ForgotPage extends PageObject {

    @FindBy(xpath = "//input[@name=\"USER_LOGIN\"][1]")
    WebElement emailInput;

    @FindBy(xpath = "//input[@name='send_account_info']")
    WebElement sendPassButton;

    @FindBy(xpath = "//font[@class='errortext']")
    WebElement errorText;

    @FindBy(xpath = "//font[@class='notetext']")
    WebElement noteText;

    public void fillInEmail(String email) {
        emailInput.sendKeys(email);
    }

    public void sendPassword() {
        sendPassButton.click();
    }

    public String getErrorText() {
        return errorText.getText();
    }

    public String getNoteText() {
        return noteText.getText();
    }
}
