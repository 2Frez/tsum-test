package tsum.features.auth;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import tsum.steps.LoginSteps;

import static net.thucydides.core.annotations.ClearCookiesPolicy.BeforeEachTest;

@RunWith(SerenityRunner.class)
public class Login {

    @Managed(driver="chrome", clearCookies=BeforeEachTest)
    WebDriver driver;

    @Steps
    LoginSteps user;

    @Test
    public void login_with_existing_email_and_password() {
        user.open_main_page();
        user.open_login_form();
        user.fill_in_credentials("tempmail@pay-mon.com", "1234567890");
        user.click_enter_button();
        user.should_see_user_name_in_header();
        user.goes_to_profile();
        user.should_see_profile_page();
    }

    @Test
    public void login_with_wrong_email_and_password() {
        user.open_main_page();
        user.open_login_form();
        user.fill_in_credentials("test@test.ru", "12345678");
        user.click_enter_button();
        user.should_see_error();
    }
}