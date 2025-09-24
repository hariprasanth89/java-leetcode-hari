package org.example.leetcode.array;

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix54 {


    public static List<Integer> spiralMatrix(int[][] matrix){

        int rowLower = 0;  int rowUpper = matrix.length - 1;
        int colLower = 0; int colUpper = matrix[0].length -1;
        List<Integer> result = new ArrayList<>();
//        int top = 0; int bottom = matrix.length - 1;
//        int left = 0;  int right = matrix[0].length - 1;


        while(rowLower <= rowUpper  && colLower <= colUpper){
            // move left to right
            for (int i = colLower; i <= colUpper; i++){
                result.add(matrix[rowLower][i]);
                System.out.print(matrix[rowLower][i] + "  -> ");
            }
        rowLower++;  //
            // move top to right bottom
            for (int i = rowLower; i <= rowUpper; i++){
                result.add(matrix[i][colUpper]);
                System.out.print(matrix[i][colUpper] + " -> ");
            }
            colUpper --;
            // checking the boundary condition in case of not th                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                              e square matrix

            if (rowLower > rowUpper || colLower > colUpper)break;
            // right bottom to left bottom
            for (int i = colUpper;  i >= colLower; i--  ){
                result.add(matrix[rowUpper][i]);
                System.out.print(matrix[rowUpper][i] + " ->  ");
            }
            rowUpper --;
            // left bottom to left top
            for (int i = rowUpper; i >= rowLower; i--){
                result.add(matrix[i][colLower]);
                System.out.print(matrix[i][colLower] + " -> ");

            }
            colLower ++;
        }
        System.out.println();
        return result;
    }

    public static void main(String[] args) {
        int[][] matrix = {{1,2,3,4},{5,6,7,8},{9,10,11,12}};
        System.out.println("Spiral Matrix");
        spiralMatrix(matrix).stream().forEach(e -> System.out.print(e + "  -> "));
    }

}
