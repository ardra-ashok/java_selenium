package org.Sel4;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Set;
import java.util.Iterator;

public class Multi_Windows {

@Test
    public void multiWindow() throws IOException {
        WebDriver webDriver =new ChromeDriver();
        webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2000));

        webDriver.get("https://rahulshettyacademy.com/angularpractice/");
        webDriver.switchTo().newWindow(WindowType.WINDOW);
        Set<String> handles=webDriver.getWindowHandles();
        Iterator<String> it=handles.iterator();
        String parentWindowId = it.next();
        String childWindow =it.next();
        webDriver.switchTo().window(childWindow);
        webDriver.get("https://rahulshettyacademy.com/");
        String courseName = webDriver.findElements(By.cssSelector("a[href*='https://courses.rahulshettyacademy.com/p']"))
                .get(1).getText();
        webDriver.close();
        webDriver.switchTo().window(parentWindowId);
        WebElement name=webDriver.findElement(By.cssSelector("[name='name']"));
        name.sendKeys(courseName);
        File file=name.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(file, new File("/Users/aashok/IdeaProjects/java_selenium/supportData/screenShots/sc.png"));

        System.out.println(name.getRect().getDimension().getHeight());
        System.out.println(name.getRect().getDimension().getWidth());
        webDriver.quit();




    }
}
