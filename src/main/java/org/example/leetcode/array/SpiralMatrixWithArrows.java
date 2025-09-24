package org.example.leetcode.array;

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrixWithArrows {

    public static List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<>();

        if (matrix == null || matrix.length == 0) {
            return result;
        }

        int rows = matrix.length;
        int cols = matrix[0].length;
        int top = 0, bottom = rows - 1;
        int left = 0, right = cols - 1;

        System.out.println("Original Matrix (" + rows + "x" + cols + "):");
        printMatrixWithArrows(matrix, -1, -1, "START");
        System.out.println();

        int step = 1;

        while (top <= bottom && left <= right) {
            System.out.println("═".repeat(50));
            System.out.println("STEP " + step + " - Boundaries: top=" + top + ", bottom=" + bottom +
                    ", left=" + left + ", right=" + right);
            System.out.println("═".repeat(50));

            // Step 1: → Traverse from left to right along top row
            if (top <= bottom) {
                System.out.println("DIRECTION → : Top Row (left to right)");
                for (int i = left; i <= right; i++) {
                    result.add(matrix[top][i]);
                    printMatrixWithArrows(matrix, top, i, "→");
                    System.out.println("Added: " + matrix[top][i] + " at position [" + top + "][" + i + "]");
                }
                top++;
                System.out.println("↑ Top boundary moved to: " + top);
            }

            // Step 2: ↓ Traverse from top to bottom along right column
            if (left <= right) {
                System.out.println("\nDIRECTION ↓ : Right Column (top to bottom)");
                for (int i = top; i <= bottom; i++) {
                    result.add(matrix[i][right]);
                    printMatrixWithArrows(matrix, i, right, "↓");
                    System.out.println("Added: " + matrix[i][right] + " at position [" + i + "][" + right + "]");
                }
                right--;
                System.out.println("← Right boundary moved to: " + right);
            }

            // Step 3: ← Traverse from right to left along bottom row
            if (top <= bottom) {
                System.out.println("\nDIRECTION ← : Bottom Row (right to left)");
                for (int i = right; i >= left; i--) {
                    result.add(matrix[bottom][i]);
                    printMatrixWithArrows(matrix, bottom, i, "←");
                    System.out.println("Added: " + matrix[bottom][i] + " at position [" + bottom + "][" + i + "]");
                }
                bottom--;
                System.out.println("↓ Bottom boundary moved to: " + bottom);
            }

            // Step 4: ↑ Traverse from bottom to top along left column
            if (left <= right) {
                System.out.println("\nDIRECTION ↑ : Left Column (bottom to top)");
                for (int i = bottom; i >= top; i--) {
                    result.add(matrix[i][left]);
                    printMatrixWithArrows(matrix, i, left, "↑");
                    System.out.println("Added: " + matrix[i][left] + " at position [" + i + "][" + left + "]");
                }
                left++;
                System.out.println("→ Left boundary moved to: " + left);
            }

            step++;
            System.out.println("\nCurrent result: " + result);
            System.out.println();
        }

        return result;
    }

    private static void printMatrixWithArrows(int[][] matrix, int currentRow, int currentCol, String direction) {
        System.out.println();

        // Print column indices header
        System.out.print("    ");
        for (int j = 0; j < matrix[0].length; j++) {
            System.out.printf("%-4d", j);
        }
        System.out.println();

        // Print top border
        System.out.print("   ┌");
        for (int j = 0; j < matrix[0].length; j++) {
            System.out.print("────");
        }
        System.out.println("┐");

        for (int i = 0; i < matrix.length; i++) {
            // Print row index
            System.out.printf("%2d │", i);

            for (int j = 0; j < matrix[0].length; j++) {
                if (i == currentRow && j == currentCol) {
                    // Current position with arrow
                    switch (direction) {
                        case "→": System.out.printf(" %-2s ", matrix[i][j] + "→"); break;
                        case "↓": System.out.printf(" %-2s ", matrix[i][j] + "↓"); break;
                        case "←": System.out.printf(" %-2s ", matrix[i][j] + "←"); break;
                        case "↑": System.out.printf(" %-2s ", matrix[i][j] + "↑"); break;
                        default: System.out.printf(" %-2s ", matrix[i][j] + "•"); break;
                    }
                } else {
                    System.out.printf(" %-3d", matrix[i][j]);
                }
            }
            System.out.println("│");
        }

        // Print bottom border
        System.out.print("   └");
        for (int j = 0; j < matrix[0].length; j++) {
            System.out.print("────");
        }
        System.out.println("┘");
    }

    private static void printBoundaries(int[][] matrix, int top, int bottom, int left, int right) {
        System.out.println("\nCurrent Boundaries:");
        System.out.println("Top: " + top + ", Bottom: " + bottom + ", Left: " + left + ", Right: " + right);

        // Print column indices
        System.out.print("    ");
        for (int j = 0; j < matrix[0].length; j++) {
            System.out.printf("%-4d", j);
        }
        System.out.println();

        // Print matrix with boundaries highlighted
        for (int i = 0; i < matrix.length; i++) {
            System.out.printf("%2d ", i);
            for (int j = 0; j < matrix[0].length; j++) {
                if (i >= top && i <= bottom && j >= left && j <= right) {
                    System.out.printf("[%-2d]", matrix[i][j]); // Inside current boundaries
                } else {
                    System.out.printf(" %-2d ", matrix[i][j]); // Outside boundaries
                }
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

        System.out.println("SPIRAL MATRIX TRAVERSAL WITH VISUAL ARROWS");
        System.out.println("=".repeat(60));

        List<Integer> result = spiralOrder(matrix);

        System.out.println("=".repeat(60));
        System.out.println("FINAL SPIRAL ORDER: " + result);

        // Test with square matrix
        System.out.println("\n" + "=".repeat(60));
        System.out.println("TEST WITH 4x4 MATRIX");
        System.out.println("=".repeat(60));

        int[][] squareMatrix = {
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12},
                {13, 14, 15, 16}
        };

        List<Integer> squareResult = spiralOrder(squareMatrix);
        System.out.println("FINAL SPIRAL ORDER: " + squareResult);
    }
}
