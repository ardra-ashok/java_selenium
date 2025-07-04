package org.streams;

import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.testng.AssertJUnit.assertTrue;

public class StreamExamples {

    @Test
    public void streamFilter(){
        ArrayList<String> names = new ArrayList<String>();
        names.add("Azprila");
        names.add("Dana");
        names.add("August");
        names.add("Vinca");
        names.add("Aaron");

        long c = names.stream().filter(s->s.startsWith("A")).count();

        names.stream().filter(s->s.length()>4).limit(1).forEach(s-> System.out.println(s));
        System.out.println("-----");
        names.stream().filter(s->s.endsWith("a")).map(s->s.toUpperCase()).forEach(s-> System.out.println(s));

        System.out.println("-----");
        names.stream().filter(s->s.startsWith("A")).sorted().map(s->s.toUpperCase()).forEach(s-> System.out.println(s));
        System.out.println("-----");
//
        List<String> names1 = Arrays.asList("Ardra","Vinc","Harry","Don");
        Stream<String> newStream = Stream.concat(names.stream(),names1.stream());
//        newStream.sorted().forEach(s-> System.out.println(s));
        System.out.println("-----");


//        assertTrue(newStream.anyMatch(s->s.equalsIgnoreCase("ardra")));

//        Collect
        System.out.println("collect");
        List<String> ls = names.stream().filter(s->s.endsWith("a")).map(s->s.toUpperCase()).collect(Collectors.toList());
        ls.stream().forEach(s-> System.out.println(s));

        List<Integer> values = Arrays.asList(3,2,2,7,5,1,9,7);
        List<Integer> number = values.stream().distinct().sorted().toList();



    }


}
