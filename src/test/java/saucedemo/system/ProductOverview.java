package saucedemo.system;

import org.testng.annotations.BeforeMethod;
import saucedemo.testObject.objects.IAllObjects;
import saucedemo.testObject.utils.ObjectStrategy;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import saucedemo.web.pageObjects.AllPages;

import static com.google.common.truth.Truth.assertThat;

public class ProductOverview {
    IAllObjects testObject;
    final String username = "standard_user";
    final String password = "secret_sauce";

    @BeforeClass
    public void testSetup(){
        testObject = ObjectStrategy.createTestObject();
        testObject.loginObject().navigateTo();
        testObject.loginObject().login(username, password);
        testObject.productObject().addProductToCart();

    }

    @BeforeMethod
    public void testSetup2(){
        testObject.productObject().goToCart();
        testObject.shoppingCartObject().clickCheckout();
        testObject.checkoutInformationObject().continueCorrectly("Jos","bob","4040");
    }


    @Test
    public void cancelOrder() {
        testObject.productOverviewObject().cancelOrder();
        assertThat(testObject.productObject().getURL()).startsWith("https://www.saucedemo.com/inventory.html");
    }

    @Test
    public void finishOrder() {
        testObject.productOverviewObject().finishOrder();
        assertThat(testObject.productObject().getURL()).startsWith("https://www.saucedemo.com/checkout-complete.html");
    }

    @AfterClass
    public void testTearDown(){
        testObject.quit();
    }

}
