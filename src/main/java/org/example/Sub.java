package org.example;

public class Sub extends Parent {

    public  int multiply(int a, int b) {
        return a * b;
    }

    public static int divide(int a, int b) {
        if (b == 0) {
            throw new ArithmeticException("Division by zero is not allowed.");
        }
        return a / b;
    }

    public static void main(String[] args) {
        int a = 10;

        Parent parent = new Parent();
        Parent sub = new Sub();
        Sub sub1 = new Sub();


        sub.add(a, 5); // Calls Parent's add method
        parent.add(2,2); // Calls Parent's add method
    }

}
