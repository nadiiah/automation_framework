package com.skelia.nhryhor.pageobject;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class LoginPage extends BasePage {
    @FindBy(xpath = "//input[@name ='username']")
    private SelenideElement usernameInput;

    @FindBy(xpath = "//input[@name ='password']")
    private SelenideElement passwordInput;

    @FindBy(xpath = "//button[@type ='submit']")
    private SelenideElement buttonSignIn;

    public void isPageDisplayed() {
        Assert.assertTrue(isElementDisplayed(usernameInput));
    }

    public void enterCredentials(String username, String password) {
        usernameInput.clear();
        usernameInput.sendKeys(username);
        passwordInput.clear();
        passwordInput.sendKeys(password);
    }

    public void clickSignIn() {
        buttonSignIn.click();
    }
}
