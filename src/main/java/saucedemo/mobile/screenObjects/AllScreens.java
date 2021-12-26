package saucedemo.mobile.screenObjects;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import saucedemo.mobile.utils.DeviceUtil;

public class AllScreens {
    private AndroidDriver<AndroidElement> driver;

    public LoginScreen loginScreen;
    public InventoryScreen inventoryScreen;

    public AllScreens(){
        driver = DeviceUtil.createDeviceWithBrowser();
        loginScreen = new LoginScreen(driver);
        inventoryScreen = new InventoryScreen(driver);
    }

    public void closeBrowser() {driver.quit();}

}
