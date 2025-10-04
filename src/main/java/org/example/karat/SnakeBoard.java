package org.example.karat;

import java.util.ArrayList;
import java.util.List;

/*
We have a two-dimensional board game involving snakes.  The board has two types of squares on it: +'s represent impassable squares where snakes cannot go, and 0's represent squares through which snakes can move.  Snakes can only enter on the edges of the board, and each snake can move in only one direction.  We'd like to find the places where a snake can pass through the entire board, moving in a straight line.

Here is an example board:

    col-->        0  1  2  3  4  5  6
               +----------------------
    row      0 |  +  +  +  0  +  0  0
     |       1 |  0  0  +  0  0  0  0
     |       2 |  0  0  0  0  +  0  0
     v       3 |  +  +  +  0  0  +  0
             4 |  0  0  0  0  0  0  0

Write a function that takes a rectangular board with only +'s and 0's, and returns two collections:

* one containing all of the row numbers whose row is completely passable by snakes, and
* the other containing all of the column numbers where the column is completely passable by snakes.

Sample Inputs:

board1 = [['+', '+', '+', '0', '+', '0', '0'],
          ['0', '0', '+', '0', '0', '0', '0'],
          ['0', '0', '0', '0', '+', '0', '0'],
          ['+', '+', '+', '0', '0', '+', '0'],
          ['0', '0', '0', '0', '0', '0', '0']]

board2 = [['+', '+', '+', '0', '+', '0', '0'],
          ['0', '0', '0', '0', '0', '+', '0'],
          ['0', '0', '+', '0', '0', '0', '0'],
          ['0', '0', '0', '0', '+', '0', '0'],
          ['+', '+', '+', '0', '0', '0', '+']]

board3 = [['+', '+', '+', '0', '+', '0', '0'],
          ['0', '0', '0', '0', '0', '0', '0'],
          ['0', '0', '+', '+', '0', '+', '0'],
          ['0', '0', '0', '0', '+', '0', '0'],
          ['+', '+', '+', '0', '0', '0', '+']]

board4 = [['+']]

board5 = [['0']]

board6 = [['0', '0'],
          ['0', '0'],
          ['0', '0'],
          ['0', '0']]

All test cases:

findPassableLanes(board1) => Rows: [4], Columns: [3, 6]
findPassableLanes(board2) => Rows: [], Columns: [3]
findPassableLanes(board3) => Rows: [1], Columns: []
findPassableLanes(board4) => Rows: [], Columns: []
findPassableLanes(board5) => Rows: [0], Columns: [0]
findPassableLanes(board6) => Rows: [0, 1, 2, 3], Columns: [0, 1]

Complexity Analysis:

r: number of rows in the board
c: number of columns in the board
*/

/*
    col-->        0  1  2  3  4  5  6
               +----------------------
    row      0 |  +  +  +  0  +  0  0
     |       1 |  0  0  +  0  0  0  0
     |       2 |  0  0  0  0  +  0  0
     v       3 |  +  +  +  0  0  +  0
             4 |  0  0  0  0  0  0  0
*/

public class SnakeBoard {

    public static class Result {
        List<Integer> rows;
        List<Integer> cols;

        Result(List<Integer> rows, List<Integer> cols) {
            this.rows = rows;
            this.cols = cols;
        }

        @Override
        public String toString() {
            return "Rows: " + rows + ", Columns: " + cols;
        }
    }

    public static Result findPassableLanes(char[][] board) {
        int r = board.length;
        int c = board[0].length;

        List<Integer> passableRows = new ArrayList<>();
        List<Integer> passableCols = new ArrayList<>();

        // Check rows
        for (int i = 0; i < r; i++) {
            boolean allZero = true;
            for (int j = 0; j < c; j++) {
                if (board[i][j] != '0') {
                    allZero = false;
                    break;
                }
            }
            if (allZero) {
                passableRows.add(i);
            }
        }

        // Check columns
        for (int j = 0; j < c; j++) {
            boolean allZero = true;
            for (int i = 0; i < r; i++) {
                if (board[i][j] != '0') {
                    allZero = false;
                    break;
                }
            }
            if (allZero) {
                passableCols.add(j);
            }
        }

        return new Result(passableRows, passableCols);
    }

    // ---------- TESTING ----------
    public static void main(String[] args) {
        char[][] board1 = {
                {'+', '+', '+', '0', '+', '0', '0'},
                {'0', '0', '+', '0', '0', '0', '0'},
                {'0', '0', '0', '0', '+', '0', '0'},
                {'+', '+', '+', '0', '0', '+', '0'},
                {'0', '0', '0', '0', '0', '0', '0'}
        };

        char[][] board2 = {
                {'+', '+', '+', '0', '+', '0', '0'},
                {'0', '0', '0', '0', '0', '+', '0'},
                {'0', '0', '+', '0', '0', '0', '0'},
                {'0', '0', '0', '0', '+', '0', '0'},
                {'+', '+', '+', '0', '0', '0', '+'}
        };

        char[][] board3 = {
                {'+', '+', '+', '0', '+', '0', '0'},
                {'0', '0', '0', '0', '0', '0', '0'},
                {'0', '0', '+', '+', '0', '+', '0'},
                {'0', '0', '0', '0', '+', '0', '0'},
                {'+', '+', '+', '0', '0', '0', '+'}
        };

        char[][] board4 = {{'+'}};
        char[][] board5 = {{'0'}};
        char[][] board6 = {
                {'0', '0'},
                {'0', '0'},
                {'0', '0'},
                {'0', '0'}
        };

        System.out.println(findPassableLanes(board1)); // Rows: [4], Columns: [3, 6]
        System.out.println(findPassableLanes(board2)); // Rows: [], Columns: [3]
        System.out.println(findPassableLanes(board3)); // Rows: [1], Columns: []
        System.out.println(findPassableLanes(board4)); // Rows: [], Columns: []
        System.out.println(findPassableLanes(board5)); // Rows: [0], Columns: [0]
        System.out.println(findPassableLanes(board6)); // Rows: [0, 1, 2, 3], Columns: [0, 1]
    }
}
