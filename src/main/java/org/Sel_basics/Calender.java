package org.Sel_basics;

import org.helpers.WebDriverHandler;
import org.helpers.utils;
import org.openqa.selenium.By;
import org.junit.jupiter.api.Test;


public class Calender extends utils {

    WebDriverHandler wd = new WebDriverHandler();
    @Test
    public void calendarExample()  {
        wd.navigateTo("https://rahulshettyacademy.com/dropdownsPractise/");
        wd.webDriverWait(3);
        wd.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXT")).click();
        wd.findElement(By.cssSelector("a[value='IXG']")).click();
        wd.findElement(By.xpath("//div[@id='glsctl00_mainContent_ddl_destinationStation1_CTNR'] //a[@value='MAA']")).click();

        wd.findElement(By.cssSelector(".ui-state-default.ui-state-active")).click();
        wd.closeDriver();

    }


}
