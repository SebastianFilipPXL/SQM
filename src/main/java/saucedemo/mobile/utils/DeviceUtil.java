package saucedemo.mobile.utils;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

public class DeviceUtil {
    public static AndroidDriver<AndroidElement> createDeviceWithBrowser(){
        return createDeviceWithBrowser(MobileConfig.getBrowserName(), MobileConfig.getChromeDriverExecutable());
    }

    public static AndroidDriver<AndroidElement> createDeviceWithBrowser(String browser, String chromeExecutablePath) {
        DesiredCapabilities desiredCapabilities = getMandatoryCapabilities();

        desiredCapabilities.setCapability(AndroidMobileCapabilityType.BROWSER_NAME, browser);
        desiredCapabilities.setCapability(AndroidMobileCapabilityType.CHROMEDRIVER_EXECUTABLE, chromeExecutablePath);

        return createDevice(desiredCapabilities);
    }

    public static AndroidDriver<AndroidElement> createDeviceWithApp(){
        return createDeviceWithApp(MobileConfig.getAppPackage(), MobileConfig.getAppActivity());
    }

    public static AndroidDriver<AndroidElement> createDeviceWithApp(String appPackage, String appActivity) {
        DesiredCapabilities desiredCapabilities = getMandatoryCapabilities();

        desiredCapabilities.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, appPackage);
        desiredCapabilities.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, appActivity);
        desiredCapabilities.setCapability(MobileCapabilityType.NO_RESET, MobileConfig.getNoReset());
        desiredCapabilities.setCapability(MobileCapabilityType.FULL_RESET, MobileConfig.getFullReset());

        return createDevice(desiredCapabilities);
    }

    public static AndroidDriver<AndroidElement> createDevice(DesiredCapabilities desiredCapabilities) {
        AndroidDriver<AndroidElement> driver;
        try {
            driver = new AndroidDriver<AndroidElement>(new URL(MobileConfig.getAppiumServer()), desiredCapabilities);
        } catch (MalformedURLException e) {
            e.printStackTrace();
            return null;
        }

        return driver;
    }

    private static DesiredCapabilities getMandatoryCapabilities(){
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setCapability(MobileCapabilityType.DEVICE_NAME, MobileConfig.getDeviceName());
        desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, MobileConfig.getPlatformName());
        desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, MobileConfig.getPlatformVersion());
        return desiredCapabilities;
    }
}
