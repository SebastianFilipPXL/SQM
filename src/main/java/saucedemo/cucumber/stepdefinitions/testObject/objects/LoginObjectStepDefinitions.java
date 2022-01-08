package saucedemo.cucumber.stepdefinitions.testObject.objects;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import saucedemo.cucumber.utils.Hook;
import saucedemo.testObject.objects.ILoginObject;

import static com.google.common.truth.Truth.assertThat;

public class LoginObjectStepDefinitions {
    private ILoginObject loginObject;

    public LoginObjectStepDefinitions(Hook hook) {
        loginObject = hook.getObjects().loginObject();
    }


    @When("a valid user logs in")
    public void a_valid_user_logs_in() {
        loginObject.login("standard_user", "secret_sauce");
    }

    @When("a user tries to login without a password")
    public void a_user_tries_to_login_without_a_password() {
        loginObject.login("standard_user", "");
    }

    @When("a user tries to login without a username")
    public void a_user_tries_to_login_without_a_username() {
        loginObject.login("", "secret_sauce");
    }

    @When("a user tries to login with a wrong password")
    public void aUserTriesToLoginWithAWrongPassword() {
        loginObject.login("standard_user", "I_Love_Cats");
    }

    @When("a locked out user tries to login")
    public void aLockedOutUserTriesToLogin() {
        loginObject.login("locked_out_user", "secret_sauce");
    }

    @When("a user tries to login with a wrong username")
    public void aUserTriesToLoginWithAWrongUsername() {
        loginObject.login("harry", "secret_sauce");
    }

    @Then("the login page is shown with an error")
    public void the_login_page_is_shown_with_an_error() {
        assertThat(loginObject.getErrormessage()).contains(" ");
    }
}


