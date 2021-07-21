package com.facebook.screeing;

import java.util.LinkedList;
import java.util.List;

public class MovingAverages {

    static LinkedList<Integer> list = new LinkedList<>();
    static int CAPACITY = 0;
    static int runningSum = 0;


    public static List<Double> getMovingAvg(int[] arr, int n) throws Exception {


        int i=0, j=0;
        int len = arr.length;
        List<Double> res = new LinkedList<>();
        int currSum = 0;

        if (arr == null || n <= 0) {

            throw new Exception("Invalid input");

        }

        if (n >= len) {
            // return the entire of the array average

            for (int num : arr) {

                currSum += num;
            }

            res.add((double) (currSum/len));

            return res;

        }

        while (j-i < n) {

            currSum += arr[j++];
        }

        res.add((double) (currSum/n));


        while (j<len) {

            currSum = currSum + arr[j++];
            currSum = currSum - arr[i++];

            res.add((double) (currSum/n));
        }

        return res;

    }

    public static void put(int num) {


        if (list.size() < CAPACITY) {

            list.add(num);
            runningSum += num;
        }

        else {

            int polled = list.poll();
            list.add(num);
            runningSum -= polled;
            runningSum += num;

        }

    }

    public static double movingAverage() {
        return (double) runningSum/CAPACITY;
    }

    public static void main(String[] args) throws Exception {
        int[] arr = new int[]{1,2,3,4,5,6};
        System.out.println(getMovingAvg(arr, 5));


    }
}
