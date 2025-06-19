package org.Sel_basics;

import org.helpers.utils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class DropDown extends utils {

    static WebDriver webDriver;

    public enum Browsers {
        CHROME,
        FIREFOX
    }

    @Test
    public void DropDown() throws InterruptedException {

        initializeDriver(Locators_2.Browsers.valueOf(System.getProperty("browserName", "CHROME").toUpperCase()));
        webDriver.get("https://www.spicejet.com");
        webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        webDriver.findElement(By.xpath("(//div[contains(text(),'From')])[1]/following-sibling::div")).click();
//        webDriver.findElement(By.xpath("(//div[contains(text(),'AMD')])[1]/parent::div/parent::div")).click();
        webDriver.findElement(By.xpath("(//div[contains(text(),'AMD')])[1]/parent::div/parent::div")).click();
        webDriver.findElement(By.xpath("(//div[contains(text(),'KQH')])[1]/parent::div/parent::div")).click();

//        AutoSuggestive
        webDriver.navigate().to("https://rahulshettyacademy.com/dropdownsPractise/");
        webDriver.findElement(By.id("autosuggest")).sendKeys("ind");
        Thread.sleep(2000);
        List<WebElement> elements = webDriver.findElements(By.cssSelector("li[class='ui-menu-item'] a"));
        for( WebElement elem: elements){
            if(elem.getText().equalsIgnoreCase("india"))
                elem.click();
        }

        print(webDriver.findElement(By.cssSelector("input[id*='SeniorCitizenDiscount']")).isSelected());
        webDriver.findElement(By.cssSelector("input[id*='SeniorCitizenDiscount']")).click();
        print(webDriver.findElement(By.cssSelector("input[id*='SeniorCitizenDiscount']")).isSelected());
        print(webDriver.findElements(By.cssSelector("input[type='checkbox']")).size());
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

