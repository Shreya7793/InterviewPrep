package Trie;

//Ref: https://takeuforward.org/data-structure/implement-trie-1/
public class TrieOperations {
    static void insert(String word, TrieNode root){
        TrieNode node=root;
        for(int i=0;i<word.length();i++){
            if(!node.containsKey(word.charAt(i))){
                node.put(word.charAt(i),new TrieNode());
            }
            //moves the reference
            node=node.get(word.charAt(i));
        }
        node.setEnd();
    }

    static boolean search(String word,TrieNode root){
        TrieNode node=root;
        for(int i=0;i<word.length();i++){
            if(!node.containsKey(word.charAt(i))){
                return false;
            }
            node=node.get(word.charAt(i));
        }
        if(node.isEnd()) {
            return true;
        }
        return false;
    }
    //Returns if there is any word in the trie that starts with the given prefix
    static boolean startsWith(String prefix,TrieNode root) {
        TrieNode node = root;
        for (int i = 0; i < prefix.length(); i++) {
            if (!node.containsKey(prefix.charAt(i)))
                return false;
            node = node.get(prefix.charAt(i));
        }
        return true;
    }
    public static void main(String args[]){
        String values[] = {"hello", "help", "help", "hel", "hel"};
        TrieNode root=new TrieNode();
        for(String value:values)
            insert(value,root);

        System.out.println(search("hell0",root));
    }
}
