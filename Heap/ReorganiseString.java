package Heap;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/*
Leetcode link:https://leetcode.com/problems/reorganize-string/
Video Solution: https://www.youtube.com/watch?v=zaM_GLLvysw
Hint: you want to have the most frequently occuring character first
Steps
1. Build the char, frequency map
2. Build the max heap based on frequency
3. Take the most frequent and the next ferq char greedily and reduce the count from hashmap
4. check if the head is not empty i.e one char left
5. if the char appears once we can append else return empty string since we cannot rearrange it
 */
public class ReorganiseString {
        public static String reorganizeString(String s) {
            Map<Character,Integer> charFreqMap=new HashMap<>();
            char[] strChars=s.toCharArray();
            //stor the count of character in map
            for(int i=0; i<strChars.length;i++){
                charFreqMap.put(s.charAt(i),charFreqMap.getOrDefault(s.charAt(i),0)+1);
            }
            //create the max heap
            //charCountMap.get(a)-charCountMap.get(b) comparator to sort in decreasing order of the frequency
            //Building a max heap take O(N) time
            PriorityQueue<Character> maxHeap=new PriorityQueue<>((a,b)->charFreqMap.get(b)-charFreqMap.get(a));

            //add all the characters in max heap
            maxHeap.addAll(charFreqMap.keySet());

            StringBuilder result=new StringBuilder();
            while(maxHeap.size()>1){
                //taking current and next so that they are not adjacent
                char current=maxHeap.remove();
                char next=maxHeap.remove();

                //adding to stringbuilder
                result.append(current);
                result.append(next);

                //Decrement the count from the map
                charFreqMap.put(current,charFreqMap.get(current)-1);
                charFreqMap.put(next,charFreqMap.get(next)-1);

                //put the popped chars i.e current and next back to heap
                if(charFreqMap.get(current)>0)
                    maxHeap.add(current);

                if (charFreqMap.get(next)>0)
                    maxHeap.add(next);
            }

            //If max heap size=1 is left
            if(!maxHeap.isEmpty()){
                char last=maxHeap.remove();
                if(charFreqMap.get(last)>1)
                    return "";
                else
                    result.append(last);
            }

         return result.toString();
        }
        public static void main(String []args){
            String str="aaacb";
            System.out.println(reorganizeString(str));

        }
}
