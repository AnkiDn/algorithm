/*
 * @lc app=leetcode id=211 lang=java
 *
 * [211] Add and Search Word - Data structure design
 *
 * https://leetcode.com/problems/add-and-search-word-data-structure-design/description/
 *
 * algorithms
 * Medium (34.93%)
 * Likes:    1606
 * Dislikes: 81
 * Total Accepted:    174.4K
 * Total Submissions: 487.6K
 * Testcase Example:  '["WordDictionary","addWord","addWord","addWord","search","search","search","search"]\n[[],["bad"],["dad"],["mad"],["pad"],["bad"],[".ad"],["b.."]]'
 *
 * Design a data structure that supports the following two operations:
 * 
 * 
 * void addWord(word)
 * bool search(word)
 * 
 * 
 * search(word) can search a literal word or a regular expression string
 * containing only letters a-z or .. A . means it can represent any one
 * letter.
 * 
 * Example:
 * 
 * 
 * addWord("bad")
 * addWord("dad")
 * addWord("mad")
 * search("pad") -> false
 * search("bad") -> true
 * search(".ad") -> true
 * search("b..") -> true
 * 
 * 
 * Note:
 * You may assume that all words are consist of lowercase letters a-z.
 * 
 */

// @lc code=start
class WordDictionary {
    boolean isEnd;
    WordDictionary[] wd;
    /** Initialize your data structure here. */
    public WordDictionary() {
        wd = new WordDictionary[26];
    }
    
    /** Adds a word into the data structure. */
    public void addWord(String word) {
        WordDictionary root = this;
        char[] words = word.toCharArray();
        for (char c : words) {
            if (root.wd[c - 'a'] == null) {
                root.wd[c - 'a'] = new WordDictionary();
            }
            root = root.wd[c - 'a'];
        }
        root.isEnd = true;
    }
    
    /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
    public boolean search(String word) {
        return dfs(this, word.toCharArray(), 0);
    }

    public boolean dfs (WordDictionary root, char[] c, int start) {
        if (start == c.length) {
            return root.isEnd;
        }
        char b = c[start];
        if (b == '.') {
            for (WordDictionary w : root.wd) {
                if (w != null && dfs(w, c, start + 1)) {
                    return true;
                }
            }
            return false;
        } else {
            if (root.wd[b - 'a'] != null) {
                return dfs (root.wd[b - 'a'], c , start + 1);
            }
            return false;
        }
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */
// @lc code=end

