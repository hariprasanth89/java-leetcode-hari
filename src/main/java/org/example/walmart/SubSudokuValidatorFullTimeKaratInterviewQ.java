package org.example.walmart;

import java.util.HashSet;
import java.util.Arrays; // Import Arrays for potential use in optimized solution
import java.util.Set;

public class SubSudokuValidatorFullTimeKaratInterviewQ {

    /**
 * Brute Force Approach:
 * For each row and each column, iterate through all elements and check if they are unique and within the range [1, N].
     * Given an N x N matrix, returns true if every row and column contains the numbers 1..N.
     * The input matrix can contain any signed integer.
     *
     * @param grid The N x N integer matrix to validate.
     * @return True if the grid is a valid sub-Sudoku grid, otherwise false.
     *
     * Complexity Analysis:
 * N = The number of rows/columns in the matrix.
 * Time: O(N^3) - For each of the N rows, we iterate N elements. For each element, checking uniqueness in a list takes O(N). So, O(N*N*N) = O(N^3).
 * Space: O(N) - To store a temporary list of seen numbers for each row/column.
     */
    public static boolean validateSudoku(int[][] grid) {
        // Check for edge cases: if the grid is null, empty, or has empty rows.
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            // If any of these conditions are met, it's an invalid grid.
            return false;
        }

        // Determine the size of the grid (N), which is the number of rows.
        int N = grid.length;
        // Check if the grid is square (N x N).
        if (N != grid[0].length) {
            // If the number of rows is not equal to the number of columns, it's not a square grid.
            return false; // Not a square grid
        }

        // Step 1: Check each row for validity.
        for (int i = 0; i < N; i++) {
            // Create a HashSet for the current row to track seen numbers efficiently.
            HashSet<Integer> seenNumbers = new HashSet<>();
            // Iterate through each element in the current row.
            for (int j = 0; j < N; j++) {
                // Get the current number from the grid.
                int number = grid[i][j];
                // Check if the number is within the valid range [1, N] and if it's a duplicate in the current row.
                if (number < 1 || number > N || seenNumbers.contains(number)) {
                    // If any condition fails, the row is invalid, so the Sudoku is invalid.
                    return false;
                }
                // Add the number to the set of seen numbers for the current row.
                seenNumbers.add(number);
            }
        }

        // Step 2: Check each column for validity.
        for (int j = 0; j < N; j++) {
            // Create a HashSet for the current column to track seen numbers efficiently.
            HashSet<Integer> seenNumbers = new HashSet<>();
            // Iterate through each element in the current column.
            for (int i = 0; i < N; i++) {
                // Get the current number from the grid.
                int number = grid[i][j];
                // Check if the number is within the valid range [1, N] and if it's a duplicate in the current column.
                if (number < 1 || number > N || seenNumbers.contains(number)) {
                    // If any condition fails, the column is invalid, so the Sudoku is invalid.
                    return false;
                }
                // Add the number to the set of seen numbers for the current column.
                seenNumbers.add(number);
            }
        }

