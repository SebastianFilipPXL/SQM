package saucedemo.mobile.screenObjects;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import saucedemo.testObject.objects.IShoppingCartObject;

public class ShoppingCartScreen extends BaseScreen implements IShoppingCartObject{
    private final By checkoutButton = By.xpath("//*[@id=\"checkout\"]");
    private final By continueShoppingButton = By.xpath("//*[@id=\"continue-shopping\"]");
    private final By removeItemButton = By.xpath("//*[@id=\"remove-sauce-labs-backpack\"]");

    public ShoppingCartScreen(AndroidDriver<AndroidElement> driver){
        super(driver, "cart.html");
    }


    @Override
    public void clickCheckout(){
        WebElement checkoutElement = driver.findElement(checkoutButton);
        checkoutElement.click();
    }

    @Override
    public void clickContinueShopping() {
        WebElement continueShoppingElement = driver.findElement(continueShoppingButton);
        continueShoppingElement.click();
    }

    @Override
    public void removeItem(){
        WebElement removeItemElement = driver.findElement(removeItemButton);
        removeItemElement.click();
    }
}
