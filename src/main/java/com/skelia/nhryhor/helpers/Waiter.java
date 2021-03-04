package com.skelia.nhryhor.helpers;

import com.codeborne.selenide.Selenide;
import com.skelia.nhryhor.pageobject.MailsacPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.TimeoutException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.Duration;

public class Waiter {
    private static final Logger LOGGER = LoggerFactory.getLogger(MailsacPage.class);

    private static FluentWait<WebDriver> getFluentWait(Duration timeOutDuration) {
        return Selenide.Wait().withTimeout(timeOutDuration);
    }

    public static void waitForCondition(ExpectedCondition<?> expectedCondition, long timeToWait) {
        try {
            getFluentWait(Duration.ofMillis(timeToWait)).until(expectedCondition);
        } catch (TimeoutException var4) {
            LOGGER.error(var4.getMessage(), var4);
        }
    }
}