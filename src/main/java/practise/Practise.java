package practise;

import org.testng.annotations.Test;

import java.util.stream.Stream;

public class Practise {

    @Test
    public void test(){
        int k=1;
        for(int i=0;i<=3;i++) {
            for (int j = 0; j <=3-i; j++) {
                System.out.print(k);
                System.out.print("\t");
                k++;
            }
            System.out.println("\n");
        }
        System.out.println("------");
        k=1;
        for(int i=0;i<4;i++){
            for(int j=1;j<=i;j++){
                System.out.print(j);
                System.out.print("\t");
//                k++;
            }
            System.out.println();
        }

        int a[] = new int[10];
        k=1;
        for(int i=0;i<a.length;i++){
            a[i]= k;
            k++;
        }

        k=0;
        for(int i=0;i<a.length;i++){
            for(int j=0;j<a.length;j++) {
                if (a[i] > a[j]) {


//                    k = a[i];
//                    a[i] = a[j];
//                    a[j] = k;
                }
            }
        }
        System.out.println("------");
        for(int i:a)
            System.out.println(i);

//        sort an array

//        find the count of the char in a char

        String str = "banana";
        char targetChar = 'a';
        int count =0;
        for(char s:str.toCharArray())
        {
            if(targetChar==s)
                count++;
        }
        System.out.println(count);




    }
}
