package com.ugurdonmez.data.trie;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * Trie implementation
 * 
 * ref: https://github.com/ugurdonmez/GoogleQuestions/tree/master/src/common/trie
 * 
 * Created by ugurdonmez on 30/07/16.
 */
public class Trie {

    private Node head;

    public Trie() {
        this.head = new Node(' ');
    }

    public void addWord(String str) {
        this.head.addWord(str, 0);
    }

    /**
     * Autocomplete
     * 
     * @param str
     * @return
     */
    public ArrayList<String> getWord(String str) {

        ArrayList<String> list = new ArrayList<String>();
        
        try {
            Node node = this.head;
            for (char c : str.toCharArray()) {
                node = node.getChildren().get(c);
            }

            Iterator<Character> it = node.getChildren().keySet().iterator();

            while (it.hasNext()) {
                list.addAll(node.getChildren().get(it.next()).getWords(str));
            }

            return list;
        } catch (NullPointerException ex) {
            return list;
        }
    }

    /**
     * return true when trie include given string
     * 
     * @param str
     * @return
     */
    public boolean isInclude(String str) {

        Node node = this.head;

        for (char c : str.toCharArray()) {
            node = node.getChildren().get(c);

            if (node == null) {
                return false;
            }
        }
        return node.isIsLeaf();
    }
}
