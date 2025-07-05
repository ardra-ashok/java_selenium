package org.streams;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.util.List;
import java.util.stream.Collectors;

public class filterStream {

    public static void main(String[] args) {
        WebDriver webDriver = new ChromeDriver();

        webDriver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
        webDriver.findElement(By.id("search-field")).sendKeys("Rice");
        List<WebElement> veggies = webDriver.findElements(By.xpath("//tr/td[1]"));
        List<WebElement> filteredList = veggies.stream().filter(veggie -> veggie.getText().contains("Rice")).
                collect(Collectors.toList());
        Assert.assertEquals(veggies.size(), filteredList.size());
    }



    }
