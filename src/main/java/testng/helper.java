package testng;

public class helper extends helper2{

    int a;
    public helper(int a) {
        super(a);
        this.a =a;
    }

    public int increment(){return ++a;}
    public int decrement(){return --a;}

}
