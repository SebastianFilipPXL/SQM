package saucedemo.web.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import saucedemo.testObject.objects.ICheckoutInformationObject;

public class CheckoutInformationPage extends BasePage implements ICheckoutInformationObject {
    private final By cancelButton = By.cssSelector("#cancel");
    private final By continueButton = By.cssSelector("#continue");
    private final By firstNameField = By.cssSelector("#first-name");
    private final By lastNameField = By.cssSelector("#last-name");
    private final By postalCodeField = By.cssSelector("#postal-code");

    public CheckoutInformationPage(WebDriver driver){
        super(driver, "checkout-step-one.html");
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
