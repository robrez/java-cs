package com.jcs.util;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author rob
 */
public class TrieNode {

    private Map<Integer, TrieNode> children;
    private boolean word = false;

    public boolean isWord() {
        return word;
    }

    public TrieNode add(String s) {
        char[] chars = s.toCharArray();
        TrieNode n = this;
        for (int i = 0; i < chars.length; i++) {
            n = n.add(chars[i], i == chars.length - 1);
        }
        return n;
    }

    private TrieNode add(char c, boolean word) {
        int i = Character.getNumericValue(c);
        TrieNode child;
        if (children != null && children.containsKey(i)) {
            child = children.get(i);
        } else {
            if (children == null) {
                children = new HashMap<Integer, TrieNode>();
            }
            child = new TrieNode();
            children.put(i, child);
        }
        if (word) {
            child.word = true;
        }
        return child;
    }

    public TrieNode get(String s) {
        if (children == null || children.isEmpty()) {
            return null;
        }
        char[] chars = s.toCharArray();
        TrieNode n = this;
        for (int i = 0; i < chars.length; i++) {
            n = n.getChild(Character.getNumericValue(chars[i]));
            if (n == null) {
                return null;
            }
        }
        return n == this ? null : n;
    }

    public boolean contains(String s) {
        TrieNode n = get(s);
        return n != null && n.isWord();
    }

    public boolean isPrefix(String s) {
        TrieNode n = get(s);
        return n != null;
    }

    public TrieNode getChild(char c) {
        return getChild(Character.getNumericValue(c));
    }

    public TrieNode getChild(int val) {
        if (children == null) {
            return null;
        }
        return children.get(val);
    }

}
