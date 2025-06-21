package org.Excercise;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

public class WindowHandles {

    @Test
    public void windowHandles(){
        WebDriver webDriver = new ChromeDriver();
        webDriver.get("https://the-internet.herokuapp.com/windows");
        webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(3));
        webDriver.findElement(By.xpath("//a[contains(text(),'Click Here')]")).click();
        Set<String> windowsHandles = webDriver.getWindowHandles();
        Iterator<String> it = windowsHandles.iterator();
        String parentId = it.next();
        String childId = it.next();
        webDriver.switchTo().window(childId);
        System.out.println(webDriver.findElement(By.cssSelector("div h3")).getText());
        webDriver.switchTo().window(parentId);
        System.out.println(webDriver.findElement(By.cssSelector("div[class='example'] h3")).getText());
        webDriver.quit();
    }
}
