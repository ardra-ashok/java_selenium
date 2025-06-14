package org.example;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class Main {
    @Test
    public static void basicSelenium(){
//        Launch in firefox
        WebDriver driver = new FirefoxDriver();
        System.setProperty("webdriver.gecko.driver","/Users/aashok/IdeaProjects/java_selenium/supportData/drivers/geckodriver");

//        WebDriver driver = new EdgeDriver();
//        System.setProperty("webdriver.edge.driver","/Users/aashok/IdeaProjects/java_selenium/supportData/drivers/");

//        WebDriver driver = new ChromeDriver();
//        System.setProperty("webdriver.chrome.driver","/Users/aashok/IdeaProjects/java_selenium/supportData/drivers/chromedriver");

        driver.get("https://rahulshettyacademy.com");
        System.out.println(driver.getTitle());
        System.out.println(driver.getCurrentUrl());

        driver.close();
    }
}