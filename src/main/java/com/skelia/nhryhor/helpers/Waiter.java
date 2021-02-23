package com.skelia.nhryhor.helpers;

import com.codeborne.selenide.Selenide;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.TimeoutException;

import java.time.Duration;

public class Waiter {

    private static FluentWait<WebDriver> getFluentWait(Duration timeOutDuration) {
        return Selenide.Wait().withTimeout(timeOutDuration);
    }

    public static void waitForCondition(ExpectedCondition<?> expectedCondition, long timeToWait) {
        try {
            getFluentWait(Duration.ofMillis(timeToWait)).until(expectedCondition);
        } catch (TimeoutException var4) {
        }
//            Logger.info("Condition was not met", var4);
    }
}