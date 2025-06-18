package org.Sel_basics;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import java.time.Duration;

public class DropDown {

    static WebDriver webDriver;

    public enum Browsers {
        CHROME,
        FIREFOX
    }

    @Test
    public void DropDown() {

        initializeDriver(Locators_2.Browsers.valueOf(System.getProperty("browserName", "CHROME").toUpperCase()));
        webDriver.get("https://www.spicejet.com");
        webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        webDriver.findElement(By.xpath("(//div[contains(text(),'From')])[1]/following-sibling::div")).click();
        webDriver.findElement(By.xpath("(//div[contains(text(),'AMD')])[1]/parent::div/parent::div")).click();
        webDriver.findElement(By.xpath("(//div[contains(text(),'KQH')])[1]/parent::div/parent::div")).click();
        webDriver.close();
    }

    private static void initializeDriver(Locators_2.Browsers browsers){
        switch (browsers){
            case CHROME: webDriver = new ChromeDriver();
//                System.setProperty("webdriver.chrome.driver", "/Users/aashok/IdeaProjects/java_selenium/supportData/drivers/chromedriver");
                break;
            case FIREFOX: webDriver = new FirefoxDriver();
//                System.setProperty("webdriver.gecko.driver", "/Users/aashok/IdeaProjects/java_selenium/supportData/drivers/geckodriver");
                break;

        }
    }
}

