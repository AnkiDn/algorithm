/*
 * @lc app=leetcode id=208 lang=java
 *
 * [208] Implement Trie (Prefix Tree)
 *
 * https://leetcode.com/problems/implement-trie-prefix-tree/description/
 *
 * algorithms
 * Medium (44.86%)
 * Likes:    2970
 * Dislikes: 47
 * Total Accepted:    304.3K
 * Total Submissions: 637.2K
 * Testcase Example:  '["Trie","insert","search","search","startsWith","insert","search"]\n[[],["apple"],["apple"],["app"],["app"],["app"],["app"]]'
 *
 * Implement a trie with insert, search, and startsWith methods.
 * 
 * Example:
 * 
 * 
 * Trie trie = new Trie();
 * 
 * trie.insert("apple");
 * trie.search("apple");   // returns true
 * trie.search("app");     // returns false
 * trie.startsWith("app"); // returns true
 * trie.insert("app");   
 * trie.search("app");     // returns true
 * 
 * 
 * Note:
 * 
 * 
 * You may assume that all inputs are consist of lowercase letters a-z.
 * All inputs are guaranteed to be non-empty strings.
 * 
 * 
 */

// @lc code=start
class Trie {
    boolean isEnd;
    Trie[] trie;
    /** Initialize your data structure here. */
    public Trie() {
        trie = new Trie[26];
    }
    
    /** Inserts a word into the trie. */
    public void insert(String word) {
        Trie root = this;
        char[] words = word.toCharArray();
        for (char b : words) {
            if (root.trie[b - 'a'] == null) {
                root.trie[b - 'a'] = new Trie();
            }
            root = root.trie[b - 'a'];
        }
        root.isEnd = true;
    }
    
    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        Trie root = this;
        char[] words = word.toCharArray();
        for(char b : words) {
            if (root.trie[b - 'a'] == null) {
                return false;
            }
            root = root.trie[b - 'a'];
        }
        return root.isEnd;
    }
    
    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        Trie root = this;
        char[] words = prefix.toCharArray();
        for (char b : words) {
            if (root.trie[b - 'a'] == null) {
                return false;
            }
            root = root.trie[b - 'a'];
        }
        return true;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */
// @lc code=end

