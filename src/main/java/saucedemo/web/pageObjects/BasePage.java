package saucedemo.web.pageObjects;

import org.openqa.selenium.WebDriver;
import saucedemo.testObject.objects.IBaseObject;
import saucedemo.web.utils.WebConfig;

public class BasePage implements IBaseObject {
    protected WebDriver driver;
    protected String url;

    public BasePage(WebDriver driver, String endpoint){
        this.driver = driver;
        url = WebConfig.getBaseUrl() + endpoint;
    }

    @Override
    public void navigateTo() {
        this.driver.get(url);
    }
}
