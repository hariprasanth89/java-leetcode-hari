package org.example.dinesh;

public class NthPrime {

    public static boolean isPrime(int N){
        for(int i=2; i*i <= N; i++){
            if (N % i == 0)
                return false;
        }
        return true;
    }
    public static int findNthPrime(int N) {
        int counter = 0;
        if (N == 0)
            return -1;

        if (N == 1)
            return 2;

        // 2 is prime
        counter++;

        for (int i = 3; i <= Integer.MAX_VALUE; i += 2) {
            if (isPrime(i)) {
                counter++;
                if (counter == N)
                    return i;
            }
        }
        return -1;
    }
    public static void main(String[] args) {
        int N = 9;
        System.out.println(N + " (st/nd/rd/th) prime is " + findNthPrime(N));
    }
}
