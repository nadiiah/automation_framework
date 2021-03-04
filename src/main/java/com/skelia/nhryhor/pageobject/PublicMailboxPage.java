package com.skelia.nhryhor.pageobject;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;

public class PublicMailboxPage extends BasePage {
    private static final Logger LOGGER = LoggerFactory.getLogger(PublicMailboxPage.class);

    @FindBy(xpath = "//div[@class='inbox']/h2")
    private SelenideElement emailBoxName;

    public void isPageDisplayed() {
        Assert.assertTrue(isElementDisplayed(emailBoxName));
    }

    public void checkEmailBoxName(String email){
        Assert.assertSame(emailBoxName.getText(),email);
    }
}
