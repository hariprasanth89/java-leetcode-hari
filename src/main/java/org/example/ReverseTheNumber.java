package org.example;

public class ReverseTheNumber {

    public static int reverseNumber(int num) {
        int reversedNum = 0;
        while (num != 0) {
            int digit = num % 10;
            reversedNum = reversedNum * 10 + digit;
            num /= 10;
        }
        return reversedNum;
    }

    public static int reverseNumberOptimizedSolution(int num) {
        int reversedNum = 0; // Initialize the variable to store the reversed number
        while (num != 0) { // Loop until all digits are processed
            reversedNum = reversedNum * 10 + num % 10; // Add the last digit of num to reversedNum
            num /= 10; // Remove the last digit from num
        }
        return reversedNum; // Return the reversed number
    }
    public static int revNum(int num){
        int reversedNum = 0;
        for(int i = 0; i<num; i++){
            reversedNum = reversedNum *10+num%10;
            num /=10;
        }
        return reversedNum;
    }
    public static boolean isPalindrome(int num) {
        int reversedNum = reverseNumber(num);
        //int revNum = revNum(num);
        return num == reversedNum;
    }

    public static boolean isPalindromeNumber(int x) {
        if( x < 0) return false;
        int temp =  x;
        int reverseNum = 0;
         while( x != 0){
                 reverseNum = (reverseNum *10) + (x % 10);
                 x /=10;
         }

        return temp == reverseNum;
    }


    public static void main(String[] args) {
        //int number = 12345;
        int number = 535;
//        int reversed = reverseNumber(number);
//        int reverseNumberOptimizedSolution = reverseNumberOptimizedSolution(number);
//        System.out.println("reverseNumberOptimizedSolution: " + reverseNumberOptimizedSolution);
//        System.out.println("Original number: " + number);
//        System.out.println("Reversed number: " + reversed); // Output: 54321
//        if (number == reversed) {
//            System.out.println("The number is a palindrome.");
//        } else {
//            System.out.println("The number is not a palindrome.");
//        }
       // System.out.println(revNum(number));
        System.out.println(isPalindromeNumber(-121));

    }

}
