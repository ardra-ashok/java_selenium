package org.Excercise;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class Calender {
    @Test
    public void calendarSelect(){
        String monthNumber = "6";
        String year = "2026";
        String day = "15";
        String[] expectedList = {monthNumber,day,year};

        WebDriver webDriver = new ChromeDriver();
        webDriver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
        webDriver.findElement(By.cssSelector(".react-date-picker__inputGroup")).click();
        webDriver.findElement(By.xpath("//button[@class='react-calendar__navigation__label']")).click();
        webDriver.findElement(By.xpath("//button[@class='react-calendar__navigation__label']")).click();
        webDriver.findElement(By.xpath("//button[text()='"+year+"']")).click();
        webDriver.findElements(By.cssSelector(".react-calendar__year-view__months__month")).get(Integer.parseInt(monthNumber)-1).click();
        webDriver.findElement(By.xpath("//abbr[text()='"+day+"']")).click();

        List<WebElement> actualList = webDriver.findElements(By.cssSelector(".react-date-picker__inputGroup__input"));
        for(int i =0; i<actualList.size();i++)
        {
            System.out.println(actualList.get(i).getAttribute("value"));
            Assert.assertEquals(actualList.get(i).getAttribute("value"), expectedList[i]);
        }
        webDriver.quit();
    }

}
