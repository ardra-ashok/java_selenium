package org.Sel_basics;

import org.helpers.utils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;
import java.time.Duration;


public class Locators_2 extends utils {

    static WebDriver webDriver;
    public enum Browsers{
        CHROME,
        FIREFOX
    }

    @Test
    public void locatorsPractise() {

        initializeDriver(Browsers.valueOf(System.getProperty("browserName","CHROME").toUpperCase()));

        webDriver.get("https://rahulshettyacademy.com/AutomationPractice/");
        webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));

        print(webDriver.findElement(By.xpath("/html/body/header/a")).getAttribute("href")); // absolute locator
        print(webDriver.findElement(By.xpath("//header/div/button[1]")).getText()); // relative locator
        print(webDriver.findElement(By.xpath("//header/div/button[1]/following-sibling::button[2]")).getText()); // sibling to sibling
//      getting the parent div  //header/div/button[1]/parent::div
        print(webDriver.findElement(By.xpath("//header/div/button[1]/parent::div/preceding-sibling::a[1]")).getText()); // child to parent

        webDriver.manage().window().fullscreen();
        webDriver.navigate().to("http://google.com");
        webDriver.manage().window().maximize();
        webDriver.navigate().back();

        webDriver.close();
    }


    private static void initializeDriver(Browsers browsers){
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
