package Recursion;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/*
* Combination sum: can pick an index twice
* https://www.youtube.com/watch?v=OyZFFqQtu98&list=PLgUwDviBIf0rGlzIn_7rsaR2FQ5e6ZOL9&index=11
* Combination sum2: Cannot pick an index twice
* https://www.youtube.com/watch?v=G1fRTGRxXU8&list=PLgUwDviBIf0rGlzIn_7rsaR2FQ5e6ZOL9&index=11
* */
public class CombinationSum {
    public static void combinationSum(int index, int target, int []arr, ArrayList<Integer>combinationList){
        if(index==arr.length){
            if(target==0){
                System.out.println(combinationList);
            }
            return;
        }
        //include the current element
        if(arr[index]<=target) {
            combinationList.add(arr[index]);
            combinationSum(index, target - arr[index], arr, combinationList);
            combinationList.remove(combinationList.size()-1);
        }
        //exclude the current element and move to the next
        combinationSum(index+1,target, arr,combinationList);
    }
    public static void combinationSum2(int index, int target, int []arr, ArrayList<Integer>combinationList,HashSet<List<Integer>> combinationListSet){
        if(index==arr.length){
            if(target==0)
                combinationListSet.add(new ArrayList<>(combinationList));
            return;
        }
        if(arr[index]<=target){
            combinationList.add(arr[index]);
            //move to next index
            combinationSum2(index+1, target-arr[index],arr,combinationList,combinationListSet);
            combinationList.remove(combinationList.size()-1);
        }
        combinationSum2(index+1,target,arr,combinationList,combinationListSet);
    }
    public static void main(String [] args){
        int [] arr={2,2,3,7};
        ArrayList<Integer> combinationList = new ArrayList<>();
        HashSet<List<Integer>> combinationListSet = new HashSet<>();
        combinationSum(0, 7,arr, combinationList);
        System.out.println("***************************************");
        combinationSum2(0, 7,arr, combinationList,combinationListSet);
        for(List<Integer> list: combinationListSet){
            System.out.println(list);
        }
    }
}
