package org.example.javageneralquestion;

public class B  extends A{
    String name;
    public B(int value, String name){
        super(value);
        this.name = name;
        System.out.println("B's constructor called with name: " + name);

    }
    public static void main(String[] args) {
        B objB = new B(10, "Example");
        objB.display();
    }

    private void display() {
        System.out.println("Value from A: " + value + ", Name from B: " + name);

    }
}
