package org.example.walmart;

import java.util.Arrays;

public class CountPrimes {

    public static int countPrimes(int n) {
        if (n <= 2) return 0;

        boolean[] isPrime = new boolean[n];
        // Assume all numbers are prime initially
        for (int i = 2; i < n; i++) {
            isPrime[i] = true;
        }
       // Arrays.fill(isPrime, true);

        // Sieve of Eratosthenes
        for (int i = 2; i * i < n; i++) {
            if (isPrime[i]) {
//                System.out.println(i);
                for (int j = i * i; j < n; j += i) {
                    System.out.println(i + "   "+ j);
                    isPrime[j] = false; // Mark multiples of i as not prime
                }
            }
        }

        // Count remaining true values (i.e., primes)
        int count = 0;
        for (int i = 2; i < n; i++) {
            if (isPrime[i]){
                //System.out.println(i); // Print each prime number
                count++;
            }
        }

        return count;    }

    public static int countPrimesOptimized(int n) {
        if (n <= 2) return 0;

        boolean[] isPrime = new boolean[n];
        Arrays.fill(isPrime, true); // Assume all numbers are prime initially

        // 0 and 1 are not prime
        isPrime[0] = false;
        isPrime[1] = false;

        // Sieve of Eratosthenes
        // We only need to iterate up to sqrt(n)
        for (int i = 2; i * i < n; i++) {
            if (isPrime[i]) {
                // Mark multiples of i as not prime, starting from i*i
                // Numbers less than i*i that are multiples of i would have already been marked
                // by smaller prime factors.
                for (int j = i * i; j < n; j += i) {
                    isPrime[j] = false;
                }
            }
        }

        // Count remaining true values (i.e., primes)
        int count = 0;
        for (int i = 2; i < n; i++) {
            if (isPrime[i]) {
                count++;
            }
        }

        return count;

    }

    // Test the function
    public static void main(String[] args) {
        int n = 10;
        int result = countPrimes(n);
        System.out.println("Number of primes less than " + n + " is: " + result);
    }
}

