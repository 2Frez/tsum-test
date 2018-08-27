package tsum.features.auth;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import tsum.steps.RecoverySteps;

@RunWith(SerenityRunner.class)
public class PasswordRecovery {

    @Managed(driver = "chrome")
    WebDriver driver;

    @Steps
    RecoverySteps user;

    @Test
    public void request_password_for_registered_email() {
        user.open_pass_recovery_page();
        user.fill_in_email("test@test.ru");
        user.click_send_button();
        user.should_see_notice();
    }

    @Test
    public void request_password_for_not_registered_email() {
        user.open_pass_recovery_page();
        user.fill_in_email("abc@def.gh");
        user.click_send_button();
        user.should_see_error();
    }
}