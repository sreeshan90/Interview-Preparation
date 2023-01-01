package com.random.problem;

import java.util.Arrays;
import java.util.List;

public class EmpiricalTestStreams {
    public static void main(String[] args) {


        List<Integer> listOfNumbers = Arrays.asList(1, 2, 3, 4);
        List<Integer> listOfNumbers2 = Arrays.asList(5, 6, 7, 8);

        long startTime = System.nanoTime();
/*
        for (int i : listOfNumbers) {
            for (int j : listOfNumbers2) {
                int res = i*j;
            }
        }*/

        listOfNumbers.parallelStream().forEach(i -> {
            listOfNumbers2.parallelStream().forEach(j -> {
                int res = j * i;
            });
        });
        long estimatedTime = System.nanoTime() - startTime;

        System.out.println(estimatedTime);
    }
}
