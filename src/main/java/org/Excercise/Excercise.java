package org.Excercise;

import org.helpers.utils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Excercise extends utils {

    @Test
    public void Excerice(){
       WebDriver webDriver = new ChromeDriver();
       webDriver.get("https://rahulshettyacademy.com/angularpractice/");
       webDriver.findElement(By.name("name")).sendKeys("Helen");
       webDriver.findElement(By.name("email")).sendKeys("test@gmail.com");
       webDriver.findElement(By.cssSelector("input[type='password']")).sendKeys("test@gmail.com");
       webDriver.findElement(By.cssSelector("input[id='exampleCheck1']")).click();
        WebElement staticDropdown = webDriver.findElement(By.id("exampleFormControlSelect1"));

       Select select = new Select(staticDropdown);
       select.selectByVisibleText("Female");
       System.out.println(select.getFirstSelectedOption().getText());

//       webDriver.findElement(By.cssSelector("input[id='inlineRadio2']")).click();
       webDriver.findElement(By.xpath("//label[text()='Employed']//preceding-sibling::input")).click();
       webDriver.findElement(By.cssSelector("input[type='date']")).sendKeys("28/09/1989");
       webDriver.findElement(By.cssSelector(".btn.btn-success")).click();
       String successMsg = webDriver.findElement(By.cssSelector("div[class*='alert-success']")).getText();
       System.out.println(successMsg);
       Assert.assertTrue(successMsg.contains("Success!"));

       webDriver.close();

    }
}
