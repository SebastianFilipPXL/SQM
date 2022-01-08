package saucedemo.cucumber.stepdefinitions.testObject.objects;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import saucedemo.cucumber.utils.Hook;
import static com.google.common.truth.Truth.assertThat;

import saucedemo.testObject.objects.IAllObjects;
import saucedemo.testObject.objects.ILoginObject;
import saucedemo.testObject.objects.IShoppingCartObject;

public class ShoppingCartObjectStepDefinitons {
        private IShoppingCartObject shoppingCartObject;
        private ILoginObject loginObject;

        public ShoppingCartObjectStepDefinitons(Hook hook) {
           shoppingCartObject = hook.getObjects().shoppingCartObject();
           loginObject = hook.getObjects().loginObject();
        }
    @Then("the cart page is shown")
    public void the_cart_page_is_shown() {
        assertThat(loginObject.getURL()).contains("cart");
    }


    @When("a user clicks continue shopping")
    public void aUserClicksContinueShopping() {
            shoppingCartObject.clickContinueShopping();
    }

    @When("a user tries to remove an item")
    public void aUserTriesToRemoveAnItem() {
            shoppingCartObject.removeItem();
    }

    @Then("the item is removed from the cart page")
    public void theItemIsRemovedFromTheCartPage() {
        boolean exceptionThrown = false;
        try {
            shoppingCartObject.removeItem();
        }catch (org.openqa.selenium.NoSuchElementException ex){
            exceptionThrown = true;
        }
        assertThat(exceptionThrown).isTrue();
    }


    @When("a user clicks checkout")
    public void aUserClicksCheckout() {
            shoppingCartObject.clickCheckout();
    }
}
