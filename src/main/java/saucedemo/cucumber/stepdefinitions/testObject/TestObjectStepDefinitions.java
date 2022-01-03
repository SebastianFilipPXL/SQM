package saucedemo.cucumber.stepdefinitions.testObject;


import io.cucumber.java.en.Given;
import saucedemo.cucumber.utils.Hook;
import saucedemo.testObject.objects.IAllObjects;
import saucedemo.testObject.utils.ObjectStrategy;

public class TestObjectStepDefinitions {

    private IAllObjects allObjects;

    public TestObjectStepDefinitions(Hook hook){
        allObjects = hook.getObjects();
    }

    @Given("the saucedemo.com is opened")
    public void the_saucedemo_com_is_opened() {
       allObjects.loginObject().navigateTo();
    }
}
