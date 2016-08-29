package com.jcs.util;

/**
 *
 * @author rob
 */
public class TrieNodeDemo {

    private TrieNode root;

    public static void main(String[] args) {
        TrieNodeDemo d = new TrieNodeDemo();
        d.run("Hello", "Hell", "What", "Whatup");
    }

    public void run(String... words) {
        root = new TrieNode();
        for (int i = 0; i < words.length; i++) {
            root.add(words[i]);
        }
        for (int i = 0; i < words.length; i++) {
            Boolean contains = root.contains(words[i]);
            Boolean containsPrefix = root.isPrefix(words[i].substring(0, words[i].length() - 2));
            System.out.println(contains.toString() + " " + containsPrefix.toString());
        }
        String[] notWords = new String[]{"apple", "a", "He", "Wha"};
        for (int i = 0; i < notWords.length; i++) {
            Boolean contains = root.contains(notWords[i]);
            Boolean containsPrefix = root.isPrefix(notWords[i]);
            System.out.println(contains.toString() + " " + containsPrefix.toString());
        }
    }

}
