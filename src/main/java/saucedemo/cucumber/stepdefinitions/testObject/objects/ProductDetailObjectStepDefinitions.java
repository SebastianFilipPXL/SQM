package saucedemo.cucumber.stepdefinitions.testObject.objects;


import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import saucedemo.cucumber.utils.Hook;
import saucedemo.testObject.objects.IProductDetailObject;

import static com.google.common.truth.Truth.assertThat;


public class ProductDetailObjectStepDefinitions {

    private IProductDetailObject productDetailObject;

    public ProductDetailObjectStepDefinitions(Hook hook){

        productDetailObject = hook.getObjects().productDetailObject();
    }

    @Then("the right details page is shown")
    public void theRightDetailsPageIsShown() {
        assertThat(productDetailObject.getProductName()).contains("Sauce Labs Backpack");
    }

    @When("a user clicks on the back to products button")
    public void aUserClicksOnTheBackToProductsButton() {
        productDetailObject.goBackToProducts();
    }

    @When("a user adds an item to the cart on details")
    public void aUserAddsAnItemToTheCartOnDetails() {
        productDetailObject.addProductToCart();
    }

    @Then("the item is added to the cart on details")
    public void theItemIsAddedToTheCartOnDetails() {
        assertThat(productDetailObject.getBackPackButtonText()).contains("REMOVE");
    }

    @When("a user removes an item from the cart on details")
    public void aUserRemovesAnItemFromTheCartOnDetails() {
        productDetailObject.removeProductFromCart();
    }

    @Then("the item is removed from the cart on details")
    public void theItemIsRemovedFromTheCartOnDetails() {
        assertThat(productDetailObject.getBackPackButtonText()).contains("ADD TO CART");
    }

}
