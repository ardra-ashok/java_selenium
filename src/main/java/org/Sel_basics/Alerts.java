package org.Sel_basics;

import org.helpers.utils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.time.Duration;

import static org.testng.AssertJUnit.*;

public class Alerts extends utils {

    @Test
    public void Alerts() {
        WebDriver webDriver = new ChromeDriver();

        webDriver.get("https://rahulshettyacademy.com/AutomationPractice/");
        webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));

        webDriver.findElement(By.cssSelector("[id='name']")).sendKeys("helen");
        webDriver.findElement(By.cssSelector("[id='alertbtn']")).click();
        assertTrue(webDriver.switchTo().alert().getText().contains("Hello helen"));
        webDriver.switchTo().alert().accept();

        webDriver.findElement(By.cssSelector("#confirmbtn")).click();
        webDriver.switchTo().alert().dismiss();
        webDriver.findElement(By.cssSelector("[id='name']")).sendKeys("helen");
        webDriver.findElement(By.cssSelector("[id='confirmbtn']")).click();

        webDriver.close();
    }
}
