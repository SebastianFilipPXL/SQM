package saucedemo.mobile.screenObjects;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import saucedemo.testObject.objects.IProductObject;

public class ProductScreen extends BaseScreen implements IProductObject {

    private final By filterContainer = By.xpath("//*[@id=\"header_container\"]/div[2]/div[2]/span/select");
    private final By itemName = By.xpath("//*[@id=\"inventory_container\"]/div/div[1]/div[2]/div[1]");
    private final By shoppingCartContainer = By.xpath("//*[@id=\"shopping_cart_container\"]");
    private final By backpackAddButton = By.xpath("//*[@id=\"add-to-cart-sauce-labs-backpack\"]");
    private final By backpackRemoveButton = By.xpath("//*[@id=\"remove-sauce-labs-backpack\"]");
    private final By backpackButton =  By.xpath("//*[@id=\"add-to-cart-sauce-labs-backpack\"]");


    public ProductScreen(AndroidDriver<AndroidElement> driver){
        super(driver, "inventory.html");
    }


    public void selectFilterAtoZ(){
        WebElement filterContainerElement = driver.findElement(filterContainer);
        Select categories = new Select(filterContainerElement);
        //filterContainerElement.click();
        categories.selectByValue("az");
    }

    public void selectFilterZtoA(){
        WebElement filterContainerElement = driver.findElement(filterContainer);
        Select categories = new Select(filterContainerElement);
        categories.selectByValue("za");
    }

    public void selectFilterLowToHigh(){
        WebElement filterContainerElement = driver.findElement(filterContainer);
        Select categories = new Select(filterContainerElement);
        categories.selectByValue("lohi");
    }

    public void selectFilterHighToLow(){
        WebElement filterContainerElement = driver.findElement(filterContainer);
        Select categories = new Select(filterContainerElement);
        categories.selectByValue("hilo");
    }

    public void goToCart(){
        WebElement cartContainerElement = driver.findElement(shoppingCartContainer);
        cartContainerElement.click();
    }

    public void addProductToCart(){
        WebElement backpackAddButtonElement = driver.findElement(backpackAddButton);
        backpackAddButtonElement.click();
    }

    public void removeProductFromCart(){
        WebElement backpackAddButtonElement = driver.findElement(backpackRemoveButton);
        backpackAddButtonElement.click();
    }

    public void clickBackPack(){
        WebElement backpackButtonElement = driver.findElement(backpackButton);
        backpackButtonElement.click();
    }

    public String getFirstItemText(){
        return driver.findElement(itemName).getText();
    }


    public String getURL(){
        return driver.getCurrentUrl();
    }

    @Override
    public String getBackpackName() {
        WebElement backpackButtonElement = driver.findElement(backpackButton);
        return backpackButtonElement.getText();
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
