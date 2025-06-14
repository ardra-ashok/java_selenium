package org.helpers;

import org.jspecify.annotations.Nullable;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class WebDriverHandler {
    private static WebDriver webDriver;

    public static void navigateTo(String url) {
        getDriver();
        webDriver.get(url);
    }

    public static WebDriver getDriver() {
        if (webDriver == null)
                webDriver = initializeDriver();
            return webDriver;

        }

    private static WebDriver initializeDriver() {
        webDriver = new ChromeDriver();
        System.setProperty("webdriver.chrome.driver", "/Users/aashok/IdeaProjects/java_selenium/supportData/drivers/chromedriver");
        webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        return webDriver;
    }

    public void getText(){

    }

    public String getPageTitle(){
        return getDriver().getTitle();
    }

    public String getUrl(){
        return getDriver().getCurrentUrl();
    }

    public void click(By by){
        findElement(by).click();
    }

    public WebElement findElement(By by){
        return getDriver().findElement(by);
    }


}


