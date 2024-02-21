package Recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
/*
 * Subset sum: sum of all subsets in sorted order O(2^n) + O(2^NLog2^N)
 * https://www.youtube.com/watch?v=rYkfBRtMJr8&list=PLgUwDviBIf0rGlzIn_7rsaR2FQ5e6ZOL9&index=13
 * Subset sum:Return all possible subsets
 * Brute Force: To generate all subsets and put the subset into set and sum
 * O(2^n)+2^nLog2^n -> to insert to set
 * Optimal Approach- TC: O(2^n * n) -> n for copying the subset that we are generating
 * SC: O(2^n) * O(k)
 * https://www.youtube.com/watch?v=RIn3gOkbhQE&list=PLgUwDviBIf0rGlzIn_7rsaR2FQ5e6ZOL9&index=14
 * LeetCode: https://leetcode.com/problems/subsets-ii/description/
 * */
public class SubsetSum {
    static void subsetSum1(int index, int sum, int []arr, ArrayList<Integer> sumList, ArrayList<Integer> list){
        if(index==arr.length) {
            sumList.add(sum);
            return;
        }
        //Pick
        list.add(arr[index]);
        subsetSum1(index+1,sum+list.get(list.size()-1),arr, sumList, list);
        list.remove(list.size()-1);
        //Not Pick
        subsetSum1(index+1,sum,arr,sumList,list);
    }
    /*
     In Java, when you add an object to a list, you're actually adding a reference to that object.
     This means that if you modify the object later on, those modifications will be reflected in the
     list, since the list holds a reference to the same object.
    In the context of generating subsets, you're manipulating the list object within the subsets
    function. If you simply add list to ansList, you're adding a reference to the same list object
    every time. As a result, when you manipulate list (like adding or removing elements),
    those changes will be reflected in all the subsets already added to ansList.
    To prevent this unintended behavior and ensure that each subset in ansList remains independent,
    you need to add a copy of the list object. By using new ArrayList<>(list), you create a new ArrayList object with the same elements as list but independent of it. This way, modifications to list within the subsets function won't affect the subsets already added to ansList.

     */
       static void subsets(int index, int []arr, ArrayList<Integer>list, ArrayList<ArrayList<Integer>> ansList){
//        if(index==arr.length)
//        {
//            ansList.add(list);
//            return;
//        }
        ansList.add(new ArrayList<>(list)); //Add a copy of the current list - Reason mentioned above
        for(int i=index;i<arr.length;i++) {
            if(i!=index && arr[i]==arr[i-1])
                continue;
            list.add(arr[i]);
            subsets(i + 1, arr, list, ansList);
            list.remove(list.size() - 1);
        }
    }
    public static void main(String [] args){
        int []arr={3,1,2};
        ArrayList<Integer> list= new ArrayList<>();
        ArrayList<Integer> sumList= new ArrayList<>();
        //subsetSum1(0,0,arr,sumList, list);
        Collections.sort(sumList); //sumList is passed by reference
        System.out.println(sumList);
        System.out.println("************************************");
        ArrayList<ArrayList<Integer>> ansList = new ArrayList<>();
        arr= new int[]{1, 2, 2, 2, 3, 3};
        Arrays.sort(arr); //sort the array to group duplicates -> Remember this step
        subsets(0,arr,new ArrayList<>(), ansList);
        System.out.println(ansList);
    }
}
