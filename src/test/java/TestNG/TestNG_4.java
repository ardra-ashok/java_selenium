package TestNG;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestNG_4 {
    @Test
    public void webLoginHomeLoan(){
//      selenium
        System.out.println("Web login Home");
    }

    @Test
    public void MobileLoginHomeLoan(){
//      appium
        System.out.println("Mobile login Home");
    }

    @Test
    public void LoginAPIHomeLoan(){
        System.out.println("API login Home");
    }

    @BeforeTest
    public void beforeTest(){
        System.out.println("I am before test");
    }



}
