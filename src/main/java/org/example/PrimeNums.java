package org.example;

public class PrimeNums {

    public static void printPrimes(int n) {
        for (int i = 2; i <= n; i++) {
            boolean isPrime = true;
            for (int j = 2; j <= Math.sqrt(i); j++) {
                if (i % j == 0) {
                    isPrime = false;
                    break;
                }
            }
            if (isPrime) {
                System.out.print(i + " ");
            }
        }
    }
    public static void printPrimeNumbers(int n) {
        if(n == 0 || n == 1) { // 0 and 1 are not prime numbers
            System.out.println("No prime numbers");
            return; // Exit the method
        }
        for(int i = 2; i <= n; i++) { // Check for each number from 2 to n
            boolean isPrime = true; // Assume the number is prime
            for(int j = 2; j <= i/2; j++) { // Check divisibility from 2 to i/2
                if(i % j == 0) { // If i is divisible by j, it's not prime
                    isPrime = false; // Mark as not prime
                    break; // No need to check further
                }
            }
            if(isPrime) { // If the number is still marked as prime
                System.out.print(i + " "); // Print the prime number
            }
        }
    }


    public static void main(String[] args) {
        printPrimeNumbers(10);
        System.out.println();
        printPrimes(10);
    }
}
