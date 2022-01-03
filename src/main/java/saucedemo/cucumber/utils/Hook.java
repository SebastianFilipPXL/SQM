package saucedemo.cucumber.utils;


import io.cucumber.java.After;
import io.cucumber.java.Before;
import saucedemo.testObject.objects.IAllObjects;
import saucedemo.testObject.utils.ObjectStrategy;

public class Hook {
    private IAllObjects objects;

    @Before
    public void setUp(){
        objects = ObjectStrategy.createTestObject();
    }

    @After
    public void tearDown(){
        objects.quit();
    }
    public  IAllObjects getObjects(){
        return objects;
    }

}
