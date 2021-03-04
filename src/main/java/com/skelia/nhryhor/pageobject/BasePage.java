package com.skelia.nhryhor.pageobject;

import com.codeborne.selenide.SelenideElement;
import com.skelia.nhryhor.helpers.Waiter;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BasePage {
    protected static int TIMEOUT = 15;
    private static final Logger LOGGER = LoggerFactory.getLogger(BasePage.class);

    public BasePage() {
        LOGGER.info("This is Base page");
    }

    protected boolean isElementDisplayed(SelenideElement element) {
        Waiter.waitForCondition(ExpectedConditions.visibilityOf(element), TIMEOUT / 3);
        return element.isDisplayed();
    }
}
