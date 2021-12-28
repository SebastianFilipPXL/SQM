package saucedemo.mobile.screenObjects;

import saucedemo.mobile.utils.DeviceUtil;
import saucedemo.testObject.objects.IAllObjects;
import saucedemo.testObject.objects.ILoginObject;
import saucedemo.testObject.objects.IProductObject;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class AllScreens implements IAllObjects {
    private AndroidDriver<AndroidElement> driver;

    public LoginScreen loginScreen;
    public ProductScreen productScreen;

    public AllScreens(){
        driver = DeviceUtil.createDeviceWithBrowser();
        loginScreen = new LoginScreen(driver);
        productScreen = new ProductScreen(driver);
    }

    @Override
    public ILoginObject loginObject() {
        return loginScreen;
    }

    @Override
    public IProductObject productObject() {
        return productScreen;
    }

    public void quit() {driver.quit();}

}
