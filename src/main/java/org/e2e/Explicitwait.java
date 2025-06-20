package org.e2e;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.function.Function;

// Fluent
public class Explicitwait {

    @Test
    public void explicitWait()  {
        WebDriver webDriver = new ChromeDriver();

        webDriver.get("https://the-internet.herokuapp.com/dynamic_loading/1");
        webDriver.findElement(By.cssSelector("[id='start'] button")).click();
        Wait<WebDriver> wait = new FluentWait<WebDriver>(webDriver)
                .withTimeout(Duration.ofSeconds(30L))
                .pollingEvery(Duration.ofSeconds(5L))
                .ignoring(NoSuchElementException.class);

        WebElement webElement = wait.until(new Function<WebDriver, WebElement>() {
            public WebElement apply(WebDriver webDriver) {
                if(webDriver.findElement(By.cssSelector("[id='finish'] h4")).isDisplayed())
                    return webDriver.findElement(By.cssSelector("[id='finish'] h4"));
                else
                    return null;
            }
        });
        System.out.println(webDriver.findElement(By.cssSelector("[id='finish'] h4")).getText());
        webDriver.close();
    }
}
