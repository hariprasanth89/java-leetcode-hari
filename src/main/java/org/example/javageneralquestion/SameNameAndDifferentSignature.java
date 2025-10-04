package org.example.javageneralquestion;


interface InA {

    void method();

}

interface InB {

    int method();   // complie time error if we try to implement

}

// this will not compile
//public class SameNameAndDifferentSignature  implements InA, InB {
//
//    // you cant implement both methods with same name and different return type
//
//}
