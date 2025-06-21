package org.windowHandles;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;

public class Frames {

    @Test
    public void FramesTest(){

        WebDriver webDriver = new ChromeDriver();

//        System.setProperty("webdriver.chrome.driver", "/Users/aashok/IdeaProjects/java_selenium/supportData/drivers/chromedriver");
        webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(3));

        webDriver.get("https://jqueryui.com/droppable/");
        System.out.println(webDriver.findElements(By.tagName("iframe")).size());
//        webDriver.switchTo().frame(webDriver.findElement(By.cssSelector("iframe.demo-frame")));
        webDriver.switchTo().frame(0);
//        webDriver.findElement(By.id("draggable")).click();

        WebElement source = webDriver.findElement(By.id("draggable"));
        WebElement target = webDriver.findElement(By.id("droppable"));

        Actions a = new Actions(webDriver);
        a.dragAndDrop(source,target).build().perform();
        webDriver.switchTo().defaultContent();

        webDriver.quit();
    }
}
