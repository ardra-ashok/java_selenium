package org.Sel_basics;

import org.helpers.utils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class CheckBox extends utils {
    static WebDriver webDriver;

    public enum Browsers {
        CHROME,
        FIREFOX

    }
    @Test
    public void checkBoxExample(){
        initializeDriver(Locators_2.Browsers.valueOf(System.getProperty("browserName", String.valueOf(Browsers.CHROME)).toUpperCase()));
        webDriver.get("https://rahulshettyacademy.com/AutomationPractice/");

        assertFalse(webDriver.findElement(By.cssSelector("input[type='checkbox']")).isSelected());
        webDriver.findElement((By.cssSelector("input[id='checkBoxOption1']"))).click();
        assertTrue(webDriver.findElement(By.cssSelector("input[type='checkbox']")).isSelected());
        webDriver.findElement((By.xpath("//input[@id='checkBoxOption1']"))).click();
        assertFalse(webDriver.findElement(By.cssSelector("input[type='checkbox']")).isSelected());
        assertEquals(3, webDriver.findElements(By.cssSelector("input[type='checkbox']")).size());
        webDriver.close();

    }
    private static void initializeDriver(Locators_2.Browsers browsers) {
        switch (browsers) {
            case CHROME:
                webDriver = new ChromeDriver();
//                System.setProperty("webdriver.chrome.driver", "/Users/aashok/IdeaProjects/java_selenium/supportData/drivers/chromedriver");
                break;
            case FIREFOX:
                webDriver = new FirefoxDriver();
//                System.setProperty("webdriver.gecko.driver", "/Users/aashok/IdeaProjects/java_selenium/supportData/drivers/geckodriver");
                break;

        }
    }
}
