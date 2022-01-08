package saucedemo.cucumber.stepdefinitions.testObject.objects;


import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import saucedemo.cucumber.utils.Hook;
import saucedemo.testObject.objects.IProductObject;
import static com.google.common.truth.Truth.assertThat;

public class ProductObjectStepDefinitions {
    private final IProductObject productObject;

    public ProductObjectStepDefinitions(Hook hook){
      productObject = hook.getObjects().productObject();
    }

    @Then("the inventory page is shown")
    public void the_product_page_is_shown() {
        assertThat(productObject.getFirstItemText()).contains("Backpack");

    }

    @When("a user sorts products from A to Z")
    public void aUserSortsProductsFromAToZ() {
        productObject.selectFilterAtoZ();
    }

    @Then("objects should be sorted from A to Z")
    public void objectsShouldBeSortedFromAToZ() {
        assertThat(productObject.getFirstItemText()).contains("Sauce Labs Backpack");
    }

    @When("a user sorts products from Z to A")
    public void aUserSortsProductsFromZToA() {
        productObject.selectFilterZtoA();
    }

    @Then("objects should be sorted from Z to A")
    public void objectsShouldBeSortedFromZToA() {
        assertThat(productObject.getFirstItemText()).contains("Test.allTheThings() T-Shirt (Red)");
    }

    @When("a user sorts products from Price High to Low")
    public void aUserSortsProductsFromPriceHighToLow() {
        productObject.selectFilterHighToLow();
    }

    @Then("objects should be sorted from High To Low Price")
    public void objectsShouldBeSortedFromHighToLowPrice() {
        assertThat(productObject.getFirstItemText()).contains("Sauce Labs Fleece Jacket");
    }

    @When("a user sorts products from Price Low to High")
    public void aUserSortsProductsFromPriceLowToHigh() {
       productObject.selectFilterLowToHigh();
    }

    @Then("objects should be sorted from Low to High Price")
    public void objectsShouldBeSortedFromLowToHighPrice() {
        assertThat(productObject.getFirstItemText()).contains("Sauce Labs Onesie");
    }

    @When("a user adds an item to the cart")
    public void aUserAddsAnItemToTheCart() {
        productObject.addProductToCart();
    }
    @Then("the item is added to the cart")
    public void the_item_is_added_to_the_cart() {
        assertThat(productObject.getBackPackButtonText()).contains("REMOVE");
    }

    @When("a user removes an item from the cart")
    public void aUserRemovesAnItemFromTheCart() {
        productObject.removeProductFromCart();
    }

    @Then("the item is removed from the cart")
    public void theItemIsRemovedFromTheCart() {
        assertThat(productObject.getBackPackButtonText()).contains("ADD TO CART");
    }

    @When("a user clicks the cart")
    public void aUserClicksTheCart() {
        productObject.goToCart();
    }

    @When("a user clicks the details page")
    public void aUserClicksTheDetailsPage() {
        productObject.clickBackPack();
    }
}