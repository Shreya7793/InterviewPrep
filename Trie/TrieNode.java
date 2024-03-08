package Trie;

public class TrieNode {
    //This creates an array of TrieNode references of size 26
    //the size 26 represents 26 alphabetical letters
    TrieNode[] links = new TrieNode[26];
    boolean flag=false;

    boolean containsKey(char ch){
        return (links[ch-'a']!=null);
    }
    TrieNode get(char ch){
        return links[ch-'a'];
    }
    void put(char ch, TrieNode node){
        links[ch-'a']=node;
        //eg: ch=b
        //'b'-'a'=1
        //so trieNode associated with character 'b' will be stored at links[1]
    }
    void setEnd(){
        flag=true;
    }
    boolean isEnd(){
        return flag;
    }
}
