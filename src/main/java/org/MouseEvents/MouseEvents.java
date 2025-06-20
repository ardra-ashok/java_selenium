package org.MouseEvents;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;

public class MouseEvents {

    @Test
    public void Actions(){
        WebDriver webDriver = new ChromeDriver();
        webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
//        System.setProperty("webdriver.chrome.driver", "/Users/aashok/IdeaProjects/java_selenium/supportData/drivers/chromedriver");

        webDriver.get("https://www.amazon.com");
        webDriver.findElement(By.xpath("//button[@type='submit']")).click();
        Actions actions = new Actions(webDriver);
        actions.moveToElement(webDriver.findElement(By.cssSelector("[id='nav-link-accountList']"))).build().perform();
//        WebDriverWait w = new WebDriverWait(webDriver,Duration.ofSeconds(3));
//        w.until(ExpectedConditions.elementToBeClickable(By.id("twotabsearchtextbox")));

        actions.moveToElement(webDriver.findElement(By.id("twotabsearchtextbox"))).click().keyDown(Keys.SHIFT).sendKeys("hello").doubleClick().build().perform();
        actions.moveToElement(webDriver.findElement(By.cssSelector("[id='nav-link-accountList']"))).contextClick().build().perform();

        webDriver.close();
    }
}
