package org.example;

public class DifferentLogic {

    public static void main(String[] args) {

        Integer a = new Integer(127);
        Integer b = new Integer(127);
        if (a == b) {
            System.out.println("true");
        } else if (a.equals(b)){
            System.out.println(".equals true");
        } else {
            System.out.println("false");
        }
        Integer c = 127;
        Integer d = 127;
        if (c == d) {
            System.out.println("true == ");
        }
        else {
            System.out.println("false");
        }
        Integer a1 = new Integer(a);
        Integer b1 = new Integer(a1);
        if (a1 == b1) {
            System.out.println("true a1andb1" );
        } else {
            System.out.println("false /");
        }
        if (a1.equals(b1)){
            System.out.println(".equals true...");
        }

        Integer a2 = 127;
        Integer b2 = a2;
        if (a2 == b2) {
            System.out.println("true a2andb2");
        } else {
            System.out.println("false");
        }







    }
}
