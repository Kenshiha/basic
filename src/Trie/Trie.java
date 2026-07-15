package Trie;

public class Trie {
    TrieNode root;

    class TrieNode{
        TrieNode[] children;
        boolean isEndOfWord;

        TrieNode(){
            children = new TrieNode[26];
            isEndOfWord = false;
        }
    }

    Trie(){

        root = new TrieNode();

    }

    void insert(String word){

        TrieNode current = root;

        for(int i = 0;i < word.length(); i++){
            int index = word.charAt(i) - 'a';

            if(current.children[index] == null){
                current.children[index] = new TrieNode();
            }

            current = current.children[index];
        }
        current.isEndOfWord = true;
    }

    boolean search(String word){
        TrieNode current = root;

        for(int i = 0; i < word.length(); i++){
            int index = word.charAt(i) - 'a';

            if(current.children[index] == null){
                return false;
            }
            current = current.children[index];
        }

        return current.isEndOfWord;
    }

    boolean startWith(String word){
        TrieNode current = root;

        for(int i =0; i < word.length(); i++){
            int index = word.charAt(i) - 'a';

            if(current.children[index] == null){
                return false;
            }
            current = current.children[index];
        }
        return true;
    }

    void delete(String word){
        delete(root,word,0);
    }

    boolean delete(TrieNode current, String word, int depth){
        if(current == null){
            return false;
        }

        if(depth == word.length()){
            if(!current.isEndOfWord){
                return false;
            }
            current.isEndOfWord = false;

            return isEmpty(current);
        }

        int index = word.charAt(depth) - 'a';

        if(delete(current.children[index], word, depth + 1)){
            current.children[index] = null;

            return !current.isEndOfWord && isEmpty(current);
        }
        return false;
    }

    boolean isEmpty(TrieNode node){
        for(TrieNode child : node.children){
            if(child != null){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args){
        Trie t = new Trie();

        t.insert("cat");
        t.insert("car");
        t.insert("ca");
        t.insert("corazon");
        t.delete("ca");

        System.out.println(t.search("cat"));
        System.out.println(t.startWith("c"));
    }
}
