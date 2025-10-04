package org.example.javageneralquestion;


interface IA{
    default void method() {
        System.out.println("IA method");
    }
}

interface IB{
    default void method() {
        System.out.println("IB method");
            int a = 10;
        System.out.println(a);
    }
}


public class SameNameAnd implements IA, IB {


    @Override
    public void method() {
        IA.super.method();  // or IB.super.method();


        // Alternatively implement you own logic here
    }

    public static void main(String[] args) {
        SameNameAnd sameNameAnd = new SameNameAnd();
        sameNameAnd.method();
    }
}
