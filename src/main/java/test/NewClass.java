package test;

import com.ugurdonmez.data.trie.Trie;

/**
 *
 * @author ugurdonmez
 */
public class NewClass {
    
    public static void main(String [] args) {
        
        Trie trie = new Trie();
        
        trie.addWord("ugur");
        trie.addWord("donmez");
        
        System.out.println(trie.isInclude("ugur"));
        System.out.println(trie.isInclude("ugurd"));
        System.out.println(trie.isInclude("don"));
        System.out.println(trie.isInclude("donmez"));
        
        trie.addWord("don");
        System.out.println(trie.isInclude("don"));
        System.out.println(trie.isInclude("donm"));
        
    }
    
}
