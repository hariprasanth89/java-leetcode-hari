package org.example.javageneralquestion;

import lombok.SneakyThrows;

import java.io.FileReader;

public class TryWithResourcesExamples {


    @SneakyThrows
    public static void main(String[] args) {
        try (FileReader reader = new FileReader("/Users/hariprasanthvenkataramachetty/Downloads/Archive/JavaLeetCode/src/main/resources/testing.txt")) {
            System.out.println(STR."Reading file contents\{reader.read()}");
        }




    }
}
