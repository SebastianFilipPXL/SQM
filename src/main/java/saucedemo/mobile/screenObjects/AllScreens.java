package saucedemo.mobile.screenObjects;

import saucedemo.mobile.utils.DeviceUtil;
import saucedemo.testObject.objects.*;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import saucedemo.web.pageObjects.ProductDetailPage;

public class AllScreens implements IAllObjects {
    private AndroidDriver<AndroidElement> driver;

    public LoginScreen loginScreen;
    public ProductScreen productScreen;
    public ProductDetailScreen productDetailScreen;
    public ProductOverviewScreen productOverviewScreen;
    public ShoppingCartScreen shoppingCartScreen;
    public CheckoutInformationScreen checkoutInformationScreen;

    public AllScreens(){
        driver = DeviceUtil.createDeviceWithBrowser();
        loginScreen = new LoginScreen(driver);
        productScreen = new ProductScreen(driver);
        productDetailScreen = new ProductDetailScreen(driver);
        productOverviewScreen = new ProductOverviewScreen(driver);
        shoppingCartScreen = new ShoppingCartScreen(driver);
        checkoutInformationScreen = new CheckoutInformationScreen(driver);

    }

    @Override
    public ILoginObject loginObject() {
        return loginScreen;
    }

    @Override
    public IProductObject productObject() {
        return productScreen;
    }

    @Override
    public IProductDetailObject productDetailObject() {
        return productDetailScreen;
    }

    @Override
    public IProductOverviewObject productOverviewObject() {
        return productOverviewScreen;
    }

    @Override
    public IShoppingCartObject shoppingCartObject() {
        return shoppingCartScreen;
    }

    @Override
    public ICheckoutInformationObject checkoutInformationObject() {
        return checkoutInformationScreen;
    }

    public void quit() {driver.quit();}

}
