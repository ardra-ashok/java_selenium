package org.Excercise;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;

import java.time.Duration;
import java.util.List;

import static org.testng.Assert.assertTrue;
import static org.testng.AssertJUnit.assertEquals;

public class QA_click_ex1 {

        @Test
        public void Qa_click_ex(){
            WebDriver webDriver = new ChromeDriver();
            webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
            WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(3));
            webDriver.get("https://qaclickacademy.com/practice.php");
            webDriver.manage().window().fullscreen();

            assertEquals("Practice Page",webDriver.getTitle());
            webDriver.findElement(By.id("checkBoxOption2")).click();
            assertTrue(webDriver.findElement(By.id("checkBoxOption2")).isSelected());
            List<WebElement> checkBoxElem = webDriver.findElements(By.xpath("//fieldset//*[@type='checkbox']"));
            String selectedOption ="";
            for(WebElement check: checkBoxElem){
                if(check.isSelected())
                    selectedOption = check.getAttribute("value");
            }
            WebElement selectOpt = webDriver.findElement(By.id("dropdown-class-example"));
            Select sel = new Select(selectOpt);
            sel.selectByValue(selectedOption);
            webDriver.findElement(By.cssSelector("fieldset input[name='enter-name']")).sendKeys(selectedOption);
            webDriver.findElement(By.cssSelector("#alertbtn")).click();
            assertTrue(webDriver.switchTo().alert().getText().contains(selectedOption));

            webDriver.quit();
        }
}
