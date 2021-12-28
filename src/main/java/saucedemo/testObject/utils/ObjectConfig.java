package saucedemo.testObject.utils;

import saucedemo.common.JSONHelper;

public class ObjectConfig {
    private static final String testConfigJsonFile = "src/main/java/saucedemo/testConfig.json";

    public static String getTestObject(){
        String testObject = System.getProperty("testObject");
        if (testObject != null){
            return testObject;
        } else {
            return getDefaultTestObject();
        }
    }

    public static String getDefaultTestObject(){
        return JSONHelper.getJSONStringFromJsonFile(testConfigJsonFile, "defaultTestObject");
    }
}
