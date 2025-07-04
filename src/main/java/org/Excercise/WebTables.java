package org.Excercise;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.util.List;

import static org.testng.Assert.assertEquals;


public class WebTables {

    @Test
    public void webTables() throws InterruptedException {
        WebDriver webDriver = new ChromeDriver();
        webDriver.get("https://rahulshettyacademy.com/AutomationPractice/");

        JavascriptExecutor js = (JavascriptExecutor) webDriver;
        js.executeScript("window.scrollBy(0,500)");
        Thread.sleep(3000);
        js.executeScript("document.querySelector('.tableFixHead').scrollTop=5000");
        List<WebElement> values = webDriver.findElements(By.cssSelector(".tableFixHead td:nth-child(4)"));
        int total = 0;
        for(int i=0;i<values.size();i++)
            total+= Integer.parseInt(values.get(i).getText());
        assertEquals(total,Integer.parseInt(webDriver.findElement(By.cssSelector(".totalAmount")).getText().split(":")[1].trim()));
        List<WebElement> tableRows = webDriver.findElements(By.xpath("//*[@name='courses']/tbody/tr"));
        System.out.println(tableRows.size());
        System.out.println(tableRows.get(1).findElements(By.tagName("td")).size());
        System.out.println(tableRows.get(2).findElements(By.tagName("td")).get(1).getText());
        webDriver.quit();
    }
}
