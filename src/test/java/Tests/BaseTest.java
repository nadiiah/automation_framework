package Tests;

import com.codeborne.selenide.WebDriverRunner;
import com.skelia.nhryhor.pageobject.BasePage;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.bonigarcia.wdm.config.DriverManagerType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.*;
import org.openqa.selenium.WebDriver;

public class BaseTest {

    protected static WebDriver driver;
    private static final Logger LOGGER = LoggerFactory.getLogger(BasePage.class);

    @BeforeClass(alwaysRun = true)
    public void initDriver() {
        WebDriverManager.getInstance(DriverManagerType.CHROME).setup();
        driver = new ChromeDriver();
        WebDriverRunner.setWebDriver(driver);
    }

    @BeforeTest(alwaysRun = true)
    public void beforeTest() {
        LOGGER.info("Before Test");
    }

    @BeforeMethod(alwaysRun = true)
    public void beforeMethod() {
        LOGGER.info("Before Method");
    }

    @AfterClass(alwaysRun = true)
    public void terminateDriver() {
        if (WebDriverRunner.hasWebDriverStarted()) {
            WebDriverRunner.closeWebDriver();
        }
    }

    @AfterTest(alwaysRun = true)
    public void afterTest() {
        LOGGER.info("After Test");
    }

    @AfterMethod(alwaysRun = true)
    public void afterMethod() {
        LOGGER.info("After Method");
    }
}
