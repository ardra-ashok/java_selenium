package test;

import org.testng.annotations.*;

public class TestNG_Annotations_1 {

    @Test(groups={"smoke"})
    public void test(){System.out.println("I am from TestNG Annotations_1");}

    @Test(dataProvider = "getData")
    public void dependent_1(String username, String password){System.out.println("I am testing dependency_1");
        System.out.println(username+"---"+password);
    }
    @Test(timeOut=4000)
    public void dependent_2(){System.out.println("I am testing dependency_2");
    }
    @Parameters({"testKey"})
    @Test(dependsOnMethods = {"dependent_1","dependent_2"},timeOut = 2000)
    public void ExampleDependent(String urlName){System.out.println("I am a dependent method");
        System.out.println(urlName);
    }

    @Test(enabled = false)
    public void notEnabled(){System.out.println("I am from enabled false");
    }

    @DataProvider
    public Object[][] getData() {
        Object[][] data = new Object[3][2];
        data[0][0] = "username_1";
        data[0][1] = "pass_1";
        data[1][0] = "username_2";
        data[1][1] = "pass_2";
        data[2][0] = "username_3";
        data[2][1] = "pass_3";
        return data;
    }
}
