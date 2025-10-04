package org.example.java8features;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StringsInJava8 {


    public static void main(String[] args) {
        List<String> listItem = new ArrayList();
        List<String> listItemString = new ArrayList();
        List<String> result = new ArrayList();

        listItem.add("aa");
        listItem.add("bb");
        listItem.add("CC");
        listItemString.add("dd");
        listItemString.add("cc");
        listItemString.add("aa");

        result.addAll(Stream.concat(listItem.stream(), listItemString.stream()).filter(s -> s.contains("aa")).collect(Collectors.toList()));
        result.forEach(System.out::println);

//        for(int i =0; i < listItem.size()-1; i++){
//            if(listItem.get(i).equalsIgnoreCase("aa")){
//                result.add(listItem.get(i));
//            }
//        }

        // for(int i =0; i < listItemString.size(); i++){
        //     if(listItemString.get(i).equalsIgnoreCase("aa")){
        //         result.add(listItemString.get(i));
        //     }
        // }


//        result.forEach(item -> {
//            System.out.println("result " + item);
//        });
        List<String> listStr = Arrays.asList("AA","BB","CC","AA");
//        listStr.forEach(item -> {
//           // System.out.println("result " + item);
//            if (item.equalsIgnoreCase("AA")){
//                System.out.println(listStr.indexOf(item));
//            }
//        });
        IntStream.range(0, listStr.size()).forEach(i -> {
            if (listStr.get(i).equalsIgnoreCase("AA")){
                System.out.println(STR."\{i}   \{listStr.get(i)}");
            }
        });

    }


}
