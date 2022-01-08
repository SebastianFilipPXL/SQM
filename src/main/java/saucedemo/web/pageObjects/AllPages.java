package saucedemo.web.pageObjects;

import org.openqa.selenium.Point;
import saucedemo.testObject.objects.IAllObjects;
import saucedemo.testObject.objects.ILoginObject;
import saucedemo.testObject.objects.IProductObject;
import saucedemo.testObject.objects.IProductDetailObject;
import saucedemo.web.utils.BrowserUtil;
import org.openqa.selenium.WebDriver;

public class AllPages implements IAllObjects {
    private WebDriver driver;

    public ProductDetailPage productDetailPage;
    public LoginPage loginPage;
    public ProductPage productPage;


    public AllPages(){
        driver = BrowserUtil.createBrowser();

        loginPage = new LoginPage(driver);
        productPage = new ProductPage(driver);
        productDetailPage = new ProductDetailPage(driver);
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

    public void quit(){driver.quit();}
}
