package saucedemo.cucumber.stepdefinitions.testObject.objects;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import saucedemo.cucumber.utils.Hook;
import saucedemo.testObject.objects.ILoginObject;
import saucedemo.testObject.objects.IProductOverviewObject;

import static com.google.common.truth.Truth.assertThat;


public class ProductOverviewObjectStepDefinitions {
    private IProductOverviewObject productOverviewObject;
    private ILoginObject loginObject;

    public ProductOverviewObjectStepDefinitions(Hook hook){
         productOverviewObject = hook.getObjects().productOverviewObject();
         loginObject = hook.getObjects().loginObject();
    }
    @Then("the Product Overview Page is shown")
    public void theProductOverviewPageIsShown() {
        assertThat(loginObject.getURL()).contains("checkout-step-two");
    }

    @Then("the checkout complete page is shown")
    public void theCheckoutCompletePageIsShown() {
        assertThat(loginObject.getURL()).contains("checkout-complete");
    }

    @When("a user cancels the order")
    public void aUserCancelsTheOrder() {
        productOverviewObject.cancelOrder();
    }

    @When("a user finishes the order")
    public void aUserFinishesTheOrder() {
        productOverviewObject.finishOrder();
    }
}
