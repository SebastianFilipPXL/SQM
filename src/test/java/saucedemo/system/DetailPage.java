package saucedemo.system;

import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeMethod;
import saucedemo.testObject.objects.IAllObjects;
import saucedemo.testObject.utils.ObjectStrategy;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import saucedemo.web.pageObjects.AllPages;

import static com.google.common.truth.Truth.assertThat;

public class DetailPage {
    IAllObjects testObject;


    final String username = "standard_user";
    final String password = "secret_sauce";


    @BeforeClass
    public void testSetup(){
        testObject = ObjectStrategy.createTestObject();
        testObject.loginObject().navigateTo();
        testObject.loginObject().login(username, password);
        testObject.productObject().clickBackPack();
    }

    @Test
    public void addProductToCart() {
        testObject.productDetailObject().addProductToCart();
        assertThat(testObject.productDetailObject().getBackPackButtonText()).contains("REMOVE");
    }

    @Test
    public void removeProductFromCart() {
        testObject.productDetailObject().removeProductFromCart();
        assertThat(testObject.productDetailObject().getBackPackButtonText()).contains("ADD TO CART");
    }

    @Test
    public void backToProducts() {
        testObject.productDetailObject().goBackToProducts();
        assertThat(testObject.productObject().getURL()).startsWith("https://www.saucedemo.com/inventory.html");
    }

    @Test
    public void correctItemOpened() {
        testObject.productDetailObject().navigateTo();
        assertThat(testObject.productDetailObject().getProductName()).contains("Sauce Labs Backpack");

    }

    @AfterClass
    public void testTearDown(){
        testObject.quit();
    }
}
