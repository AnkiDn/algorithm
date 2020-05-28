/*
 * @lc app=leetcode id=394 lang=java
 *
 * [394] Decode String
 *
 * https://leetcode.com/problems/decode-string/description/
 *
 * algorithms
 * Medium (48.57%)
 * Likes:    2845
 * Dislikes: 146
 * Total Accepted:    192.2K
 * Total Submissions: 392.6K
 * Testcase Example:  '"3[a]2[bc]"'
 *
 * Given an encoded string, return its decoded string.
 * 
 * The encoding rule is: k[encoded_string], where the encoded_string inside the
 * square brackets is being repeated exactly k times. Note that k is guaranteed
 * to be a positive integer.
 * 
 * You may assume that the input string is always valid; No extra white spaces,
 * square brackets are well-formed, etc.
 * 
 * Furthermore, you may assume that the original data does not contain any
 * digits and that digits are only for those repeat numbers, k. For example,
 * there won't be input like 3a or 2[4].
 * 
 * Examples:
 * 
 * 
 * s = "3[a]2[bc]", return "aaabcbc".
 * s = "3[a2[c]]", return "accaccacc".
 * s = "2[abc]3[cd]ef", return "abcabccdcdcdef".
 * 
 * 
 * 
 * 
 */

// @lc code=start
class Solution {
    /**
     * 栈
     */
    public String decodeString(String s) {
        StringBuilder sb = new StringBuilder();
        LinkedList<Integer> stack_digit = new LinkedList<>();
        LinkedList<StringBuilder> stack_str = new LinkedList<>();
        int digit = 0;
        char[] chars = s.toCharArray();
        for (char c : chars) {
            if (c == '[') {
                stack_digit.offerLast(digit);
                stack_str.offerLast(sb);
                digit = 0;
                sb = new StringBuilder();
            } else if (c == ']') {
                StringBuilder sbTemp = stack_str.pollLast();
                int tempDigit = stack_digit.pollLast();
                for (int i = 0; i < tempDigit; ++i) sbTemp.append(sb);
                sb = sbTemp;
            } else if (Character.isDigit(c)) {
                digit = digit * 10 + c - '0';
            } else {
                sb.append(c);
            }
        }
        return sb.toString();
    }
}
// @lc code=end

