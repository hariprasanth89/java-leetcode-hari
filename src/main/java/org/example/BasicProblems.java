package org.example;

public class BasicProblems {
    public static void printTable(int n)  {
        for (int i = 1; i <= n; i++) { // outer loop for rows
            System.out.println(i + " * " + n + " = " + (n * i)); // print multiplication result
        }
    }
    public static void printTableRange(int n)  { // prints multiplication tables from 1 to n
        for(int i = 1; i <= n; i++) { // outer loop for each table
            for (int j = 1; j <= 10; j++) { // inner loop for each multiplication
                System.out.println(j + " * " + i + " = " + (j * i)); // print multiplication result
            }
            System.out.println("----------"); // separator between tables
        }

    }
    public static void main(String[] args) {

        int n = 10;
        printTable(n); // prints multiplication table of n
//        printTableRange(n); // prints multiplication tables from 1 to n
    }
}
