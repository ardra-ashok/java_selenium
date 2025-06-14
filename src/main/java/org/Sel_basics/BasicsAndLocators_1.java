package org.Sel_basics;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import java.time.Duration;

public class BasicsAndLocators_1 {
    @Test
    public static void basicSelenium() throws InterruptedException {
//        Launch in firefox
        WebDriver driver = new FirefoxDriver();
        System.setProperty("webdriver.gecko.driver","/Users/aashok/IdeaProjects/java_selenium/supportData/drivers/geckodriver");

//        WebDriver driver = new EdgeDriver();
//        System.setProperty("webdriver.edge.driver","/Users/aashok/IdeaProjects/java_selenium/supportData/drivers/");

//        WebDriver driver = new ChromeDriver();
//        System.setProperty("webdriver.chrome.driver","/Users/aashok/IdeaProjects/java_selenium/supportData/drivers/chromedriver");

        driver.get("https://rahulshettyacademy.com/locatorspractice/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));

        System.out.println(driver.getTitle());
        System.out.println(driver.getCurrentUrl());

        driver.findElement(By.id("inputUsername")).sendKeys("test");
        driver.findElement(By.name("inputPassword")).sendKeys("hello");
        driver.findElement(By.className("submit")).click();
        String errorText = driver.findElement(By.cssSelector("p.error")).getText();
        System.out.println(errorText);
//        driver.close();
        driver.quit();
    }
}