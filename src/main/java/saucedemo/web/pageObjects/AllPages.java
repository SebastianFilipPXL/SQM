package saucedemo.web.pageObjects;

import org.openqa.selenium.Point;
import saucedemo.testObject.objects.IAllObjects;
import saucedemo.testObject.objects.ILoginObject;
import saucedemo.testObject.objects.IProductObject;
import saucedemo.web.utils.BrowserUtil;
import org.openqa.selenium.WebDriver;

public class AllPages implements IAllObjects {
    private WebDriver driver;

    public LoginPage loginPage;
    public ProductPage productPage;


    public AllPages(){
        driver = BrowserUtil.createBrowser();

        loginPage = new LoginPage(driver);
        productPage = new ProductPage(driver);
    }

    @Override
    public ILoginObject loginObject() {
        return loginPage;
    }

    @Override
    public IProductObject productObject() {
        return productPage;
    }

    public void quit(){driver.quit();}
}
