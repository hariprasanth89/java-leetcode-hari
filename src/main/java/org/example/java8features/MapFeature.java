package org.example.java8features;

import java.util.Arrays;
import java.util.List;

public class MapFeature {

    public static void main(String[] args) {
        List<String> list = Arrays.asList("Hari", "aaa", "bbbb", "cccc");
        list.stream().map(String::toUpperCase).forEach(System.out::println);
        list.stream().map(String::length).forEach(System.out::println);
    }
}
