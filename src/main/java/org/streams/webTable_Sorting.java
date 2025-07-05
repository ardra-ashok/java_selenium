package org.streams;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class webTable_Sorting{

    @Test
    public void webTable_Sort(){

        WebDriver webDriver = new ChromeDriver();

        webDriver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
        webDriver.findElement(By.xpath("//tr/th")).click();
        List<WebElement> elementsList = webDriver.findElements(By.xpath("//tr/td[1]"));
        List<String> productList = elementsList.stream().map(WebElement::getText).toList();
        List<String> sortedList = productList.stream().sorted().toList();
        Assert.assertEquals(productList, sortedList);


//        List<String> priceVeggie = elementsList.stream().filter(s->s.getText().equalsIgnoreCase("rice")).map(webTable_Sorting::getPriceVeg).collect(Collectors.toList());
//        System.out.println(priceVeggie);
        List<String> price = new ArrayList<>();

        do

        {
            List<WebElement> rows = webDriver.findElements(By.xpath("//tr/td[1]"));
            price = rows.stream().filter(s -> s.getText().contains("Rice"))
                    .map(s -> getPriceVeg(s)).collect(Collectors.toList());
            price.forEach(a -> System.out.println(a));
            if(price.size()<1)
                webDriver.findElement(By.cssSelector("[aria-label='Next']")).click();
        }
        while(price.size()<1);


        webDriver.quit();
    }

    private static String getPriceVeg(WebElement s) {
        return s.findElement(By.xpath("following-sibling::td[1]")).getText();
    }
}
