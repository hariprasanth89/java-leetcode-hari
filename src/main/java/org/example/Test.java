package org.example;

public class Test {

    Test(){
        System.out.println("Constructor called");
    }
    void method1(){
        System.out.println("Method called");
    }
    {
        System.out.println("Instance block called");
    }
    static {
        System.out.println("Static block called");
    }

    public static void main(String[] args) {
        System.out.println("main method starting Hello world ");
        Test test = new Test();
        test.method1();
    }
}
