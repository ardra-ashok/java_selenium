package practise;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.sql.SQLOutput;
import java.util.*;

public class Practise_1 {

    @Test
    public void testComponents() {
//        WebDriver webDriver = new ChromeDriver();
//        webDriver.manage().window().maximize();
//        webDriver.get("https://the-internet.herokuapp.com/basic_auth");
//        webDriver.findElement("");
//        webDriver.findElement("");

        String str = "banana";
        char targetChar = 'a';
        int count = 0;
        for (char s : str.toCharArray()) {
            if (targetChar == s)
                count++;
        }
        System.out.println(count);


    String str_2 = new String("hello");
    String str_1 = new String("hello");
        System.out.println(str_1.equals(str_2));

        ArrayList<String> a = new ArrayList<>();
        a.add("apple");
        a.add("banana");
        a.add("cherry");
        a.add("mango");
        a.add("apple");

        System.out.println(a.size());
        for(int i=0;i<a.size();i++){
            System.out.println(a.indexOf(a.get(i))+":"+a.get(i));
        }

        HashMap<Integer,String> m = new HashMap<>();
        m.put(0,"kerala");
        m.put(1,"maha");
        m.put(2,"jammu");
        Set s = m.entrySet();
        Iterator it = s.iterator();
        while(it.hasNext()){
            Map.Entry mp = (Map.Entry)it.next();
            System.out.println(mp.getKey()+": "+mp.getValue());
        }

        System.out.println("------");
        int b[]= {4,5,6,8,4,9,5,9,8,6,8,3};
        HashMap<Integer,Integer> countMap = new HashMap<>();
        for(int i=0;i<b.length;i++){
           if(!countMap.containsKey(b[i])){
               countMap.put(b[i],1);
               for(int j=i+1;j<b.length;j++){
                   if(b[i]==b[j])
                       countMap.put(b[i],countMap.get(b[i])+1);
               }
           }
        }
        System.out.println(countMap);

        HashMap<String,Integer> countMap_1 = new HashMap<>();

        String str_8 = "hello I am ardra".trim();

        String[] str_arr = str_8.split("");
        for(String c: str_arr){
            if(!c.equals(" "))
                countMap_1.put(c, countMap_1.getOrDefault(c,0)+1);
        }
        System.out.println(countMap_1);

        String st = "hello";
        String str_9 = "hello";
        String s_1 = new String("hello");
        String s_2 = new String("hello");
        System.out.println(st==str_9);
        System.out.println(st==s_2);
        System.out.println(st.equals(s_2));
        System.out.println(s_1.equals(s_2));

    }

}
