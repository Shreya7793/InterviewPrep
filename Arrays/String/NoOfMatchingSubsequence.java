package Arrays.String;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
Brute approach is s*words arr length*average length of each word in words
Optimised Approach:
1. Create a char,index list map
2. Check for every word if its a subsequence
3. Keep a track of the prevIndex
4. apply binary search on the greater index

Time Complexity:
building the map takes O(n) time, where n is the length of the string s. Each insertion is O(1)
The binary search takes O(logm) time, where m is the number of indices in the indexList for a particular character.
For each word we are calling isSubsequence -> Binary Search=> k is the average length of word then klogm
 */
public class NoOfMatchingSubsequence {
    static int numMatchingSubseq(String s, String[] words) {
        int count=0;
        //Create a Map of Char and index of String s
        Map<Character, List<Integer>> sCharIndexMap = new HashMap<>();
        for(int i=0;i<s.length();i++)
        {
            if(sCharIndexMap.containsKey(s.charAt(i)))
                sCharIndexMap.get(s.charAt(i)).add(i);
            else {
                List<Integer> indexList=new ArrayList<>();
                indexList.add(i);
                sCharIndexMap.put(s.charAt(i), indexList);
            }
        }
        //Iterate over the words array
        for(String word:words) {
            if (isSubsequence(word, sCharIndexMap))
                ++count;
        }

        return count;
    }
    //use map -> index list is the key
    static boolean isSubsequence(String word, Map<Character, List<Integer>> sCharIndexMap){
        int prevIndex=-1;
        for(int i=0;i<word.length();i++){
            char c=word.charAt(i);
            if(sCharIndexMap.containsKey(c)){
                List<Integer> indexList=sCharIndexMap.get(c);
                int nextIndex=greater(indexList,prevIndex);
                if(nextIndex==-1)
                    return false;
                prevIndex=nextIndex;
            }
            else
                return false;
        }
        return true;
    }
    //binary search to find next index
    static int greater(List<Integer> indexList, int index){
        int low=0, high=indexList.size()-1;
        int mid;
        if(indexList.size()==0 || indexList.get(indexList.size()-1)<=index) //Note this validation
            return -1;
        while(low<=high){
            mid=(low+high)/2;
            if(indexList.get(mid)>index){
                high=mid-1;
            }else{
                low=mid+1;
            }
        }
        return indexList.get(low);
    }
    static int numMatchingSubseqBrute(String s, String[] words) {
        int count=0;
        for(String word:words){
            if(isSubsequenceBrute(word,s))
                ++count;
        }
        return count;
    }
    static boolean isSubsequenceBrute(String word, String s){
        int wordPointer=0, sPointer=0;
        while(wordPointer<word.length() && sPointer<s.length()){
            if(word.charAt(wordPointer)==s.charAt(sPointer)){
                wordPointer++;
            }
            sPointer++;
        }
        return wordPointer==word.length();
    }
    static void main(String []args){
        String []s={"a","bb","acd","ace"};
        String word="abcde";
        /*List<Integer> indexList = new ArrayList<>();
        indexList.add(1);
        indexList.add(2);
        indexList.add(3);
        indexList.add(4);
        indexList.add(5);
        indexList.add(6);
        System.out.println(greater(indexList,4));*/
        System.out.println("Number of subsequence"+numMatchingSubseq(word,s));
    }
}
