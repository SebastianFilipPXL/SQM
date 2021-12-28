package saucedemo.web;

import org.testng.annotations.*;
import saucedemo.web.pageObjects.AllPages;

import java.util.concurrent.TimeUnit;

import static com.google.common.truth.Truth.assertThat;



public class LoginTests {
    /*
    AllPages pages;
    final String username = "standard_user";
    final String password = "secret_sauce";

    @BeforeClass
    public void testSetup(){
        pages = new AllPages();
        //pages.loginPage.NavigateToPage();
    }
    @BeforeMethod
    public void testSetup2(){
        pages.loginPage.NavigateToPage();
    }


    @Test
    public void standardUserLogin() throws InterruptedException {
        pages.loginPage.Login(username, password);
        assertThat(pages.loginPage.getURL().contains("inventory"));
    }

    @Test
    public void emptyUsername() throws InterruptedException {
        pages.loginPage.Login("", password);
        assertThat(pages.loginPage.getErrorMessage().contains("Epic sadface: Username is required"));
    }
    @Test
    public void emptyPassword() throws InterruptedException {
        pages.loginPage.Login(username, "");
        assertThat(pages.loginPage.getErrorMessage().contains("Epic sadface: Password is required"));
    }

    @Test
    public void incorrectUsername() throws InterruptedException {
        pages.loginPage.Login("username", password);
        assertThat(pages.loginPage.getErrorMessage().contains("Epic sadface: Username and password do not match any user in this service"));
    }

    // incorrect password + locked out user

    */





    /*
    @Test
    public void emptyPassword(){
        pages.loginPage.login(username, "");
        System.out.println(pages.loginPage.getErrormessage());
    }

    @Test
    public void emptyUsernamePassword(){
        pages.loginPage.login("", "");
        System.out.println(pages.loginPage.getErrormessage());
    }

    @Test
    public void incorrectUsername(){
        pages.loginPage.login("username", password);
        System.out.println(pages.loginPage.getErrormessage());
    }

    @Test
    public void incorrectPassword(){
        pages.loginPage.login(username, "password");
        System.out.println(pages.loginPage.getErrormessage());
    }

    @Test(priority = 1)
    public void correctLogin(){
        pages.loginPage.login(username, password);
        System.out.println(pages.secureAreaPage.getSuccessMessage());
    } */







 /*
    @AfterClass
    public void testTeardown(){
        pages.closeBrowser();
    }*/
}
