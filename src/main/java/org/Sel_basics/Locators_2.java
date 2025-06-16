package org.Sel_basics;

import org.helpers.utils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import java.time.Duration;

import static org.testng.AssertJUnit.assertEquals;


public class Locators_2 extends utils {

    static WebDriver webDriver;
    public enum Browsers{
        CHROME,
        FIREFOX
    }

    @Test
    public void locatorsPractise() throws InterruptedException {

        initializeDriver(Browsers.valueOf(System.getProperty("browserName","CHROME").toUpperCase()));
        String name = "rahul";

        webDriver.get("https://rahulshettyacademy.com/AutomationPractice/");
        webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));

        print(webDriver.findElement(By.xpath("/html/body/header/a")).getAttribute("href"));


        webDriver.close();
    }


    private static void initializeDriver(Browsers browsers){
        switch (browsers){
            case CHROME: webDriver = new ChromeDriver();
                System.setProperty("webdriver.chrome.driver", "/Users/aashok/IdeaProjects/java_selenium/supportData/drivers/chromedriver");
                break;
            case FIREFOX: webDriver = new FirefoxDriver();
                System.setProperty("webdriver.chrome.driver", "/Users/aashok/IdeaProjects/java_selenium/supportData/drivers/chromedriver");
                break;

        }
    }
}
