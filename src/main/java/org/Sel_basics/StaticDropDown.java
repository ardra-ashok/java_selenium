package org.Sel_basics;

import org.helpers.utils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import java.sql.SQLOutput;
import java.time.Duration;

import static org.testng.Assert.assertEquals;

public class StaticDropDown extends utils {

    static WebDriver webDriver;
    public enum Browsers{
        CHROME,
        FIREFOX
    }

    @Test
    public void StaticDropDown() throws InterruptedException {

        initializeDriver(Locators_2.Browsers.valueOf(System.getProperty("browserName", "CHROME").toUpperCase()));

        webDriver.get("https://rahulshettyacademy.com/dropdownsPractise/");
        webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        WebElement staticDropDown = webDriver.findElement(By.id("ctl00_mainContent_DropDownListCurrency"));
        Select dropDown = new Select(staticDropDown);
        dropDown.selectByIndex(3);
        print(dropDown.getFirstSelectedOption().getText());
        dropDown.selectByVisibleText("AED");
        print(dropDown.getFirstSelectedOption().getText());
        dropDown.selectByValue("INR");
        print(dropDown.getFirstSelectedOption().getText());
        Thread.sleep(1000);
        webDriver.navigate().to("https://www.spicejet.com");
        webDriver.findElement(By.xpath("//div[@class='css-1dbjc4n']//div//div[@class='css-1dbjc4n r-14lw9ot r-11u4nky r-z2wwpe r-1phboty r-rs99b7 r-1loqt21 r-13awgt0 r-ymttw5 r-5njf8e r-1otgn73']")).click();
        WebElement plus = webDriver.findElement(By.xpath("(//div[@class='css-1dbjc4n r-1kz6sp'])[1]/following-sibling::div"));
        for(int i=0;i<4;i++)
            plus.click();
        Thread.sleep(1000);
        String count = webDriver.findElement(By.xpath("(//div[@class='css-1dbjc4n r-1kz6sp'])[1]")).getText();
        assertEquals(5,Integer.parseInt(webDriver.findElement(By.xpath("(//div[@class='css-1dbjc4n r-1kz6sp'])[1]")).getText()));
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
