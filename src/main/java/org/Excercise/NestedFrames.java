package org.Excercise;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;

public class NestedFrames {

    @Test
    public void Iframes(){
        WebDriver webDriver = new ChromeDriver();

//        System.setProperty("webdriver.chrome.driver", "/Users/aashok/IdeaProjects/java_selenium/supportData/drivers/chromedriver");
        webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(3));

        webDriver.get("https://the-internet.herokuapp.com/nested_frames");
        webDriver.switchTo().frame(webDriver.findElement(By.xpath("//frame[@name='frame-top']")));
        webDriver.switchTo().frame(webDriver.findElement(By.xpath("//frame[@name='frame-middle']")));
        System.out.println(webDriver.findElement(By.cssSelector("body div[id='content']")).getText());

        webDriver.close();

    }
}
