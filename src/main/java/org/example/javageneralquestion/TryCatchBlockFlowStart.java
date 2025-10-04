package org.example.javageneralquestion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

public class TryCatchBlockFlowStart {

    public static void test() {
//        try {
//            System.out.println("Inside the Try block");
//        } finally {
//            System.out.println("Finally block executed");
//        }
    }

    public static int test1() {
        try {
            System.out.println("Inside the Try block");
            return 10;
        } finally {
            System.out.println("Finally block executed");
            return 20;
        }
    }

    public static int test2() {
        int x = 0;
        try {
            System.out.println("Inside the Try block");
            return x = 1;
        } finally {
            System.out.println("Finally block executed");
            x = 10;
            //return x;
        }
    }

    public static void test3() {
        try {
            System.out.println("parent try block");
            try {
                System.out.println("Inside the Try block");
                int result = 10/0;
            } catch (ArithmeticException e) {
                System.out.println(STR."outer catch block\{e.getMessage()}");
            }
            int[] A = new int[0];
            System.out.println(A[1]);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println(STR."array index out of bounds parent  catch block\{e.getMessage()}");
        }
    }
    
    public static void test4() {
        List<String> list = new ArrayList<>(Arrays.asList("a", "b", "c"));
        for (String s : list) {
          // list.remove(s);   // ConcurrentModificationException
            // list.add(s);         // DoncurrentModificationException
         //   System.out.println(s);
        }

        Iterator<String> stringIterator = list.iterator();
        while (stringIterator.hasNext()) {
            if (stringIterator.next().equals("b")) {
                stringIterator.remove();
            }
        }
        System.out.println(list);
//        ConcurrentHashMap<String, String> map = new ConcurrentHashMap<>();
//        map.put("a", "A");
//        map.put("b", "B");
//        map.put("c", "C");
//        for (String s : map.keySet()) {
//            map.put("a", "ad");
//            System.out.println(map);
//        }

    }

    public static void main(String[] args) {
        //test();
       // System.out.println(test1());
        //System.out.println(test2());
//        test3();
        test4();
    }

}
