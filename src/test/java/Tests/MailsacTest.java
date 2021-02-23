package Tests;

import com.codeborne.selenide.Selenide;
import com.skelia.nhryhor.pageobject.MailsacPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class MailsacTest extends BaseTest {

    MailsacPage page = new MailsacPage();

    @Test
    public void openMailsac() {
        WebDriver driver = new ChromeDriver();
        Selenide.open("https://mailsac.com/");
        Assert.assertTrue(page.isPageDisplayed());
    }

    @Test(dependsOnMethods = "openMailsac")
    public void LogInMailsac() {
        page.openMenu();
        page.openLoginPage();
    }
}
