package org.e2e;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;

import static org.testng.AssertJUnit.assertTrue;

public class Ecommerce {

    @Test
    public void eCommerce() throws InterruptedException {
        WebDriver webDriver = new ChromeDriver();
        String[] names = {"cucumber","brocolli","beetroot"};

        webDriver.get("https://rahulshettyacademy.com/seleniumPractise/");
//        webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));

        addItemsToCart(webDriver,names);

        webDriver.close();
    }

    public void addItemsToCart(WebDriver webDriver, String[] names) throws InterruptedException {
        WebDriverWait wd = new WebDriverWait(webDriver,Duration.ofSeconds(5));
        int j = 0;
        List<String> namesList = Arrays.asList(names);
        List<WebElement> products = webDriver.findElements(By.className("product-name"));
        for (int i=0;i<products.size();i++){
            String itemName = products.get(i).getText().split(" ")[0].toLowerCase().trim();
            if(namesList.contains(itemName)) {
                webDriver.findElements(By.xpath("//div[@class='product-action']/button")).get(i).click();
                j++;
                if(namesList.size()==j)
                    break;
            }
        }
        webDriver.findElement(By.xpath("//a[@class='cart-icon']")).click();
        webDriver.findElement(By.xpath("//button[contains(text(),'PROCEED TO CHECKOUT')]")).click();
        wd.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input.promoCode")));
        webDriver.findElement(By.cssSelector("input.promoCode")).sendKeys("rahulshettacademy");
        webDriver.findElement(By.cssSelector("button.promoBtn")).click();


        wd.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("span.promoInfo")));
        assertTrue(webDriver.findElement(By.cssSelector("span.promoInfo")).getText().contains("Invalid code"));

    }
}
