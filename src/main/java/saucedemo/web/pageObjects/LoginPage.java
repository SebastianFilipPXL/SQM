package saucedemo.web.pageObjects;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage extends BasePage {
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

    public void fillInUsername(String username) throws InterruptedException {
        WebElement usernameTxtElement = driver.findElement(usernameTxt);
        usernameTxtElement.clear();
        usernameTxtElement.sendKeys(username);
        Thread.sleep(2000);
    }

    public void fillInPassword(String password) throws InterruptedException {
        WebElement usernameTxtElement = driver.findElement(passwordTxt);
        usernameTxtElement.clear();
        usernameTxtElement.sendKeys(password);
        Thread.sleep(2000);
    }

    private void clickLogin() throws InterruptedException {
        driver.findElement(logiBtn).click();
        Thread.sleep(5000);
    }

    // gebruik alle methoden

    public void Login(String username, String password) throws InterruptedException {
        fillInPassword(password);
        fillInUsername(username);
        clickLogin();
    }

    public String getErrorMessage()
    {
        return driver.findElement(errorContainerDiv).getText();
    }
    public String getURL()
    {
        return driver.getCurrentUrl();
    }



}
