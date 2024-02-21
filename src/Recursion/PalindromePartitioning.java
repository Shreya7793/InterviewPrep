package Recursion;

import java.util.ArrayList;

public class PalindromePartitioning {
    static  void generatePalindromicPartitions(int index, String str, ArrayList<String> ds, ArrayList<ArrayList<String>> ansList){
        if(index==str.length()){
            ansList.add(new ArrayList<>(ds));
            return;
        }
        for(int i=index;i<str.length();i++){
            if(isPalindrome(str,index,i)) {
                ds.add(str.substring(index,i+1));
                generatePalindromicPartitions(i+1,str, ds, ansList);
                ds.remove(ds.size() - 1);
            }
        }
    }
    static boolean isPalindrome(String str, int start, int end){
       // int i=0, j=str.length()-1;
        while(start<=end) {
           if(str.charAt(start++) != str.charAt(end--))
               return false;
        }
        return true;
    }
    public static void main(String []args){
        ArrayList<String> ds = new ArrayList<>();
        ArrayList<ArrayList<String>> ansList = new ArrayList<>();
        String str="aabb";
        generatePalindromicPartitions(0, str,ds,ansList);
        System.out.println(ansList);
    }
}
