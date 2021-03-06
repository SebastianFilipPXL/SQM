package saucedemo.mobile.screenObjects;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class InventoryScreen extends BaseScreen{
    private final By shoppingkartCnt = By.xpath("//*[@id='shopping_cart_container']");
    private  final By tittleTxt = By.xpath("//*[@class='title']");

    public InventoryScreen(AndroidDriver<AndroidElement> driver){
        super(driver, "/inventory");
    }

    // set methods that do stuff --> vb

    public String getSuccessMessage() {
        return driver.findElement(tittleTxt).getText();
    }

    public void logout() {
        driver.findElement(shoppingkartCnt).click();
    }
}
