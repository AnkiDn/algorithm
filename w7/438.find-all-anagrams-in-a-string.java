/*
 * @lc app=leetcode id=438 lang=java
 *
 * [438] Find All Anagrams in a String
 *
 * https://leetcode.com/problems/find-all-anagrams-in-a-string/description/
 *
 * algorithms
 * Medium (42.61%)
 * Likes:    2914
 * Dislikes: 168
 * Total Accepted:    254.9K
 * Total Submissions: 597.5K
 * Testcase Example:  '"cbaebabacd"\n"abc"'
 *
 * Given a string s and a non-empty string p, find all the start indices of p's
 * anagrams in s.
 * 
 * Strings consists of lowercase English letters only and the length of both
 * strings s and p will not be larger than 20,100.
 * 
 * The order of output does not matter.
 * 
 * Example 1:
 * 
 * Input:
 * s: "cbaebabacd" p: "abc"
 * 
 * Output:
 * [0, 6]
 * 
 * Explanation:
 * The substring with start index = 0 is "cba", which is an anagram of "abc".
 * The substring with start index = 6 is "bac", which is an anagram of
 * "abc".
 * 
 * 
 * 
 * Example 2:
 * 
 * Input:
 * s: "abab" p: "ab"
 * 
 * Output:
 * [0, 1, 2]
 * 
 * Explanation:
 * The substring with start index = 0 is "ab", which is an anagram of "ab".
 * The substring with start index = 1 is "ba", which is an anagram of "ab".
 * The substring with start index = 2 is "ab", which is an anagram of "ab".
 * 
 * 
 */

// @lc code=start
class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> ans = new ArrayList<>();
        int[] windows = new int[26];
        int[] pWindows = new int[26];
        int valid = 0;
        for (char c : p.toCharArray()) {
            if (pWindows[c - 'a'] == 0) {
                valid++;
            }
            pWindows[c - 'a']++;
        }
        char[] sChars = s.toCharArray();
        for (int i = 0, j = 0; i < s.length(); ++i) {
            char c = sChars[i];
            windows[c - 'a']++;
            if (windows[c -'a'] == pWindows[c - 'a']) valid-- ;
            while (j <= i && i - j + 1 == p.length()) {
                // System.out.println("i: " + i + ", valid: " + valid + ", len: " + pWindows.length);
                if (valid == 0) {
                    ans.add(j);
                }
                char d = sChars[j];
                if (pWindows[d - 'a'] == windows[d - 'a']) {
                    valid++;
                }
                j++;
                windows[d - 'a']--;
            }
        }
        return ans;
    }
}
// @lc code=end

