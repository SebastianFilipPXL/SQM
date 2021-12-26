package saucedemo.mobile.utils;
import saucedemo.common.JSONHelper;

public class MobileConfig {
    private static final String webConfigJsonFile = "src/main/java/saucedemo/mobile/mobileConfig.json";

    public static String getAppiumServer(){
        return JSONHelper.getJSONStringFromJsonFile(webConfigJsonFile, "appiumServer");
    }

    public static String getDeviceName(){
        return JSONHelper.getJSONStringFromJsonFile(webConfigJsonFile, "deviceName");
    }

    public static String getPlatformVersion(){
        return JSONHelper.getJSONStringFromJsonFile(webConfigJsonFile, "platformVersion");
    }

    public static String getPlatformName(){
        return JSONHelper.getJSONStringFromJsonFile(webConfigJsonFile, "platformName");
    }

    public static String getBaseUrl(){
        return JSONHelper.getJSONStringFromJsonFile(webConfigJsonFile, "baseUrl");
    }

    public static String getBrowserName(){
        return JSONHelper.getJSONStringFromJsonFile(webConfigJsonFile, "browserName");
    }

    public static String getChromeDriverExecutable(){
        return JSONHelper.getJSONStringFromJsonFile(webConfigJsonFile, "chromeDriverExecutable");
    }

    public static String getAppActivity(){
        return JSONHelper.getJSONStringFromJsonFile(webConfigJsonFile, "appActivity");
    }

    public static String getAppPackage(){
        return JSONHelper.getJSONStringFromJsonFile(webConfigJsonFile, "appPackage");
    }

    public static String getNoReset(){
        return JSONHelper.getJSONStringFromJsonFile(webConfigJsonFile, "noReset");
    }

    public static String getFullReset(){
        return JSONHelper.getJSONStringFromJsonFile(webConfigJsonFile, "fullReset");
    }

    public static String getDefaultTimeout(){
        return JSONHelper.getJSONStringFromJsonFile(webConfigJsonFile, "defaultTimeout");
    }
}
