package saucedemo.web.pageObjects;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import saucedemo.testObject.objects.IProductDetailObject;
import saucedemo.testObject.objects.IProductOverviewObject;

public class ProductOverviewPage extends BasePage implements IProductOverviewObject {

    private final By cancelButton = By.cssSelector("#cancel");
    private final By finishButton = By.cssSelector("#finish");

    public ProductOverviewPage(WebDriver driver){
        super(driver, "checkout-step-two.html");
    }

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
