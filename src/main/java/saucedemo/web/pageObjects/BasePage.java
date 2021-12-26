package saucedemo.web.pageObjects;

import org.openqa.selenium.WebDriver;
import saucedemo.web.utils.WebConfig;

public class BasePage {
    protected WebDriver driver;
    protected String url;

    public BasePage(WebDriver driver, String endpoint){
        this.driver = driver;
        url = WebConfig.getBaseUrl() + endpoint;
    }
    public void NavigateToPage(){
        this.driver.get(url);
    }
}
