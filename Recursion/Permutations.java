package Recursion;

import java.util.ArrayList;
/*
Print all Recursion.Permutations of a String/Array
TC: no. of permutations - n!
no of times looping form 0-n -> n times
Therefore TC=O(n!*n)
Sc: O(n) ; +O(n) => this doesn't consider the auxillary storage
Solution: https://www.youtube.com/watch?v=YK78FU5Ffjw&list=PLgUwDviBIf0rGlzIn_7rsaR2FQ5e6ZOL9&index=14
 */
public class Permutations {
    static void getAllPermuatations(int []arr, boolean[] freq, ArrayList<Integer> ds, ArrayList<ArrayList<Integer>> ansList){
        if(ds.size()==arr.length) { //ensures before adding to list that for permutation,the length of the ds should be equal to the length of the arr
            ansList.add(new ArrayList<>(ds));
            return;
        }
        for(int i=0;i<arr.length;i++) {
            if (!freq[i]) {
                ds.add(arr[i]);
                freq[i] = true; //Freq array keeps a check whether the current element was already picked, this ensures that elements are picked once
                getAllPermuatations(arr, freq, ds, ansList);
                ds.remove(ds.size() - 1); //remove whatever is picked
                freq[i]=false; //mark as false because it has been non-picked now
            }
        }
    }
    public static void main(String [] args){
        int [] nums={1,2,3};
        ArrayList<Integer> ds= new ArrayList<>();
        ArrayList<ArrayList<Integer>> ansList = new ArrayList<>();
        boolean []freq= new boolean[nums.length];
        getAllPermuatations(nums,freq,ds, ansList);
        System.out.println(ansList);
    }
}
