package tsum.steps;

import net.thucydides.core.annotations.Step;
import tsum.pages.MainPage;
import tsum.pages.ProfilePage;

import static org.hamcrest.MatcherAssert.assertThat;


public class LoginSteps {

    MainPage mainPage;
    ProfilePage profilePage;

    @Step
    public void open_main_page() {
        mainPage.open();
    }

    @Step
    public void open_login_form() {
        mainPage.openLoginForm();
    }

    @Step
    public void fill_in_credentials(String email, String pass) {
        mainPage.fillInEmail(email);
        mainPage.fillInPassword(pass);
    }

    @Step
    public void click_enter_button() {
        mainPage.enter();
    }

    @Step
    public void should_see_user_name_in_header() {
        assertThat("User name is displayed in header", mainPage.getProfileName().equals("Test"));
    }

    @Step
    public void goes_to_profile() {
        mainPage.enterProfile();
    }

    @Step
    public void should_see_profile_page() {
        assertThat("Header of profile page is displayed", profilePage.getHeader().equals("Мои данные"));
        assertThat("Username is displayed", profilePage.getName().equals("Test"));
        assertThat("User Email is displayed", profilePage.getEmail().equals("tempmail@pay-mon.com"));
    }

    @Step
    public void should_see_error() {
        assertThat("Login error message", mainPage.getLoginErrorText().equals("Неверный логин или пароль"));
    }
}