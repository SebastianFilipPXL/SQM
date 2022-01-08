package saucedemo.web.pageObjects;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import saucedemo.testObject.objects.IShoppingCartObject;

public class ShoppingCartPage extends BasePage implements IShoppingCartObject{
    private final By checkoutButton = By.cssSelector("#checkout");
    private final By continueShoppingButton = By.cssSelector("#continue-shopping");
    private final By removeItemButton = By.cssSelector("#remove-sauce-labs-backpack");

    public ShoppingCartPage(WebDriver driver){
        super(driver, "cart.html");
    }

    // set methods that do stuff --> vb

    public void clickCheckout(){
        WebElement checkoutElement = driver.findElement(checkoutButton);
        checkoutElement.click();
    }

    public void clickContinueShopping(){
        WebElement continueShoppingElement = driver.findElement(continueShoppingButton);
        continueShoppingElement.click();
    }

    public void removeItem(){
        WebElement removeItemElement = driver.findElement(removeItemButton);
        removeItemElement.click();
    }
    public String getURL()
    {
        return driver.getCurrentUrl();
    }
}
