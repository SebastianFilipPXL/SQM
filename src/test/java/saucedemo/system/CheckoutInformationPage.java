package saucedemo.system;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import saucedemo.testObject.objects.IAllObjects;
import saucedemo.testObject.utils.ObjectStrategy;

import static com.google.common.truth.Truth.assertThat;

public class CheckoutInformationPage {
    IAllObjects testObject;
    final String username = "standard_user";
    final String password = "secret_sauce";
    final String usernameLockedOut = "locked_out_user";

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
    }

    @Test
    public void clickCancel() {
        testObject.checkoutInformationObject().clickCancel();
        assertThat(testObject.loginObject().getURL()).contains("cart");
    }

    @Test
    public void correctContinue() {
        testObject.checkoutInformationObject().continueCorrectly("Firstname", "Lastname", "1000");
        assertThat(testObject.loginObject().getURL()).contains("checkout-step-two");
    }

    @Test
    public void emptyFirstNameContinue() {
        testObject.checkoutInformationObject().continueCorrectly("", "Lastname", "1000");
        assertThat(testObject.loginObject().getErrormessage()).contains("Error: First Name is required");
    }

    @Test
    public void emptyLastNameContinue() {
        testObject.checkoutInformationObject().continueCorrectly("Firstname", "", "1000");
        assertThat(testObject.loginObject().getErrormessage()).contains("Error: Last Name is required");
    }

    @Test
    public void emptyPostalCodeContinue() {
        testObject.checkoutInformationObject().continueCorrectly("Firstname", "Lastname", "");
        assertThat(testObject.loginObject().getErrormessage()).contains("Error: Postal Code is required");
    }

    @Test
    public void emptyFormContinue() {
        testObject.checkoutInformationObject().continueCorrectly("", "", "");
        assertThat(testObject.loginObject().getErrormessage()).contains("Error: First Name is required");
    }

    @AfterClass
    public void testTearDown(){
        testObject.quit();
    }
}
