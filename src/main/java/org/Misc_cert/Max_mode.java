package org.Misc_cert;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;

public class Max_mode {

    @Test
    public void max_mode() throws IOException,IllegalArgumentException {
        WebDriver webDriver = new ChromeDriver();
        webDriver.manage().window().maximize();
        webDriver.manage().deleteAllCookies();
        webDriver.manage().deleteCookieNamed("cookie name");

        webDriver.get("http://google.com");
        File src = ((TakesScreenshot) webDriver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(src,new File("/Users/aashok/IdeaProjects/java_selenium/supportData/screenShots//screenshot.png"));

        webDriver.quit();


    }
}
