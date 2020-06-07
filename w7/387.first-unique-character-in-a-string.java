/*
 * @lc app=leetcode id=387 lang=java
 *
 * [387] First Unique Character in a String
 *
 * https://leetcode.com/problems/first-unique-character-in-a-string/description/
 *
 * algorithms
 * Easy (53.10%)
 * Likes:    1813
 * Dislikes: 113
 * Total Accepted:    514.3K
 * Total Submissions: 968.4K
 * Testcase Example:  '"leetcode"'
 *
 * Given a string, find the first non-repeating character in it and return it's
 * index. If it doesn't exist, return -1.
 * 
 * Examples:
 * 
 * 
 * s = "leetcode"
 * return 0.
 * 
 * s = "loveleetcode",
 * return 2.
 * 
 * 
 * 
 * 
 * Note: You may assume the string contain only lowercase English letters.
 * 
 */

// @lc code=start
class Solution {
    public int firstUniqChar(String s) {
        int[] words = new int[26];
        char[] chars = s.toCharArray();
        for (char c : chars) {
            words[c -'a']++;
        }
        for (int i = 0; i < chars.length; ++i) {
            if (words[chars[i] - 'a'] == 1) {
                return i;
            }
        }
        return -1;
    }
}
// @lc code=end

