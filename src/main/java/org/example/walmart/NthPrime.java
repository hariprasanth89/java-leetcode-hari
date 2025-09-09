package org.example.walmart;

public class NthPrime {

    // Method to check if a number is prime
    public static boolean isPrime(int num) {
        if (num < 2) return false;

        // Only check up to square root of num
        for (int i = 2; i * i <= num; i++) {
            if (num % i == 0)
                return false;
        }
        return true;
    }

    // Method to find the nth prime number
    public static int nthPrime(int n) {
        int count = 0;
        int number = 1;

        while (count < n) {
            number++;
            if (isPrime(number)) {
                count++;
            }
        }

        return number;
    }

    // Main method to test
    public static void main(String[] args) {
        int n = 10; // Find the 10th prime
        int result = nthPrime(n);
        System.out.println("The " + n + "th prime number is: " + result);
    }
}

