package org.Excercise;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.security.Key;
import java.util.List;

public class AutoSuggestiveDropDown {
    @Test
    public void autoSuggestDropDown() throws InterruptedException {
        WebDriver webDriver = new ChromeDriver();
        webDriver.get("https://rahulshettyacademy.com/AutomationPractice/");
        webDriver.manage().window().maximize();

        webDriver.findElement(By.id("autocomplete")).sendKeys("Uni");
        List<WebElement> countries = webDriver.findElements(By.xpath("//li[@class='ui-menu-item']/div"));
        for(WebElement country: countries) {
            if (country.getText().toLowerCase().contains("united kingdom")) {
                country.click();
                break;
            } else {
                webDriver.findElement(By.id("autocomplete")).sendKeys(Keys.DOWN);
                Thread.sleep(2000);
            }
        }
        webDriver.quit();
    }
}
