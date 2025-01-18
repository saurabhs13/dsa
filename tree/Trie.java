

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
    }
}