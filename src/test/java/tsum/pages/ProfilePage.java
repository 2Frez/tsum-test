package tsum.pages;

import net.serenitybdd.core.pages.PageObject;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProfilePage extends PageObject {

    @FindBy(xpath = "//div[@class='inner__main']/h1")
    WebElement header;

    @FindBy(xpath = "//input[@name='FIELDS[NAME]']")
    WebElement name;

    @FindBy(xpath = "//input[@name='FIELDS[EMAIL]']")
    WebElement email;

    public String getHeader() {
        return header.getText();
    }

    public String getName() {
        return name.getAttribute("value");
    }

    public String getEmail() {
        return email.getAttribute("value");
    }
}