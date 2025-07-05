package testng;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class parent {

    @BeforeMethod
    public void beforeMethod(){
        System.out.println("I am before method");
    }

    public void parentMethod(){
        System.out.println("I am parent method");
    }

    @AfterMethod
    public void afterMethod(){
        System.out.println("I am after method");
    }
}
