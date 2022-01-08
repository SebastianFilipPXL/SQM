package saucedemo.mobile.screenObjects;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import saucedemo.testObject.objects.IProductObject;
import saucedemo.testObject.objects.IProductOverviewObject;

public class ProductOverviewScreen extends BaseScreen implements IProductOverviewObject {

    private final By cancelButton = By.xpath("//*[@id=\"cancel\"]");
    private final By finishButton = By.xpath("//*[@id=\"finish\"]");



    public ProductOverviewScreen(AndroidDriver<AndroidElement> driver){ super(driver, "checkout-step-two.html");}

    // set methods that do stuff --> vb

    public void cancelOrder(){
        WebElement cancelElement = driver.findElement(cancelButton);
        cancelElement.click();
    }
    public void finishOrder(){
        WebElement finishElement = driver.findElement(finishButton);
        finishElement.click();
    }
}
