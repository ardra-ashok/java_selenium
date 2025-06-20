package org.Excercise;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

import static org.testng.AssertJUnit.assertTrue;

public class loginPage {

    @Test
    public void login() {

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--incognito");
        WebDriver webDriver = new ChromeDriver(options);

//        System.setProperty("webdriver.chrome.driver", "/Users/aashok/IdeaProjects/java_selenium/supportData/drivers/chromedriver");
        webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(3));
        webDriver.get("https://rahulshettyacademy.com/loginpagePractise/");
        webDriver.manage().window().fullscreen();

        webDriver.findElement(By.cssSelector("[id='username']")).sendKeys("rahulshettyacademy");
        webDriver.findElement(By.cssSelector("[id='password']")).sendKeys("learning");

        webDriver.findElement(By.cssSelector("[value='user']")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("okayBtn")));
        webDriver.findElement(By.id("okayBtn")).click();
        Select selectOptions = new Select(webDriver.findElement(By.cssSelector("div select[class='form-control']")));
        selectOptions.selectByVisibleText("Consultant");
        webDriver.findElement(By.cssSelector("[type='checkbox']")).click();
        webDriver.findElement(By.cssSelector("input[name='signin']")).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@class='nav-link btn btn-primary']")));

        List<WebElement> products = webDriver.findElements(By.cssSelector("app-card"));
        for(WebElement product :products){
            product.findElement(By.cssSelector(".btn.btn-info")).click();
        }
        JavascriptExecutor js = (JavascriptExecutor) webDriver;
        js.executeScript("window.scrollTo(0, 0);");
        webDriver.findElement(By.xpath("//a[@class='nav-link btn btn-primary']")).click();

        assertTrue(webDriver.findElement(By.xpath("(//a[@class='navbar-brand'])[2]")).isDisplayed());
//        System.out.println(webDriver.findElement(By.xpath("(//a[@class='navbar-brand'])[2]")).isDisplayed());
        webDriver.findElement(By.cssSelector("button[class='btn btn-success']")).click();

        webDriver.close();
    }
}
