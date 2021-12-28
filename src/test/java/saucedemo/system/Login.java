package saucedemo.system;

import org.testng.annotations.BeforeMethod;
import saucedemo.testObject.objects.IAllObjects;
import saucedemo.testObject.utils.ObjectStrategy;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import saucedemo.web.pageObjects.AllPages;

import static com.google.common.truth.Truth.assertThat;



public class Login {
    IAllObjects testObject;
    final String username = "standard_user";
    final String password = "secret_sauce";
    final String usernameLockedOut = "locked_out_user";

    @BeforeClass
    public void testSetup(){
        testObject = ObjectStrategy.createTestObject();
    }

    @BeforeMethod
    public void testSetup2(){
        testObject.loginObject().navigateTo();
    }


    @Test
    public void standardUserLogin() {
        testObject.loginObject().login(username, password);
        assertThat(testObject.loginObject().getURL().contains("inventory"));
    }

    @Test
    public void emptyUsername() {
        testObject.loginObject().login("",password);
        assertThat(testObject.loginObject().getErrormessage().contains("Epic sadface: Username is required"));
    }

    @Test
    public void emptyPassword() {
        testObject.loginObject().login(username, "");
        assertThat(testObject.loginObject().getErrormessage().contains("Epic sadface: Password is required"));
    }

    @Test
    public void incorrectUsername() {
        testObject.loginObject().login("username",password);
        assertThat(testObject.loginObject().getErrormessage().contains("Epic sadface: Username and password do not match any user in this service"));
    }

    @Test
    public void incorrectPassword() {
        testObject.loginObject().login(username,"password");
        assertThat(testObject.loginObject().getErrormessage().contains("Epic sadface: Username and password do not match any user in this service"));
    }

    @Test
    public void lockedOutUser() {
        testObject.loginObject().login(usernameLockedOut,"password");
        assertThat(testObject.loginObject().getErrormessage().contains("Epic sadface: Sorry, this user has been locked out."));
    }

    @AfterClass
    public void testTearDown(){
        testObject.quit();
    }

}
