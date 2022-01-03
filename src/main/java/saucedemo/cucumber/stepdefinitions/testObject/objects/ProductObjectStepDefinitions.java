package saucedemo.cucumber.stepdefinitions.testObject.objects;

import io.cucumber.java.en.Then;
import saucedemo.cucumber.utils.Hook;
import saucedemo.testObject.objects.IProductObject;
import static com.google.common.truth.Truth.assertThat;

public class ProductObjectStepDefinitions {
    private IProductObject productObject;

    public ProductObjectStepDefinitions(Hook hook){
      productObject = hook.getObjects().productObject();
    }

    @Then("the inventory page is shown")
    public void the_product_page_is_shown() {
        assertThat(productObject.getFirstItemText().contains("Backpack"));

    }
}