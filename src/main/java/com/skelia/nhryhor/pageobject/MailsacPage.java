package com.skelia.nhryhor.pageobject;

import com.codeborne.selenide.SelenideElement;
import com.skelia.nhryhor.helpers.Waiter;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;

public class MailsacPage extends BasePage {
    private static final Logger LOGGER = LoggerFactory.getLogger(MailsacPage.class);

    @FindBy(xpath = "//a[@class ='hidden-xs']")
    private SelenideElement mailsacLogo;

    @FindBy(xpath = "//input[@class='myinbox form-control align-right ng-pristine ng-valid ng-empty ng-touched']")
    private SelenideElement emailInput;

    @FindBy(xpath = "//button[@class='btn btn-primary']")
    private SelenideElement checkMailButton;

    @FindBy(xpath = "//a[@class ='dropdown-toggle']")
    private SelenideElement mailsacMenu;

    @FindBy(xpath = "//a[contains(text(),'Sign In')]")
    private SelenideElement signIn;

    public void isPageDisplayed() {
        Assert.assertTrue(isElementDisplayed(mailsacLogo));
    }

    public void openMenu() {
        Waiter.waitForCondition(ExpectedConditions.elementToBeClickable(mailsacMenu), TIMEOUT / 3);
        mailsacMenu.click();
    }

    public void openLoginPage() {
        signIn.click();
    }

    public void enterEmail(String email) {
        emailInput.clear();
        emailInput.sendKeys(email);
        checkMailButton.click();
    }
}
