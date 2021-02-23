package Tests;

import com.codeborne.selenide.WebDriverRunner;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;
import org.openqa.selenium.WebDriver;

public class BaseTest {

    private static WebDriver driver;

    @BeforeClass(alwaysRun = true)
    public WebDriver initDriver() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/lib/chromeDriver/chromedriver");
        driver = new ChromeDriver();
        return driver;
    }

    @AfterClass(alwaysRun = true)
    public void terminateDriver() {
        if (driver != null){
        driver.quit();}
    }
}
