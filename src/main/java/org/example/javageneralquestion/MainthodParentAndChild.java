package org.example.javageneralquestion;

class Parent1{
    public static void staticMethod(){
        System.out.println("parent method static method");
    }

    public void add(){
        System.out.println("parent add method");
    }
}

class Child1 extends Parent1{

    public static void staticMethod(){
        System.out.println("child method static method");
    }

    public void add(){
        System.out.println("child add method");
    }


}



public class MainthodParentAndChild {


    public static void main(String[] args) {
        Parent1 parent1 = new Child1();
        parent1.staticMethod();
        parent1.add();
    }
}
