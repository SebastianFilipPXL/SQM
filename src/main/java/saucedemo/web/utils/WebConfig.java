package saucedemo.web.utils;

import saucedemo.common.JSONHelper;

public class WebConfig {
    private static final String webConfigJsonFile = "src/main/java/saucedemo/web/webConfig.json";

    public static String getBaseUrl(){
        return JSONHelper.getJSONStringFromJsonFile(webConfigJsonFile, "baseURL");
    }

    public static String getDefaultBrowser(){
        return JSONHelper.getJSONStringFromJsonFile(webConfigJsonFile, "defaultBrowser");
    }
}