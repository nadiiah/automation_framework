package com.skelia.nhryhor.pageobject;

import com.codeborne.selenide.SelenideElement;
import com.skelia.nhryhor.helpers.Waiter;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;

public class UserMailboxPage extends BasePage {
    private static final Logger LOGGER = LoggerFactory.getLogger(UserMailboxPage.class);

    @FindBy(xpath = "//h3[contains(text(),'Recently Viewed Inboxes')]")
    private SelenideElement recentInboxes;

    public void isPageDisplayed() {
        Assert.assertTrue(isElementDisplayed(recentInboxes));
        LOGGER.info("Print");
    }
}
