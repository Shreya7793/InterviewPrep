package Recursion;

import java.util.ArrayList;
import java.util.List;
/*
*
* */
public class PrintAllSubsequence {
    static void arrPrint(int index, int[] arr, List<Integer> arrSubsequeceList){
        if(index==arr.length) {
            System.out.println(arrSubsequeceList);
            return;
        }
        //include
        arrSubsequeceList.add(arr[index]);
        arrPrint(index+1, arr, arrSubsequeceList);
        //exclude
        //removing the last element that was added to list
        arrSubsequeceList.remove(arrSubsequeceList.size()-1);
        arrPrint(index+1, arr, arrSubsequeceList);
    }
    static void strPrint(int index, String str, StringBuilder subsequenceBuilder){
        if(index==str.length()) {
            System.out.println(subsequenceBuilder);
            return;
        }
        //include
        subsequenceBuilder.append(str.charAt(index));
        strPrint(index+1, str, subsequenceBuilder);
        //exclude
        //removing the last character that was added to stringbuilder
        subsequenceBuilder.deleteCharAt(subsequenceBuilder.length()-1);
        strPrint(index+1, str, subsequenceBuilder);
    }
    public static void main(String [] args){
        String str="abc";
        int [] arr={1,2,3};
        ArrayList<Integer> arrSubsequeceList = new ArrayList<>();
        StringBuilder sb= new StringBuilder("");
        arrPrint(0,arr,arrSubsequeceList);
        strPrint(0,str,sb);
    }
}