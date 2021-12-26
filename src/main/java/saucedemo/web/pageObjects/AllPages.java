package saucedemo.web.pageObjects;

import net.bytebuddy.agent.builder.AgentBuilder;
import org.openqa.selenium.WebDriver;
import saucedemo.web.utils.BrowserUtil;

public class AllPages {
    private WebDriver driver;

    public LoginPage loginPage;
    public InventoryPage inventoryPage;

    public AllPages(){
        driver = BrowserUtil.createBrowser();
        loginPage = new LoginPage(driver);
        inventoryPage = new InventoryPage(driver);
    }

    public void closeBrowser() {driver.quit();}

}
