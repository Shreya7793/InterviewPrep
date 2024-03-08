package Arrays.String;
/*
https://leetcode.com/problems/longest-common-prefix/submissions/1196802790/?envType=study-plan-v2&envId=top-interview-150
Write a function to find the longest common prefix string amongst an array of strings.

If there is no common prefix, return an empty string "".
Input: strs = ["flower","flow","flight"]
Output: "fl"

Hint:
Make first word as prefix.
Check if the word contains the prefix ; if no then keep reducing the length of the prefix until all matches

 */
public class LongestCommonPrefix {
    public static String longestCommonPrefix(String[] strs) {
        String prefix=strs[0]; //initial prefix is the first string
        if (strs == null || strs.length == 0)
            return "";
        for(int i=1;i<strs.length;i++){
            // Compare each string with the current prefix
            while(strs[i].indexOf(prefix)!=0){
                // Reduce the prefix by one character until it matches
                prefix=prefix.substring(0,prefix.length()-1);
                if(prefix.isEmpty())
                    return "";
            }
        }
        return prefix;
    }
    public static void main(String []args){
        String []strs={"flower","flow","flight"};
        System.out.println(longestCommonPrefix(strs));
    }
}

