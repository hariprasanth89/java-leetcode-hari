package org.example.karat;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * A utility class to hold the results: lists of completely passable row and column indices.
 */
record PassableLanes(List<Integer> passableRows, List<Integer> passableCols) {
/*
class PassableLanes {
    public final List<Integer> passableRows;
    public final List<Integer> passableCols;

    public PassableLanes(List<Integer> passableRows, List<Integer> passableCols) {
        this.passableRows = passableRows;
        this.passableCols = passableCols;
    }

    @Override
    public String toString() {
        return STR."Rows: \{passableRows}, Columns: \{passableCols}";
    }
}
 */
    @Override
    public String toString() {
        return STR."Rows: \{passableRows}, Columns: \{passableCols}";
    }
}

/**
 * Solution class containing the main function to find passable lanes.
 */
public class PassableLanesFinder {

    /**
     * Finds all row and column indices that are completely passable ('0') by a snake.
     * The complexity is O(R * C), where R is rows and C is columns, as every cell is checked twice.
     *
     * @param board The 2D array representing the game board. '+' is impassable, '0' is passable.
     * @return A PassableLanes object containing two lists of indices.
     */
    public static PassableLanes findPassableLanes(char[][] board) {
        // Handle edge case of an empty board or a board with no columns
        if (board == null || board.length == 0 || board[0].length == 0) {
            return new PassableLanes(new ArrayList<>(), new ArrayList<>());
        }

        final int ROWs = board.length;
        final int COLs = board[0].length;
        List<Integer> passableRows = new ArrayList<>();
        List<Integer> passableCols = new ArrayList<>();

        // 1. Check Rows
        // Iterate through each row (r) and check all columns (c) for any impassable square ('+').
        for (int row = 0; row < ROWs; row++) {
            boolean isPassable = true;
            for (int col = 0; col < COLs; col++) {
                if (board[row][col] == '+') {
                    isPassable = false;
                    break; // Impassable square found, move to the next row
                }
            }
            if (isPassable) {
                passableRows.add(row);
            }
        }

        // 2. Check Columns
        // Iterate through each column (c) and check all rows (r) for any impassable square ('+').
        for (int col = 0; col < COLs; col++) {
            boolean isPassable = true;
            for (int row = 0; row < ROWs; row++) {
                if (board[row][col] == '+') {
                    isPassable = false;
                    break; // Impassable square found, move to the next column
                }
            }
            if (isPassable) {
                passableCols.add(col);
            }
        }

        return new PassableLanes(passableRows, passableCols);
    }

    /**
     * Helper to print the test case and result.
     */
    private static void runTest(String name, char[][] board) {
        System.out.println(STR."--- \{name} ---");
        System.out.println("Input Board:");
        for (char[] row : board) {
            System.out.println(Arrays.toString(row));
        }

        PassableLanes result = findPassableLanes(board);
        System.out.println("Result: " + result);
        System.out.println();
    }

    public static void main(String[] args) {
        // Sample Input from the problem description (converted to char[][])
        char[][] board1 = new char[][]{
                {'+', '+', '+', '0', '+', '0', '0'},
                {'0', '0', '+', '0', '0', '0', '0'},
                {'0', '0', '0', '0', '+', '0', '0'},
                {'+', '+', '+', '0', '0', '+', '0'},
                {'0', '0', '0', '0', '0', '0', '0'}
        }; // Expected: Rows: [4], Columns: [3, 6]
        runTest("board1", board1);

        char[][] board2 = new char[][]{
                {'+', '+', '+', '0', '+', '0', '0'},
                {'0', '0', '0', '0', '0', '+', '0'},
                {'0', '0', '+', '0', '0', '0', '0'},
                {'0', '0', '0', '0', '+', '0', '0'},
                {'+', '+', '+', '0', '0', '0', '+'}
        }; // Expected: Rows: [], Columns: [3]
        runTest("board2", board2);

        char[][] board3 = new char[][]{
                {'+', '+', '+', '0', '+', '0', '0'},
                {'0', '0', '0', '0', '0', '0', '0'},
                {'0', '0', '+', '+', '0', '+', '0'},
                {'0', '0', '0', '0', '+', '0', '0'},
                {'+', '+', '+', '0', '0', '0', '+'}
        }; // Expected: Rows: [1], Columns: []
        runTest("board3", board3);

        char[][] board4 = new char[][]{
                {'+'}
        }; // Expected: Rows: [], Columns: []
        runTest("board4", board4);

        char[][] board5 = new char[][]{
                {'0'}
        }; // Expected: Rows: [0], Columns: [0]
        runTest("board5", board5);

        char[][] board6 = new char[][]{
                {'0', '0'},
                {'0', '0'},
                {'0', '0'},
                {'0', '0'}
        }; // Expected: Rows: [0, 1, 2, 3], Columns: [0, 1]
        runTest("board6", board6);

        // Additional edge case: empty board
        char[][] boardEmpty = new char[][]{};
        runTest("boardEmpty", boardEmpty);

        // Additional edge case: board with zero columns
        char[][] boardZeroCols = new char[][]{{}};
        runTest("boardZeroCols", boardZeroCols);
    }
}

