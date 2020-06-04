/*
 * @lc app=leetcode id=205 lang=java
 *
 * [205] Isomorphic Strings
 *
 * https://leetcode.com/problems/isomorphic-strings/description/
 *
 * algorithms
 * Easy (39.45%)
 * Likes:    1303
 * Dislikes: 342
 * Total Accepted:    284.4K
 * Total Submissions: 720.7K
 * Testcase Example:  '"egg"\n"add"'
 *
 * Given two strings s and t, determine if they are isomorphic.
 * 
 * Two strings are isomorphic if the characters in s can be replaced to get t.
 * 
 * All occurrences of a character must be replaced with another character while
 * preserving the order of characters. No two characters may map to the same
 * character but a character may map to itself.
 * 
 * Example 1:
 * 
 * 
 * Input: s = "egg", t = "add"
 * Output: true
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: s = "foo", t = "bar"
 * Output: false
 * 
 * Example 3:
 * 
 * 
 * Input: s = "paper", t = "title"
 * Output: true
 * 
 * Note:
 * You may assume both s and t have the same length.
 * 
 */

// @lc code=start
class Solution {
    /**
     * 映射
     */
    public boolean isIsomorphic(String s, String t) {
        if (s.length() != t.length()) return false;
        int n = s.length();
        int[] smap = new int[128];
        int[] tmap = new int[128];
        for (int i = 0; i < n; ++i) {
            char schar = s.charAt(i);
            char tchar = t.charAt(i);
             //当前的映射值是否相同
            if (smap[schar] != tmap[tchar]) return false;
            //是否已经修改过，修改过就不需要再处理
            if (smap[schar] != 0) continue;
            smap[schar] = tmap[tchar] = i + 1;
        }
        return true;
    }

    /**
     * 暴力map
     */
    public boolean isIsomorphic2(String s, String t) {
        if (s.length() != t.length()) return false;
        return isIsomorphicHelper(s, t) && isIsomorphicHelper(t, s);
    }

    public boolean isIsomorphicHelper(String s, String t) {
        Map<Character, Character> map = new HashMap<>();
        for (int i = 0; i < s.length(); ++i) {
            char schar = s.charAt(i);
            char tchar = t.charAt(i);
            if (map.containsKey(schar)) {
                if (map.get(schar) != tchar) return false;
            } else {
                map.put(schar, tchar);
            }
        }
        return true;
    }
}
// @lc code=end

