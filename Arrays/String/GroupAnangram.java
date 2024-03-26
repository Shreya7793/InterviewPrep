package Arrays.String;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GroupAnangram {
    public List<List<String>> groupAnagrams(String[] strs) {
        //List<List<String>> anaList=new ArrayList<>();
        Map<String,List<String>> freqMap= new HashMap<>();
        for(String s:strs){
            String key=calcFreq(s);
            if(freqMap.containsKey(key))
                freqMap.get(key).add(s);
            else{
                List<String> strList=new ArrayList<>();
                strList.add(s);
                freqMap.put(calcFreq(s), strList);
            }
        }
        return new ArrayList(freqMap.values());
    }


    private String calcFreq(String s){
        int []freq=new int[26];

        for(char c: s.toCharArray()){
            freq[c-'a']++;
        }
        StringBuilder sb =new StringBuilder("");
        char c='a';
        for(int i:freq){
            sb.append(c);
            sb.append(i);
            c++;
        }
        return sb.toString();
    }
}
