package org.Sel_basics;

import org.helpers.utils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;

import static org.testng.AssertJUnit.assertEquals;


public class Locators extends utils {

        static WebDriver webDriver;
       
    @Test
    public void locatorsPractise() throws InterruptedException {

        webDriver = new ChromeDriver();
        String name = "rahul";
        System.setProperty("webdriver.chrome.driver", "/Users/aashok/IdeaProjects/java_selenium/supportData/drivers/chromedriver");
        webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        webDriver.get("https://rahulshettyacademy.com/locatorspractice/");
        print(webDriver.getTitle());
        webDriver.findElement(By.linkText("Forgot your password?")).click();

        print(webDriver.findElement(By.linkText("Forgot your password?")).getText());
        webDriver.findElement(By.xpath("//input[@placeholder='Name']")).sendKeys("test");
        webDriver.findElement(By.xpath("//input[@type='text'][2]")).clear();
        webDriver.findElement(By.cssSelector("input[type='text']:nth-child(3)")).sendKeys("a@gmail.com");
        webDriver.findElement(By.xpath("//form/input[3]")).sendKeys("9185674121");
        Thread.sleep(3000);
        webDriver.findElement(By.cssSelector(".reset-pwd-btn")).click();
        String errorText = webDriver.findElement(By.cssSelector("form p")).getText();
        print(errorText);
        webDriver.findElement(By.cssSelector("form button:nth-child(1)")).click();
//        webDriver.findElement(By.cssSelector("//div[@class='forgot-pwd-btn-conainer']/button[1]")).click();

        Thread.sleep(1000);
        webDriver.findElement(By.cssSelector("#inputUsername")).sendKeys("rahul");
        webDriver.findElement(By.cssSelector("input[type*='pass']")).sendKeys("rahulshettyacademy");
        webDriver.findElement(By.xpath("//input[@id='chkboxOne']")).click();
        webDriver.findElement(By.xpath("//button[contains(@class,'submit')]")).click();

        Thread.sleep(1000);
        String successText = webDriver.findElement(By.tagName("p")).getText();
        assertEquals("You are successfully logged in.",successText);
        assertEquals(webDriver.findElement(By.cssSelector("div[class='login-container'] h2")).getText(),"Hello "+name+",");
        webDriver.close();
    }
    
}
