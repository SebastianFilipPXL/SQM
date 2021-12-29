package saucedemo.web.pageObjects;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import saucedemo.testObject.objects.IProductObject;
import saucedemo.web.utils.WebConfig;


public class ProductPage extends BasePage implements IProductObject {
    private final By filterContainer = By.cssSelector(".product_sort_container");
    private final By itemName = By.cssSelector(".inventory_item_label");
    private final By shoppingCartContainer = By.cssSelector("#shopping_cart_container");
    private final By backpackAddButton = By.cssSelector("#add-to-cart-sauce-labs-backpack");
    private final By backpackRemoveButton = By.cssSelector("#remove-sauce-labs-backpack");


    public ProductPage(WebDriver driver){
        super(driver, "inventory.html");
    }

    // set methods that do stuff --> vb

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


    public String getFirstItemText(){
        return driver.findElement(itemName).getText();
    }


    public String getURL(){
        return driver.getCurrentUrl();
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
