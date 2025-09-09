package org.example.leetcode;

import java.util.TreeMap;

public class MyCalender729 {


    TreeMap<Integer,Integer> bookings;

public  MyCalender729(){
    this.bookings = new TreeMap<>();
}
public  boolean startBookings(int start, int end){
    Integer highestStartThatIsLowerThenCurrentStart = bookings.floorKey(start);
    Integer lowestStartThatIsHighestThenCurrentStart = bookings.ceilingKey(end);
    if((highestStartThatIsLowerThenCurrentStart == null || bookings.get(highestStartThatIsLowerThenCurrentStart) <= start) && (lowestStartThatIsHighestThenCurrentStart == null || lowestStartThatIsHighestThenCurrentStart >= end)) {
            bookings.put(start,end);
            return true;
    }

    return false;
}

    public static void main(String[] args) {

    MyCalender729 myCalender729 = new MyCalender729();
    System.out.println(myCalender729.startBookings(10,20));
    System.out.println(myCalender729.startBookings(15,25));
    System.out.println(myCalender729.startBookings(20,30));
    System.out.println(myCalender729.startBookings(12,19));
    System.out.println(myCalender729.startBookings(50,60));
    System.out.println(myCalender729.startBookings(30,55));
    System.out.println(myCalender729.startBookings(10,20));




    }

}
