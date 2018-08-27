package tsum.steps;

import net.thucydides.core.annotations.Step;
import tsum.pages.ForgotPage;

import static org.hamcrest.MatcherAssert.assertThat;

public class RecoverySteps {

    ForgotPage forgotPage;

    @Step
    public void open_pass_recovery_page() {
        forgotPage.open();
    }

    @Step
    public void fill_in_email(String email) {
        forgotPage.fillInEmail(email);
    }

    @Step
    public void click_send_button() {
        forgotPage.sendPassword();
    }

    @Step
    public void should_see_error() {
        assertThat("Displayed message: Login and EMail not found", forgotPage.getErrorText().
                equals("Логин или EMail не найдены."));
    }

    @Step
    public void should_see_notice() {
        assertThat("Displayed message: Information letter was sent", forgotPage.getNoteText()
                .equals("Контрольная строка, а также ваши регистрационные данные были высланы по E-Mail. " +
                        "Пожалуйста, дождитесь письма, так как контрольная строка изменяется при каждом запросе."));
    }
}