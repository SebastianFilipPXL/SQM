package saucedemo.system;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import saucedemo.testObject.objects.IAllObjects;
import saucedemo.testObject.utils.ObjectStrategy;

import static com.google.common.truth.Truth.assertThat;

public class ShoppingCartPage {
    IAllObjects testObject;
    final String username = "standard_user";
    final String password = "secret_sauce";
    final String usernameLockedOut = "locked_out_user";

    @BeforeClass
    public void testSetup(){
        testObject = ObjectStrategy.createTestObject();
        testObject.loginObject().navigateTo();
        testObject.loginObject().login(username, password);
    }

    @BeforeMethod
    public void testSetup2(){
        testObject.productObject().goToCart();
    }

    @Test
    public void clickCheckout() {
        testObject.shoppingCartObject().clickCheckout();
        assertThat(testObject.loginObject().getURL()).contains("checkout-step-one");
    }

    @Test
    public void clickContinueShopping() {
        testObject.shoppingCartObject().clickContinueShopping();
        assertThat(testObject.loginObject().getURL()).contains("inventory");
    }

    @Test
    public void clickRemoveItem() {
        boolean exceptionThrown = false;
        testObject.shoppingCartObject().clickContinueShopping();
        testObject.productObject().addProductToCart();
        testObject.productObject().goToCart();
        testObject.shoppingCartObject().removeItem();
        try {
            testObject.shoppingCartObject().removeItem();
        }catch (org.openqa.selenium.NoSuchElementException ex){
            exceptionThrown = true;
        }
        assertThat(exceptionThrown).isTrue();
    }

    @AfterClass
    public void testTearDown(){
        testObject.quit();
    }
}
