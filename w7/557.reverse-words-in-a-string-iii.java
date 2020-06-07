/*
 * @lc app=leetcode id=557 lang=java
 *
 * [557] Reverse Words in a String III
 *
 * https://leetcode.com/problems/reverse-words-in-a-string-iii/description/
 *
 * algorithms
 * Easy (68.93%)
 * Likes:    933
 * Dislikes: 85
 * Total Accepted:    194.1K
 * Total Submissions: 281.5K
 * Testcase Example:  `"Let's take LeetCode contest"`
 *
 * Given a string, you need to reverse the order of characters in each word
 * within a sentence while still preserving whitespace and initial word order.
 * 
 * Example 1:
 * 
 * Input: "Let's take LeetCode contest"
 * Output: "s'teL ekat edoCteeL tsetnoc"
 * 
 * 
 * 
 * Note:
 * In the string, each word is separated by single space and there will not be
 * any extra space in the string.
 * 
 */

// @lc code=start
class Solution {
    public String reverseWords(String s) {
        char[] cs = s.toCharArray();
        int l = 0, r = 0;
        while (r < cs.length) {
            while (r < cs.length && cs[r] != ' ') { r++; }
            swap(cs, l, r - 1);
            r++;
            l = r;
        }
        return String.valueOf(cs);
    }

    private void swap(char[] c, int i, int j) {
        while (i < j) {
            char temp = c[i];
            c[i++] = c[j];
            c[j--] = temp;
        }
    }
}
// @lc code=end

