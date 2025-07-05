package org.Sel4;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import static org.openqa.selenium.support.locators.RelativeLocator.with;

public class Sel_4_Locators {

    @Test
    public void relLocators(){
        WebDriver webDriver = new ChromeDriver();

        webDriver.get("https://rahulshettyacademy.com/angularpractice/");
        WebElement nameEditBox =webDriver.findElement(By.cssSelector("[name='name']"));
        System.out.println(webDriver.findElement(with(By.tagName("label")).above(nameEditBox)).getText());
        WebElement dateofBirth = webDriver.findElement(By.cssSelector("[for='dateofBirth']"));
        webDriver.findElement(with(By.tagName("input")).below(dateofBirth)).click();
        WebElement iceCreamLabel =webDriver.findElement(By.xpath("//label[text()='Check me out if you Love IceCreams!']"));
        webDriver.findElement(with(By.tagName("input")).toLeftOf(iceCreamLabel)).click();
        WebElement rdb = webDriver.findElement(By.id("inlineRadio1"));
        System.out.println(webDriver.findElement(with(By.tagName("label")).toRightOf(rdb)).getText());

        webDriver.quit();
    }
}
