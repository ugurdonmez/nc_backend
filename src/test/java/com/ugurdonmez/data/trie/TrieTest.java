package com.ugurdonmez.data.trie;

import java.util.ArrayList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author ugurdonmez
 */
public class TrieTest {
        
    public TrieTest() {
    }

    @Test
    public void test1() {
        Trie trie = new Trie();
        
        trie.addWord("abc");
        
        assertTrue("basic get word", trie.isInclude("abc"));
    }
    
    @Test
    public void test2() {
        Trie trie = new Trie();
        
        assertFalse("empty trie", trie.isInclude("abc"));
    }
    
    @Test
    public void test3() {
        Trie trie = new Trie();
        
        assertFalse("empty trie empty string", trie.isInclude(""));
    }
    
    @Test
    public void test4() {
        Trie trie = new Trie();
        
        trie.addWord("abcde");
        trie.addWord("abcd");
        trie.addWord("abc");
        trie.addWord("aaa");
        
        ArrayList<String> list = trie.getWord("ab");
        
        assertEquals(list.size(), 3);
    }
    
    @Test
    public void test5() {
        Trie trie = new Trie();
        
        trie.addWord("abcde");
        trie.addWord("abcd");
        trie.addWord("abc");
        trie.addWord("aaa");
        
        ArrayList<String> list = trie.getWord("xxx");
        
        assertEquals(list.size(), 0);
    }
}
