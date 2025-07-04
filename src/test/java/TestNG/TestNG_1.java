package TestNG;

import org.testng.annotations.Test;

public class TestNG_1 {


    @Test(groups = {"smoke"})
    public void Demo(){
        System.out.println("hello");
    }

    @Test
    public void Demo_1(){
        System.out.println("hello_1");
    }


}
