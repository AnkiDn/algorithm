/*
 * @lc app=leetcode id=1371 lang=java
 *
 * [1371] Find the Longest Substring Containing Vowels in Even Counts
 *
 * https://leetcode.com/problems/find-the-longest-substring-containing-vowels-in-even-counts/description/
 *
 * algorithms
 * Medium (56.05%)
 * Likes:    281
 * Dislikes: 9
 * Total Accepted:    5.3K
 * Total Submissions: 9.4K
 * Testcase Example:  '"eleetminicoworoep"'
 *
 * Given the string s, return the size of the longest substring containing each
 * vowel an even number of times. That is, 'a', 'e', 'i', 'o', and 'u' must
 * appear an even number of times.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: s = "eleetminicoworoep"
 * Output: 13
 * Explanation: The longest substring is "leetminicowor" which contains two
 * each of the vowels: e, i and o and zero of the vowels: a and u.
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: s = "leetcodeisgreat"
 * Output: 5
 * Explanation: The longest substring is "leetc" which contains two e's.
 * 
 * 
 * Example 3:
 * 
 * 
 * Input: s = "bcbcbc"
 * Output: 6
 * Explanation: In this case, the given string "bcbcbc" is the longest because
 * all vowels: a, e, i, o and u appear zero times.
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * 1 <= s.length <= 5 x 10^5
 * s contains only lowercase English letters.
 * 
 */

// @lc code=start
class Solution {
    /**
     * i + 1为当到i位置时所包含到字符数
     * @param s
     * @return
     */
    public int findTheLongestSubstring(String s) {
        int n = s.length();
        int[] pos = new int[1 << 5];
        Arrays.fill(pos, -1);
        int ans = 0, status = 0;
        pos[0] = 0;
        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);
            if (ch == 'a') {
                status ^= (1 << 0);
            } else if (ch == 'e') {
                status ^= (1 << 1);
            } else if (ch == 'i') {
                status ^= (1 << 2);
            } else if (ch == 'o') {
                status ^= (1 << 3);
            } else if (ch == 'u') {
                status ^= (1 << 4);
            }
            if (pos[status] >= 0) {
                ans = Math.max(ans, i + 1 - pos[status]);
            } else {
                pos[status] = i + 1;
            }
        }
        return ans;
    }
}
// @lc code=end

