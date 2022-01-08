package saucedemo.web.pageObjects;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import saucedemo.testObject.objects.IProductDetailObject;

public class ProductDetailPage extends BasePage implements IProductDetailObject {

    private final By backpackAddButton = By.cssSelector("#add-to-cart-sauce-labs-backpack");

    private final By backpackRemoveButton = By.cssSelector("#remove-sauce-labs-backpack");

    private final By backToProductsButton = By.cssSelector("#back-to-products");

    private final By backpackNameClass = By.cssSelector(".inventory_details_name.large_size");


    public ProductDetailPage(WebDriver driver) {
        super(driver, "inventory-item.html?id=4");
    }

    // set methods that do stuff --> vb


    public void addProductToCart(){
        WebElement backpackAddButtonElement = driver.findElement(backpackAddButton);
        backpackAddButtonElement.click();
    }

    public void removeProductFromCart(){
        WebElement backpackAddButtonElement = driver.findElement(backpackRemoveButton);
        backpackAddButtonElement.click();
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
