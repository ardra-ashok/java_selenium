package org.Excercise;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import static org.testng.Assert.assertEquals;

@Test
public class qaClick {

    public void QA_click() throws InterruptedException {
        WebDriver webDriver = new ChromeDriver();

        webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(3));
        webDriver.get("https://qaclickacademy.com/practice.php");
        webDriver.manage().window().fullscreen();


        WebElement footerElement = webDriver.findElement(By.id("gf-BIG"));
        List<WebElement> footerLinks = footerElement.findElements(By.tagName("a"));
        System.out.println(footerLinks.size());
//        for(int i=0;i<footerLinks.size();i++)
//            System.out.println(footerLinks.get(i).getAttribute("href"));
        WebElement firstColumn = webDriver.findElement(By.xpath("//*[@id='gf-BIG']/table/tbody/tr/td[1]/ul"));
        List<WebElement> firstColumnLinks = firstColumn.findElements((By.tagName("a")));
        System.out.println(firstColumnLinks.size());

        for(int i=1;i<firstColumnLinks.size();i++){
           String weblinkClickable = Keys.chord(Keys.COMMAND,Keys.ENTER);
           firstColumn.findElements(By.tagName("a")).get(i).sendKeys(weblinkClickable);
        }

        Set<String> windowHandles = webDriver.getWindowHandles();
        Iterator<String> iterator = windowHandles.iterator();

        while(iterator.hasNext()){
            webDriver.switchTo().window(iterator.next());
            System.out.println(webDriver.getCurrentUrl());

        }


        webDriver.quit();


    }
}
