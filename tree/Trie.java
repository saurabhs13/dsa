
import java.util.ArrayList;
import java.util.List;

/**
 * Program to implement Trie data structure.
 */
public class Trie{

    private static class TrieNode{

        TrieNode[] children;
        boolean endOfWord;

        public TrieNode(){
            children = new TrieNode[26];
            endOfWord = false;
        }
        
    }
    TrieNode root;
    public Trie(){
        root = new TrieNode();
    }

    public void insert(String s){
        char[] sArr = s.toCharArray();
        TrieNode current = root;
        for(int i=0;i<sArr.length;i++){
            int childIndex = sArr[i] - 'a';
            if(current.children[childIndex] == null){
                current.children[childIndex] = new TrieNode();
            }
            current = current.children[childIndex];
        }
        current.endOfWord = true;
    }
    public boolean search(String s){
        char[] sArr = s.toCharArray();
        TrieNode current = root;
        for(int i=0;i<sArr.length;i++){
            int childIndex = sArr[i] - 'a';
            if(current.children[childIndex] == null){
                return false;
            }
            current = current.children[childIndex];
        }
        return current.endOfWord;
    }
    public boolean delete(String s){

       return delete(root,s,0);
    }
    private boolean delete(TrieNode node,String s,int index){

        if(index==s.length()){
            if(!node.endOfWord){
                return false; //word does not exist.
            }
            node.endOfWord = false;
            return !nodeHasChildren(node);

        }

        int childIndex = s.charAt(index) - 'a';
        TrieNode child = node.children[childIndex];

        if(null == child){
            return false; //word not present in Trie
        }

        boolean deleteChild = delete(child,s,index+1); 
        
        if(deleteChild){
               
            node.children[childIndex] = null;
        }
        return !nodeHasChildren(node) && !node.endOfWord;
        
    }
    private static boolean nodeHasChildren(TrieNode node){
        for(TrieNode child:node.children){
            if(child!=null){
                return true;
            }
        }
        return false;
    }
    public long countWords(){
        return countWords(root);
    }
    private long countWords(TrieNode node){
        long result = 0;
        if(node.endOfWord){
            result++;
        }
        for(int i=0;i<26;i++){
            if(node.children[i]!=null){
               result+= countWords(node.children[i]);
            }
        }
        return result;
    }
    public List<String> getAllWords(){

        List<String> words = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        getAllWords(root,words,sb);
        return words;
    }
    private void getAllWords(TrieNode node,List<String> words,StringBuilder sb){
        if(node.endOfWord){
            words.add(sb.toString());
        }

        for(int i=0;i<26;i++){
            if(node.children[i]!=null){
                sb.append((char)(i+'a'));
                getAllWords(node.children[i],words,sb);
                sb.deleteCharAt(sb.length()-1);
            }
        }
    }
    public static void main(String[] args) {
        Trie trie = new Trie();
        trie.insert("apple");
        trie.insert("there");
        trie.insert("their");
        trie.insert("the");
        System.out.println("Sam exists: "+trie.search("sam"));
        System.out.println("Apple exists: "+trie.search("apple"));
        System.out.println("the exists: "+trie.search("the"));
        trie.delete("the");
        System.out.println("the exists: "+trie.search("the"));
        System.out.println("their exists: "+trie.search("their"));
        System.out.println("there exists: "+trie.search("there"));
        System.out.println("Word Count: "+trie.countWords());
        System.out.println("Word Count: "+trie.getAllWords().size());
        System.out.println("1st Word: "+trie.getAllWords().getFirst());
    }
}