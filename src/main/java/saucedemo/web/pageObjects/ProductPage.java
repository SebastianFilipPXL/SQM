package saucedemo.web.pageObjects;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import saucedemo.testObject.objects.IProductObject;
import saucedemo.web.utils.WebConfig;

public class ProductPage extends BasePage implements IProductObject {
    private final By shoppingkartCnt = By.cssSelector("#shopping_cart_container");
    private  final By tittleTxt = By.cssSelector(".title");

    public ProductPage(WebDriver driver){
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
