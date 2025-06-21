package org.windowHandles;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

public class WindowHandles {
    @Test
    public void getWindowHandles(){
        WebDriver webDriver = new ChromeDriver();

//        System.setProperty("webdriver.chrome.driver", "/Users/aashok/IdeaProjects/java_selenium/supportData/drivers/chromedriver");
        webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(3));
        webDriver.get("https://rahulshettyacademy.com/loginpagePractise/");
        webDriver.findElement(By.cssSelector(".blinkingText")).click();
        Set<String> windows = webDriver.getWindowHandles();
        Iterator<String> it = windows.iterator();
        String parentId = it.next();
        String childId = it.next();
        webDriver.switchTo().window(childId);
        String emailId = webDriver.findElement(By.cssSelector("[class='im-para red']")).getText().split("at")[1].trim().split(" ")[0];
        webDriver.switchTo().window(parentId);
        webDriver.findElement(By.id("username")).sendKeys(emailId);
        webDriver.quit();
    }

}
