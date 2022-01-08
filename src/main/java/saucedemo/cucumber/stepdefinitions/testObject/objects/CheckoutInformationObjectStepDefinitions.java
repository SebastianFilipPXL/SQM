package saucedemo.cucumber.stepdefinitions.testObject.objects;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import saucedemo.cucumber.utils.Hook;
import saucedemo.testObject.objects.ICheckoutInformationObject;
import saucedemo.testObject.objects.ILoginObject;

import static com.google.common.truth.Truth.assertThat;

public class CheckoutInformationObjectStepDefinitions {
    private ICheckoutInformationObject checkoutInformationObject;
    private ILoginObject loginObject;

    public CheckoutInformationObjectStepDefinitions(Hook hook){
        checkoutInformationObject = hook.getObjects().checkoutInformationObject();
        loginObject = hook.getObjects().loginObject();
    }
    @Then("the checkout page is shown")
    public void theCheckoutPageIsShown() {
        assertThat(loginObject.getURL()).contains("checkout");
    }

    @When("a user continues correctly")
    public void aUserContinuesCorrectly() {
        checkoutInformationObject.continueCorrectly("Firstname","LastName","1000");
    }


    @When("a user continues without a first name")
    public void aUserContinuesWithoutAFirstName() {
        checkoutInformationObject.continueCorrectly("","LastName","1000");
    }

    @Then("an error should be shown")
    public void anErrorShouldBeShown() {
        assertThat(loginObject.getErrormessage()).contains("required");
    }

    @When("a user continues without a last name")
    public void aUserContinuesWithoutALastName() {
        checkoutInformationObject.continueCorrectly("Firstname","","1000");
    }

    @When("a user continues without a postal code")
    public void aUserContinuesWithoutAPostalCode() {
        checkoutInformationObject.continueCorrectly("Firstname","Lastname","");
    }

    @When("a user continues without any information")
    public void aUserContinuesWithoutAnyInformation() {
        checkoutInformationObject.continueCorrectly("","","");
    }

    @When("a user clicks cancel")
    public void aUserClicksCancel() {
        checkoutInformationObject.clickCancel();
    }
}
