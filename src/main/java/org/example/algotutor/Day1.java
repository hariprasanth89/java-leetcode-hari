package org.example.algotutor;

public class Day1 {


    public static int factorNumsWithOutOptimizeSolution(int num){

        int count =0;
        for(int i = 1;  i <= num; i++){
            if(num % i == 0){
                if (num != i ){
                    System.out.print(STR."\{i} -> ");
                } else {
                    System.out.println(i);
                }
                count++;
            }
        }
        return count;
    }

    public static int factorNumsWithOptimizeSolution(int num){
        long startTime = System.currentTimeMillis();
        int count =0;
        for(int i = 1;  i * i <= num; i++){
            if(num % i == 0){
                if( i == num/i){
                    count++;
                } else {
                    count +=2;
                }
            }
        }
        long endTime = System.currentTimeMillis();
        System.out.println(STR."Total Time Execution : \{endTime - startTime}");
        return count;
    }

    // Brute force solution to count factors and print them
    public static int factorNumsBruteForce(int num) {
        long startTime = System.currentTimeMillis();
        int count = 0;
        System.out.print(STR."Factors of \{num}: ");
        for (int i = 1; i <= num; i++) {
            if (num % i == 0) {
                if (count > 0) { // Add " -> " separator for subsequent factors
                    System.out.print(" -> ");
                }
                System.out.print(i);
                count++;
            }
        }
        System.out.println(); // New line after printing all factors
        long endTime = System.currentTimeMillis();
        System.out.println(STR."Brute Force Execution Time : \{endTime - startTime} ms");
        return count;
    }

    // Optimized solution to count factors
    public static int factorNumsOptimized(int num) {
        long startTime = System.currentTimeMillis();
        int count = 0;
        for (int i = 1; i * i <= num; i++) {
            if (num % i == 0) {
                if (i * i == num) { // If i is a perfect square root, count only once
                    count++;
                } else {
                    count += 2; // Count i and num/i as two distinct factors
                }
            }
        }
        long endTime = System.currentTimeMillis();
        System.out.println(STR."Optimized Execution Time : \{endTime - startTime} ms");
        return count;
    }




    public static void main(String[] args) {
//        System.out.println(STR." No Optimize solution Count Of Factors : \{factorNumsWithOutOptimizeSolution(36)}");
//        System.out.println(STR."Optimize solution - Count Of Factors : \{factorNumsWithOptimizeSolution(36)}");

        int num = 36;
        System.out.println(STR."Brute Force Count Of Factors for \{num}: \{factorNumsBruteForce(num)}");
        System.out.println(STR."Optimized Count Of Factors for \{num}: \{factorNumsOptimized(num)}");
    }


}