        // If all rows and all columns pass the validation checks, the grid is a valid sub-Sudoku.
        return true;
    }

    /**
 * Optimized Solution:
 * Uses boolean arrays (or bit manipulation for very large N) to track seen numbers in rows and columns.
 * This avoids the overhead of HashSet and provides O(1) average time complexity for add/contains operations.
 *
 * Complexity Analysis (Optimized):
 * N = The number of rows/columns in the matrix.
 * Time: O(N^2) - We iterate through all N rows and N columns. For each element, operations are O(1).
 * Space: O(N) - We use two boolean arrays of size N+1 (or N) for rows and columns.
     */
    public static boolean validateSudokuOptimized(int[][] grid) {
        // Check for edge cases: if the grid is null, empty, or has empty rows.
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            // If any of these conditions are met, it's an invalid grid.
            return false;
        }

        // Determine the size of the grid (N), which is the number of rows.
        int N = grid.length;
        // Check if the grid is square (N x N).
        if (N != grid[0].length) {
            // If the number of rows is not equal to the number of columns, it's not a square grid.
            return false; // Not a square grid
        }

        // Step 1 & 2: Check each row and column simultaneously.
        // We need two boolean arrays for each row/column check.
        // `seenInRow[k]` will track numbers seen in the current row.
        // `seenInCol[k]` will track numbers seen in the current column.
        // The size is N+1 because numbers are 1 to N, so index 0 is unused.
        boolean[] seenInRow = new boolean[N + 1];
        boolean[] seenInCol = new boolean[N + 1];

        // Iterate through each row.
        for (int i = 0; i < N; i++) {
            // Reset the seen arrays for the current row and column checks.
            // For row `i`, we check `grid[i][j]`.
            // For column `i`, we check `grid[j][i]`.
            // This means we need to reset `seenInRow` for each `i` (row check)
            // and `seenInCol` for each `i` (column check).
            Arrays.fill(seenInRow, false); // Reset for current row check
            Arrays.fill(seenInCol, false); // Reset for current column check

            // Iterate through each element in the current row and column.
            for (int j = 0; j < N; j++) {
                // Check for row `i`:
                int rowNumber = grid[i][j];
                // Check if the number is within the valid range [1, N] and if it's a duplicate in the current row.
                if (rowNumber < 1 || rowNumber > N || seenInRow[rowNumber]) {
                    // If any condition fails, the row is invalid, so the Sudoku is invalid.
                    return false;
                }
                // Mark the number as seen in the current row.
                seenInRow[rowNumber] = true;

                // Check for column `i`:
                int colNumber = grid[j][i]; // Note: grid[j][i] to check column `i`
                // Check if the number is within the valid range [1, N] and if it's a duplicate in the current column.
                if (colNumber < 1 || colNumber > N || seenInCol[colNumber]) {
                    // If any condition fails, the column is invalid, so the Sudoku is invalid.
                    return false;
                }
                // Mark the number as seen in the current column.
                seenInCol[colNumber] = true;
            }
        }

        // If all rows and all columns pass the validation checks, the grid is a valid sub-Sudoku.
        return true;
    }
    // Brute Force approach
    public static boolean isValidBruteForce(int[][] grid) {
        int N = grid.length;

        // Check each row
        for (int i = 0; i < N; i++) {
            for (int num = 1; num <= N; num++) {
                boolean found = false;
                // Search for num in the row
                for (int j = 0; j < N; j++) {
                    if (grid[i][j] == num) {
                        found = true;
                        break;
                    }
                }
                if (!found) return false; // If any number missing, invalid
            }
        }

        // Check each column
        for (int j = 0; j < N; j++) {
            for (int num = 1; num <= N; num++) {
                boolean found = false;
                // Search for num in the column
                for (int i = 0; i < N; i++) {
                    if (grid[i][j] == num) {
                        found = true;
                        break;
                    }
                }
                if (!found) return false; // If any number missing, invalid
            }
        }

        return true;
    }

    // Optimized approach
    public static boolean isValidOptimized(int[][] grid) {
        int N = grid.length;

        // Check rows
        for (int i = 0; i < N; i++) {
            Set<Integer> seen = new HashSet<>();
            for (int j = 0; j < N; j++) {
                int num = grid[i][j];
                // Only allow 1..N numbers, and no duplicates
                if (num < 1 || num > N || !seen.add(num)) {
                    return false;
                }
            }
        }

        // Check columns
        for (int j = 0; j < N; j++) {
            Set<Integer> seen = new HashSet<>();
            for (int i = 0; i < N; i++) {
                int num = grid[i][j];
                if (num < 1 || num > N || !seen.add(num)) {
                    return false;
                }
            }
        }

        return true;
    }

    public static void main(String[] argv) {
        int[][] grid1 = {
                {2, 3, 1},
                {1, 2, 3},
                {3, 1, 2},
        };
        int[][] grid2 = {
                {1, 2, 3},
                {3, 2, 1},
                {3, 1, 2},
        };
        int[][] grid3 = {
                {2, 2, 3},
                {3, 1, 2},
                {2, 3, 1},
        };
        int[][] grid4 = {
                {1},
        };
        int[][] grid5 = {
                {-1, -2, -3},
                {-2, -3, -1},
                {-3, -1, -2},
        };
        int[][] grid6 = {
                {1, 3, 3},
                {3, 1, 2},
                {2, 3, 1},
        };
        int[][] grid7 = {
                {1, 2, 3, 4},
                {4, 3, 2, 1},
                {1, 3, 2, 4},
                {4, 2, 3, 1},
        };
        int[][] grid8 = {
                {0, 3},
                {3, 0},
        };
        int[][] grid9 = {
                {0, 1},
                {1, 0},
        };
        int[][] grid10 = {
                {1, 1, 6},
                {1, 6, 1},
                {6, 1, 1},
        };
        int[][] grid11 = {
                {1, 2, 3, 4},
                {2, 3, 1, 4},
                {3, 1, 2, 4},
                {4, 2, 3, 1},
        };
        int[][] grid12 = {
                {-1, -2, 12, 1},
                {12, -1, 1, -2},
                {-2, 1, -1, 12},
                {1, 12, -2, -1},
        };
        int[][] grid13 = {
                {2, 3, 3},
                {1, 2, 1},
                {3, 1, 2},
        };
        int[][] grid14 = {
                {1, 3},
                {3, 1},
        };
        int[][] grid15 = {
                {2, 3},
                {3, 2},
        };
        int[][] grid16 = {
                {1, 2},
                {2, 2},
        };
        int[][] grid17 = {
                {2, 3, 1},
                {1, 2, 3},
                {2, 3, 1},
        };
        int[][] grid18 = {
                {1, 2, 3, 4, 5, 6, 7, 8, 9, 10},
                {2, 3, 4, 5, 6, 7, 8, 9, 10, 1},
                {3, 4, 5, 6, 7, 8, 9, 10, 1, 2},
                {4, 5, 6, 7, 8, 9, 10, 1, 2, 3},
                {5, 6, 7, 8, 9, 10, 1, 2, 3, 4},
                {6, 7, 8, 9, 10, 1, 2, 3, 4, 5},
                {7, 8, 9, 10, 1, 2, 3, 4, 5, 6},
                {8, 9, 10, 1, 2, 3, 4, 5, 6, 7},
                {9, 10, 1, 2, 3, 4, 5, 6, 7, 8},
                {10, 1, 2, 3, 4, 5, 6, 7, 8, 9},
        };

        int columnSize = grid1.length;
        int rowSize = grid1[0].length;
        for(int i = 0; i < columnSize; i++){
//            System.out.println(Arrays.toString(grid1[i]));
            for(int j = 0; j < rowSize; j++){
                System.out.print(grid1[i][j] + " ");
            }
            System.out.println();
        }

//
//        System.out.println("--- Brute Force Approach ---");
        System.out.println("validateSudoku(grid1): " + validateSudoku(grid1));
//        System.out.println("validateSudoku(grid2): " + validateSudoku(grid2));
//        System.out.println("validateSudoku(grid3): " + validateSudoku(grid3));
//        System.out.println("validateSudoku(grid4): " + validateSudoku(grid4));
//        System.out.println("validateSudoku(grid5): " + validateSudoku(grid5));
//        System.out.println("validateSudoku(grid6): " + validateSudoku(grid6));
//        System.out.println("validateSudoku(grid7): " + validateSudoku(grid7)); // Expected: false (row 3: 1,3,2,4 has 1,4 twice)
//        System.out.println("validateSudoku(grid8): " + validateSudoku(grid8));
//        System.out.println("validateSudoku(grid9): " + validateSudoku(grid9));
//        System.out.println("validateSudoku(grid10): " + validateSudoku(grid10));
//        System.out.println("validateSudoku(grid11): " + validateSudoku(grid11)); // Expected: false (col 4: 4,4,4,1 has 4 thrice)
//        System.out.println("validateSudoku(grid12): " + validateSudoku(grid12));
//        System.out.println("validateSudoku(grid13): " + validateSudoku(grid13));
//        System.out.println("validateSudoku(grid14): " + validateSudoku(grid14));
//        System.out.println("validateSudoku(grid15): " + validateSudoku(grid15));
//        System.out.println("validateSudoku(grid16): " + validateSudoku(grid16));
//        System.out.println("validateSudoku(grid17): " + validateSudoku(grid17)); // Expected: false (row 3: 2,3,1 is duplicate of row 1)
//        System.out.println("validateSudoku(grid18): " + validateSudoku(grid18));
//
//        System.out.println("\n--- Optimized Solution ---");
//        System.out.println("validateSudokuOptimized(grid1): " + validateSudokuOptimized(grid1));
//        System.out.println("validateSudokuOptimized(grid2): " + validateSudokuOptimized(grid2));
//        System.out.println("validateSudokuOptimized(grid3): " + validateSudokuOptimized(grid3));
//        System.out.println("validateSudokuOptimized(grid4): " + validateSudokuOptimized(grid4));
//        System.out.println("validateSudokuOptimized(grid5): " + validateSudokuOptimized(grid5));
//        System.out.println("validateSudokuOptimized(grid6): " + validateSudokuOptimized(grid6));
//        System.out.println("validateSudokuOptimized(grid7): " + validateSudokuOptimized(grid7));
//        System.out.println("validateSudokuOptimized(grid8): " + validateSudokuOptimized(grid8));
//        System.out.println("validateSudokuOptimized(grid9): " + validateSudokuOptimized(grid9));
//        System.out.println("validateSudokuOptimized(grid10): " + validateSudokuOptimized(grid10));
//        System.out.println("validateSudokuOptimized(grid11): " + validateSudokuOptimized(grid11));
//        System.out.println("validateSudokuOptimized(grid12): " + validateSudokuOptimized(grid12));
//        System.out.println("validateSudokuOptimized(grid13): " + validateSudokuOptimized(grid13));
//        System.out.println("validateSudokuOptimized(grid14): " + validateSudokuOptimized(grid14));
//        System.out.println("validateSudokuOptimized(grid15): " + validateSudokuOptimized(grid15));
//        System.out.println("validateSudokuOptimized(grid16): " + validateSudokuOptimized(grid16));
//        System.out.println("validateSudokuOptimized(grid17): " + validateSudokuOptimized(grid17));
//        System.out.println("validateSudokuOptimized(grid18): " + validateSudokuOptimized(grid18));
    }
}
