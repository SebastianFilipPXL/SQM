package saucedemo.mobile.screenObjects;

import io.appium.java_client.android.AndroidElement;
import org.openqa.selenium.WebDriver;
import saucedemo.mobile.utils.MobileConfig;
import saucedemo.testObject.objects.IBaseObject;
import saucedemo.web.utils.WebConfig;
import io.appium.java_client.android.AndroidDriver;

public class BaseScreen implements IBaseObject {
    protected AndroidDriver<AndroidElement> driver;
    protected String url;

    public BaseScreen(AndroidDriver<AndroidElement> driver, String endpoint){
        this.driver = driver;
        url = MobileConfig.getBaseUrl() + endpoint;
    }

    public void navigateTo(){
        this.driver.get(url);
    }
}
