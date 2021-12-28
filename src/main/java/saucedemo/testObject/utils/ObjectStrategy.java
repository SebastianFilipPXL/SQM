package saucedemo.testObject.utils;

import saucedemo.mobile.screenObjects.AllScreens;
import saucedemo.testObject.objects.IAllObjects;
import saucedemo.web.pageObjects.AllPages;

public class ObjectStrategy {
    public static IAllObjects createTestObject(){
        return createTestObject(ObjectConfig.getTestObject());
    }

    public static IAllObjects createTestObject(String testObject){

        switch (testObject){
            case "web":
                return new AllPages();
            case "mobile":
                return new AllScreens();
        }
        return null;
    }
}