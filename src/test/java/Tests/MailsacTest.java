package Tests;

import com.codeborne.selenide.Selenide;
import com.skelia.nhryhor.pageobject.LoginPage;
import com.skelia.nhryhor.pageobject.MailsacPage;
import com.skelia.nhryhor.pageobject.PublicMailboxPage;
import com.skelia.nhryhor.pageobject.UserMailboxPage;
import com.skelia.nhryhor.providers.EmailProvider;
import org.testng.annotations.Test;

public class MailsacTest extends BaseTest {

    private MailsacPage homePage;
    private LoginPage loginPage;
    private UserMailboxPage userMailboxPage;
    private PublicMailboxPage publicMailboxPage;

    @Test
    public void openMailsac() {
        Selenide.open("https://mailsac.com/");
        homePage = Selenide.page(MailsacPage.class);
        homePage.isPageDisplayed();
    }

    @Test(dependsOnMethods = "openMailsac", enabled = false)
    public void LogInMailsac() {
        homePage.openMenu();
        homePage.openLoginPage();
        loginPage = Selenide.page(LoginPage.class);
        loginPage.isPageDisplayed();
        loginPage.enterCredentials("alpegaqa", "Transwide01");
        loginPage.clickSignIn();
        userMailboxPage = Selenide.page(UserMailboxPage.class);
        userMailboxPage.isPageDisplayed();
    }

    @Test(dependsOnMethods = "openMailsac", dataProvider = "listOfEmails", dataProviderClass = EmailProvider.class)
    public void openPublicMailboxes(String email) {
        homePage.enterEmail(email);
        publicMailboxPage = Selenide.page(PublicMailboxPage.class);
        publicMailboxPage.isPageDisplayed();
        publicMailboxPage.checkEmailBoxName(email);
    }
}
