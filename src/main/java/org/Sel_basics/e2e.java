package org.Sel_basics;

import org.helpers.utils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.time.Duration;

import static org.testng.Assert.assertTrue;
import static org.testng.AssertJUnit.assertEquals;

public class e2e extends utils {

    @Test
    public void e2eExample(){
        WebDriver webDriver = new ChromeDriver();

        webDriver.get("https://rahulshettyacademy.com/dropdownsPractise/");
        webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        webDriver.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXT")).click();
        webDriver.findElement(By.cssSelector("a[value='IXG']")).click();
        webDriver.findElement(By.xpath("//div[@id='glsctl00_mainContent_ddl_destinationStation1_CTNR'] //a[@value='MAA']")).click();
        webDriver.findElement(By.cssSelector(".ui-state-default.ui-state-active")).click();


        System.out.println(webDriver.findElement(By.id("Div1")).getDomAttribute("style"));
        webDriver.findElement(By.id("ctl00_mainContent_rbtnl_Trip_1")).click();
        System.out.println(webDriver.findElement(By.id("Div1")).getDomAttribute("style"));
        if(webDriver.findElement(By.id("Div1")).getDomAttribute("style").contains("1"))
            assertTrue(true);
        else
            assertTrue(false);

        webDriver.findElement(By.xpath("//div[@id='divpaxinfo']")).click();
        WebElement plusBtn = webDriver.findElement(By.cssSelector("#hrefIncAdt"));
        int i=1;
        while(i<5){
            plusBtn.click();
            i++;
        }
        webDriver.findElement(By.cssSelector("input[value='Done']")).click();
        assertEquals("5 Adult",webDriver.findElement(By.xpath("//div[@id='divpaxinfo']")).getText());
        webDriver.findElement(By.cssSelector("#ctl00_mainContent_btn_FindFlights")).click();

        webDriver.quit();

    }
}
