package saucedemo.mobile.screenObjects;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import saucedemo.testObject.objects.ICheckoutInformationObject;

public class CheckoutInformationScreen extends BaseScreen implements ICheckoutInformationObject {
    private final By cancelButton = By.xpath("//*[@id=\"cancel\"]");
    private final By continueButton = By.xpath("//*[@id=\"continue\"]");
    private final By firstNameField = By.xpath("//*[@id=\"first-name\"]");
    private final By lastNameField = By.xpath("//*[@id=\"last-name\"]");
    private final By postalCodeField = By.xpath("//*[@id=\"postal-code\"]");

    public CheckoutInformationScreen(AndroidDriver<AndroidElement> driver){
        super(driver, "cart.html");
    }

    public void fillInFirstName(String firstName) {
        WebElement usernameTxtElement = driver.findElement(firstNameField);
        usernameTxtElement.clear();
        usernameTxtElement.sendKeys(firstName);
    }

    public void fillInLastName(String lastName) {
        WebElement usernameTxtElement = driver.findElement(lastNameField);
        usernameTxtElement.clear();
        usernameTxtElement.sendKeys(lastName);
    }

    public void fillInPostalCode(String postalCode) {
        WebElement usernameTxtElement = driver.findElement(postalCodeField);
        usernameTxtElement.clear();
        usernameTxtElement.sendKeys(postalCode);
    }

    @Override
    public void clickCancel() {
        WebElement cancelElement = driver.findElement(cancelButton);
        cancelElement.click();
    }

    @Override
    public void clickContinue() {
        WebElement continueElement = driver.findElement(continueButton);
        continueElement.click();
    }

    @Override
    public void continueCorrectly(String firstName, String lastName, String postalCode){
        fillInFirstName(firstName);
        fillInLastName(lastName);
        fillInPostalCode(postalCode);
        clickContinue();
    }
}
