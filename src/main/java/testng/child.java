package testng;

import org.testng.annotations.Test;

public class child extends parent{

    @Test
    public void test(){
        parentMethod();

        int a = 3;
        helper help = new helper(a);
        System.out.println(help.increment());
        System.out.println(help.decrement());
        System.out.println(help.multiplyTwo());
    }
}
