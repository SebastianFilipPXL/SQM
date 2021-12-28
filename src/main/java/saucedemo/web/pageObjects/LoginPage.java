package saucedemo.web.pageObjects;

import saucedemo.testObject.objects.ILoginObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage extends BasePage implements ILoginObject {
    private final By usernameTxt = By.cssSelector("#user-name");
    private final By passwordTxt = By.cssSelector("#password");
    private final By logiBtn = By.cssSelector("#login-button");
    private final By errorContainerDiv = By.cssSelector(".error-message-container h3");

    public LoginPage(WebDriver driver){
        super(driver, "");
    }

    // set methods that do stuff --> vb

    // write username
    // write password
    // click login

    public void fillInUsername(String username) {
        WebElement usernameTxtElement = driver.findElement(usernameTxt);
        usernameTxtElement.clear();
        usernameTxtElement.sendKeys(username);
    }

    public void fillInPassword(String password){
        WebElement usernameTxtElement = driver.findElement(passwordTxt);
        usernameTxtElement.clear();
        usernameTxtElement.sendKeys(password);
    }

    public void clickLogin(){
        driver.findElement(logiBtn).click();
    }

    public void login(String username, String password) {
        fillInUsername(username);
        fillInPassword(password);
        clickLogin();
    }

    @Override
    public String getErrormessage() {
        return driver.findElement(errorContainerDiv).getText();
    }

    public String getURL()
    {
        return driver.getCurrentUrl();
    }

}
