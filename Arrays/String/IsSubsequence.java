package Arrays.String;

import java.util.Arrays;

public class IsSubsequence {
    public static boolean isSubsequence(String s, String t) {
        int sPointer=0, tPointer=0;
        int []visited=new int[s.length()];
        Arrays.fill(visited,0);
        while(tPointer<=t.length()-1 && sPointer<=s.length()-1){
                if(s.charAt(sPointer)==t.charAt(tPointer)) {
                    visited[sPointer] = 1;
                    sPointer++;
                }
                tPointer++;
            }
        for(sPointer=0;sPointer<visited.length;sPointer++)
            if(visited[sPointer]==0)
                return false;
        //Note if you don't want to use visited array then check sPointer==s.length; in that case complexity will be O(s+t)
        return true;
    }
    static void main(String []args){
        String s="abx";
        String t="ahbgdc";
        System.out.println("Is subsequence?"+isSubsequence(s,t));
    }
}
