package saucedemo.mobile.screenObjects;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import saucedemo.testObject.objects.IProductDetailObject;
import saucedemo.testObject.objects.IProductObject;

public class ProductDetailScreen extends BaseScreen implements IProductDetailObject {


    private final By backpackAddButton = By.xpath("//*[@id=\"add-to-cart-sauce-labs-backpack\"]");
    private final By backpackRemoveButton = By.xpath("//*[@id=\"remove-sauce-labs-backpack\"]");
    private final By backToProductsButton = By.xpath("//*[@id=\"back-to-products\"]");
    private final By backpackNameClass = By.xpath("//*[@id=\"inventory_item_container\"]/div/div/div[2]/div[1]");


    public ProductDetailScreen(AndroidDriver<AndroidElement> driver){
        super(driver, "inventory-item.html?id=4");
    }

    // set methods that do stuff --> vb


    public void addProductToCart(){
        WebElement backpackAddButtonElement = driver.findElement(backpackAddButton);
        backpackAddButtonElement.click();
    }


    public void removeProductFromCart(){
        WebElement backpackRemoveButtonElement = driver.findElement(backpackRemoveButton);
        backpackRemoveButtonElement.click();
    }


    public void goBackToProducts(){
        WebElement backToProducts = driver.findElement(backToProductsButton);
        backToProducts.click();
    }

    public String getProductName(){
        WebElement backBackNameElement = driver.findElement(backpackNameClass);
        return backBackNameElement.getText();
    }

    public String getBackPackButtonText(){
        try {
            WebElement backpackAddButtonElement = driver.findElement(backpackAddButton);
            return backpackAddButtonElement.getText();
        }catch (org.openqa.selenium.NoSuchElementException ex){
            WebElement backpackRemoveButtonElement = driver.findElement(backpackRemoveButton);
            return backpackRemoveButtonElement.getText();
        }
    }

}