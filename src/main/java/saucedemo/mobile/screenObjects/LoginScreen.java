package saucedemo.mobile.screenObjects;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginScreen extends BaseScreen{

    private final By usernameTxt = By.xpath("//*[@id='user-name']");
    private final By passwordTxt = By.xpath("//*[@id='password']");
    private final By logiBtn = By.xpath("//*[@id='login-button']");

    public LoginScreen(AndroidDriver<AndroidElement> driver){
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

    public void fillInPassword(String password) {
        WebElement usernameTxtElement = driver.findElement(passwordTxt);
        usernameTxtElement.clear();
        usernameTxtElement.sendKeys(password);
    }

    private void clickLogin(){
        driver.findElement(logiBtn).click();
    }

    // gebruik alle methoden en doe hier de finale toDo's met hoofdletters

    public void Login(String username, String password){
        fillInPassword(password);
        fillInUsername(username);
        clickLogin();
    }


}
