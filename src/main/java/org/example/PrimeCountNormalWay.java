package org.example;

public class PrimeCountNormalWay {

    public static int primeCount(int num){
        int count = 0 ;
        if(num <= 1) return num - 1;
        for(int i =2; i <= num; i++ ){
            boolean isPrime = true;
            for ( int j = 2; j <= i/2; j++){
                if(i % j == 0){
                    isPrime = false;
                    break;
                }
            }
            if(isPrime) {
                count++;
                System.out.println(i);
            }

        }
        System.out.println("count " + count);
        return count;
    }


    public static int primeCount2nd(int num){ // working prefer
        int count = 0 ;
        if(num <= 1) return num - 1;
        for(int i =2; i <= num; i++ ){
            boolean isPrime = true;
            for(int j = 2; j <= Math.sqrt(i); j++){
                if(i % j == 0){
                    isPrime = false;
                    break;
                }
            }
            if(isPrime) {
                count++;
                System.out.println(i);
            }

        }
        System.out.println("count " + count);
        return count;
    }

    public static void main(String[] args) {
        System.out.println("Hello world!");

primeCount(10);

    }



}
