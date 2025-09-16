package org.example;

public class FindNUniqueIntegersSumuptoZero1304 {
     public int[] sumZero(int n) {
         int[] A = new int[n];
         int p = 0;
         for(int i = 0; i< n/2; i++){
                 A[p++] = (i+1);
                 A[p++] = -(i+1);
         }
         return A;
     }
    public int[] sumZero1(int n) {
        int[] res = new int[n];
        res[0] = n * (1 - n) / 2;
        for (int i = 1; i < n; ++i)
            res[i] = i;
        return res;
    }

    public static void main(String[] args) {
        FindNUniqueIntegersSumuptoZero1304 solution = new FindNUniqueIntegersSumuptoZero1304();
        int n = 5;
        int[] result = solution.sumZero(n);
        for (int num : result) {
            System.out.print(num + " ");
        }
    }

}
