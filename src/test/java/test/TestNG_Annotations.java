package test;

import org.testng.annotations.*;

public class TestNG_Annotations {

    @BeforeTest
    public void beforeTest(){System.out.println("I am before test");}
    @Test(groups={"smoke"})
    public void Test_1(){System.out.println("I am test 1");}
    @Test
    public void Test_2(){System.out.println("I am test 2");}
    @Test(groups={"smoke"})
    public void Appium_test(){System.out.println("I am Appium test");}
    @Test
    public void Web_test(){System.out.println("I am Web-8 test");}


    @AfterMethod
    public void AfterMethod(){System.out.println("I am after method");}

    @BeforeMethod
    public void BeforeMethod(){System.out.println("I am before method");}

    @AfterTest
    public void AfterTest(){System.out.println("I am after test");}

    @BeforeClass
    public void BeforeClass(){System.out.println("I am Before Class");}

    @AfterClass
    public void AfterClass(){System.out.println("I am After Class");}

    @BeforeSuite
    public void BeforeSuite(){System.out.println("I am Before Suite");}

    @AfterSuite
    public void AfterSuite(){System.out.println("I am After Suite");}
}
