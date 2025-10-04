package org.example.javageneralquestion;

public class Test {

    Test(){ // constructor called

        System.out.println("Constructor called");
    }


    void method1(){  // method called

        System.out.println("Method called");

    }



    { // instance block called
        System.out.println("Instance block called");
    }


    static {   // static block 1st called
        System.out.println("Static block called");
    }

    public static void main(String[] args) {
        System.out.println("main method starting Hello world ");   // main method called


        Test test = new Test();
        test.method1();
    }
}
