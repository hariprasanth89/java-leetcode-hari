package org.example.leetcode.array;

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrixBoundaryView {

    public static List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<>();
        if (matrix == null || matrix.length == 0) return result;

        int top = 0, bottom = matrix.length - 1;
        int left = 0, right = matrix[0].length - 1;

        System.out.println("Initial Matrix:");
        printMatrixWithBoundaries(matrix, top, bottom, left, right);

        while (top <= bottom && left <= right) {
            // → Right movement
            System.out.println("\n→ Moving RIGHT along top row " + top + ":");
            for (int i = left; i <= right; i++) {
                result.add(matrix[top][i]);
                printCurrentPosition(matrix, top, i, "→", result);
            }
            top++;

            // ↓ Down movement
            if (top <= bottom) {
                System.out.println("\n↓ Moving DOWN along right column " + right + ":");
                for (int i = top; i <= bottom; i++) {
                    result.add(matrix[i][right]);
                    printCurrentPosition(matrix, i, right, "↓", result);
                }
                right--;
            }

            // ← Left movement
            if (top <= bottom) {
                System.out.println("\n← Moving LEFT along bottom row " + bottom + ":");
                for (int i = right; i >= left; i--) {
                    result.add(matrix[bottom][i]);
                    printCurrentPosition(matrix, bottom, i, "←", result);
                }
                bottom--;
            }

            // ↑ Up movement
            if (left <= right) {
                System.out.println("\n↑ Moving UP along left column " + left + ":");
                for (int i = bottom; i >= top; i--) {
                    result.add(matrix[i][left]);
                    printCurrentPosition(matrix, i, left, "↑", result);
                }
                left++;
            }

            System.out.println("\nCurrent Boundaries: top=" + top + ", bottom=" + bottom +
                    ", left=" + left + ", right=" + right);
            printMatrixWithBoundaries(matrix, top, bottom, left, right);
        }

        return result;
    }

    private static void printCurrentPosition(int[][] matrix, int row, int col, String arrow, List<Integer> result) {
        System.out.printf("  [%d][%d] %s %-2d → Result: %s%n",
                row, col, arrow, matrix[row][col], result);
    }

    private static void printMatrixWithBoundaries(int[][] matrix, int top, int bottom, int left, int right) {
        System.out.println("Matrix View (boundaries highlighted):");

        // Header
        System.out.print("     ");
        for (int j = 0; j < matrix[0].length; j++) {
            System.out.printf("%-3d", j);
        }
        System.out.println();

        // Matrix with boundaries
        for (int i = 0; i < matrix.length; i++) {
            System.out.printf("%2d: ", i);
            for (int j = 0; j < matrix[0].length; j++) {
                String format;
                if (i == top && j >= left && j <= right) {
                    format = "→%-2d"; // Top boundary
                } else if (i == bottom && j >= left && j <= right) {
                    format = "←%-2d"; // Bottom boundary
                } else if (j == left && i >= top && i <= bottom) {
                    format = "↑%-2d"; // Left boundary
                } else if (j == right && i >= top && i <= bottom) {
                    format = "↓%-2d"; // Right boundary
                } else if (i >= top && i <= bottom && j >= left && j <= right) {
                    format = "■%-2d"; // Inside boundaries
                } else {
                    format = " %-2d"; // Outside boundaries
                }
                System.out.printf(format, matrix[i][j]);
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int[][] matrix = {
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12}
        };

        List<Integer> result = spiralOrder(matrix);
        System.out.println("\nFinal Spiral Order: " + result);
    }
}
