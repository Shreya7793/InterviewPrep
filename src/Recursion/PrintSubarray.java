package Recursion;

import java.util.ArrayList;

public class PrintSubarray {

    static void generateSubArraysWithRecursion(int start, int end, int[] arr, ArrayList<Integer> subList, ArrayList<ArrayList<Integer>> result) {
        if (start == end) {
            return;
        }
        for (int i = start; i < end; i++) {
            subList.add(arr[i]);
            result.add(new ArrayList<>(subList));
        }
        subList=new ArrayList<>(); //clearing the sublist
        generateSubArraysWithRecursion(start + 1, end, arr, subList, result);
        //Note: We donot have a non pick scenario since we
    }

    static void generateSubsetsWithRecursion(int start, int end, int[] arr, ArrayList<Integer> subList, ArrayList<ArrayList<Integer>> result) {
        if (start == end) {
            result.add(new ArrayList<>(subList));
            return;
        }

        //pick
        subList.add(arr[start]);
        generateSubsetsWithRecursion(start + 1, end, arr, subList, result);
        //not pick
        subList.remove(subList.size() - 1);
        generateSubsetsWithRecursion(start + 1, end, arr, subList, result);
    }

    public static void main(String[] args) {
        //Note the difference in approach for subarray and subset
        int arr[] = {1, 2, 3};
        ArrayList<Integer> subList = new ArrayList<>();
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        generateSubsetsWithRecursion(0, arr.length, arr, subList, result);
        for (ArrayList<Integer> subResult : result) {
            System.out.println(subResult);
        }

        System.out.println("********************************************************");
        subList = new ArrayList<>();
        result = new ArrayList<>();
        generateSubArraysWithRecursion(0, arr.length, arr, subList, result);
        for (ArrayList<Integer> subResult : result) {
            System.out.println(subResult);
        }
    }
}
