package com.skelia.nhryhor.pageobject;

import com.skelia.nhryhor.helpers.Waiter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class MailsacPage extends BasePage {
    private static final Logger LOGGER = LoggerFactory.getLogger(MailsacPage.class);

    int explicitTimeout = 15;
    protected WebDriver driver;

    @FindBy(xpath = "//a[@class ='hidden-xs']")
    private WebElement mailsacLogo;

    @FindBy(xpath = "//input[@class='myinbox form-control align-right ng-pristine ng-valid ng-empty ng-touched']")
    private WebElement emailInput;

    @FindBy(xpath = "//a[@class ='dropdown-toggle']")
    private WebElement mailsacMenu;

    @FindBy(xpath = "//a[contains(text(),'Sign In')]")
    private WebElement signIn;

    public boolean isPageDisplayed(){
        Waiter.waitForCondition(ExpectedConditions.visibilityOf(mailsacLogo), explicitTimeout/3);
        LOGGER.info("Waiting for page to be displayed.");
        return mailsacLogo.isDisplayed();
    }

    public void openMenu() {
        Waiter.waitForCondition(ExpectedConditions.elementToBeClickable(mailsacMenu), explicitTimeout/3);
        mailsacMenu.click();
    }

    public LoginPage openLoginPage() {
        signIn.click();
        return new LoginPage();
    }

    public void enterEmail(String email){
        emailInput.clear();
        emailInput.sendKeys(email);
    }
}
