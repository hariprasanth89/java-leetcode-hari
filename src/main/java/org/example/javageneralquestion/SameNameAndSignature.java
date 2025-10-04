package org.example.javageneralquestion;
interface InterfaceA{
    void method();
}
interface InterfaceB{
    void method();
}


public class SameNameAndSignature implements InterfaceA, InterfaceB{
    @Override
    public void method() {

    }
}
