package org.example;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {

    public static void printTheFibonacciSeries() { // Fibonacci series
        int a = 0, b = 1; // first two numbers
        System.out.print(a + " " + b + " "); // print first two numbers
        for (int i = 1; i <= 5; i++) { // loop to generate next 5 numbers
            int c = a + b; // next number is sum of previous two
            System.out.print(c + " "); // print next number
            a = b; // update a to b
            b = c; // update b to c
        }

        //output = 0 1 1 2 3 5
    }

    public static void reverseAStringDotSamePlace(String s) { // Reverse a string keeping dots in same place
        int length = s.length(); // length of string
        char[] chars = s.toCharArray(); // convert string to char array
        int first = 0; // first pointer
        int last = length - 1; // last pointer
        while (first < last) { // loop until first is less than last
            if (chars[first] == '.') { // if first char is dot
                first++; // move first pointer to right
            } else if (chars[last] == '.') { // if last char is dot
                last--; // move last pointer to left
            }
            char temp = chars[first]; // swap first and last chars
            chars[first] = chars[last]; // swap first and last chars
            chars[last] = temp; // swap first and last chars
            first++; // move first pointer to right
            last--; // move last pointer to left
        }
        System.out.println(chars);
    }



    public static void main(String[] args) {
        //sample();
        //reverseAStringDotSamePlace("Hari.pra");
        int[] arr = {2, 3, 1, 2, 3};
//findTheDuplicateElement(arr);        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
//        System.out.printf("Hello and welcome!");
//
//        for (int i = 1; i <= 5; i++) {
//            //TIP Press <shortcut actionId="Debug"/> to start debugging your code. We have set one <icon src="AllIcons.Debugger.Db_set_breakpoint"/> breakpoint
//            // for you, but you can always add more by pressing <shortcut actionId="ToggleLineBreakpoint"/>.
//            System.out.println("i = " + i);
//        }


    }
}