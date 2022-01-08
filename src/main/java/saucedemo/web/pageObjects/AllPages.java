package saucedemo.web.pageObjects;

import org.openqa.selenium.Point;
import saucedemo.mobile.screenObjects.ProductOverviewScreen;
import saucedemo.testObject.objects.*;
import saucedemo.web.utils.BrowserUtil;
import org.openqa.selenium.WebDriver;

public class AllPages implements IAllObjects {
    private WebDriver driver;

    public ProductDetailPage productDetailPage;
    public LoginPage loginPage;
    public ProductPage productPage;
    public ProductOverviewPage productOverviewPage;
    public ShoppingCartPage shoppingCartPage;
    public CheckoutInformationPage checkoutInformationPage;


    public AllPages(){
        driver = BrowserUtil.createBrowser();

        loginPage = new LoginPage(driver);
        productPage = new ProductPage(driver);
        productDetailPage = new ProductDetailPage(driver);
        productOverviewPage= new ProductOverviewPage(driver);
        shoppingCartPage = new ShoppingCartPage(driver);
        checkoutInformationPage = new CheckoutInformationPage(driver);
    }

    @Override
    public ILoginObject loginObject() {
        return loginPage;
    }

    @Override
    public IProductObject productObject() {
        return productPage;
    }

    @Override
    public IProductDetailObject productDetailObject() {
        return productDetailPage;
    }

    @Override
    public IProductOverviewObject productOverviewObject() {
        return productOverviewPage;
    }
    @Override
    public IShoppingCartObject shoppingCartObject() {
        return shoppingCartPage;
    }
    @Override
    public CheckoutInformationPage checkoutInformationObject() {
        return checkoutInformationPage;
    }

    public void quit(){driver.quit();}
}
