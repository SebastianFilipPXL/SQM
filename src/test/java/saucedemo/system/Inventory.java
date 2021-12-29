package saucedemo.system;

import org.testng.annotations.BeforeMethod;
import saucedemo.testObject.objects.IAllObjects;
import saucedemo.testObject.utils.ObjectStrategy;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import saucedemo.web.pageObjects.AllPages;

import static com.google.common.truth.Truth.assertThat;


public class Inventory {
    IAllObjects testObject;
    final String aToZFirstItem = "Sauce Labs Backpack";
    final String zToAFirstItem = "Test.allTheThings() T-Shirt (Red)";
    final String highToLowFirstItem = "Sauce Labs Fleece Jacket";
    final String lowToHighFirstItem = "Sauce Labs Onesie";
    final String username = "standard_user";
    final String password = "secret_sauce";
    //final String password = "secret_sauce";
    //final String usernameLockedOut = "locked_out_user";

    @BeforeClass
    public void testSetup(){
        testObject = ObjectStrategy.createTestObject();
        testObject.loginObject().navigateTo();
        testObject.loginObject().login(username, password);

    }

    @BeforeMethod
    public void testSetup2(){
        testObject.productObject().navigateTo();
    }


    @Test
    public void sortProductsFromAtoZ(){
        testObject.productObject().selectFilterAtoZ();
        assertThat(testObject.productObject().getFirstItemText()).contains(aToZFirstItem);
    }

    @Test
    public void sortProductsFromZtoA(){
        testObject.productObject().selectFilterZtoA();
        assertThat(testObject.productObject().getFirstItemText()).contains(zToAFirstItem);
    }

    @Test
    public void sortProductsFromHightoLow(){
        testObject.productObject().selectFilterHighToLow();
        assertThat(testObject.productObject().getFirstItemText()).contains(highToLowFirstItem);
    }

    @Test
    public void sortProductsFromLowtoHigh(){
        testObject.productObject().selectFilterLowToHigh();
        assertThat(testObject.productObject().getFirstItemText()).contains(lowToHighFirstItem);
    }

    @Test
    public void goToCartPage() {
        testObject.productObject().goToCart();
        assertThat(testObject.productObject().getURL()).startsWith("https://www.saucedemo.com/cart.html");
    }

    @Test
    public void addProductToCart() {
        testObject.productObject().addProductToCart();
        assertThat(testObject.productObject().getBackPackButtonText()).contains("REMOVE");
    }

    @Test
    public void removeProductFromCart() {
        testObject.productObject().removeProductFromCart();
        assertThat(testObject.productObject().getBackPackButtonText()).contains("ADD TO CART");
    }


    @AfterClass
    public void testTearDown(){
        testObject.quit();
    }
}
