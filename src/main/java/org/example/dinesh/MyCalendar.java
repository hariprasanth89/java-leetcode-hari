package org.example.dinesh;

import java.util.*;

public class MyCalendar {
    static boolean[] calendarTime = new boolean[100];
    public static boolean book(int start, int end) {
        // [[10, 20], [15, 25], [20, 30], [12, 19], [50, 60], [30, 55], [10, 20]]
        if (start+1 <= end && calendarTime[start] && calendarTime[start+1])
            return false;

        if (calendarTime[end - 1])
            return false;

        if (calendarTime[start - 1] && !calendarTime[start])
            return true;

        for (int i = start - 1; i<end; i++)
            calendarTime[i] = true;

        return true;
    }
    public static void main (String[] args) {

        //[true, false, true, false, true, false, false]
        int[][] timeEvents1 = {{10, 20}, {15, 25}, {20, 30}, {12, 19}, {50, 60}, {30, 55}, {10, 20}};

        List<Boolean> res = new ArrayList<>();
        for (int[] timeEvent : timeEvents1) {
            res.add(book(timeEvent[0], timeEvent[1]));
        }
        System.out.println(res);


        //[true, false, true, false, true, false]
        int[][] timeEvents2 = {{10, 20}, {15, 25}, {20, 30}, {12, 19}, {30, 55}, {50, 60}};
        res = new ArrayList<>();
        for (int[] timeEvent : timeEvents2) {
            res.add(book(timeEvent[0], timeEvent[1]));
        }
        System.out.println(res);
    }

}
