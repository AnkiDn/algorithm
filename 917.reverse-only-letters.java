/*
 * @lc app=leetcode id=917 lang=java
 *
 * [917] Reverse Only Letters
 *
 * https://leetcode.com/problems/reverse-only-letters/description/
 *
 * algorithms
 * Easy (57.59%)
 * Likes:    509
 * Dislikes: 34
 * Total Accepted:    53.1K
 * Total Submissions: 92.2K
 * Testcase Example:  '"ab-cd"'
 *
 * Given a string S, return the "reversed" string where all characters that are
 * not a letter stay in the same place, and all letters reverse their
 * positions.
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: "ab-cd"
 * Output: "dc-ba"
 * 
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: "a-bC-dEf-ghIj"
 * Output: "j-Ih-gfE-dCba"
 * 
 * 
 * 
 * Example 3:
 * 
 * 
 * Input: "Test1ng-Leet=code-Q!"
 * Output: "Qedo1ct-eeLg=ntse-T!"
 * 
 * 
 * 
 * 
 * 
 * Note:
 * 
 * 
 * S.length <= 100
 * 33 <= S[i].ASCIIcode <= 122 
 * S doesn't contain \ or "
 * 
 * 
 * 
 * 
 * 
 */

// @lc code=start
class Solution {

    /**
     * 双指针
     */
    public String reverseOnlyLetters(String S) {
        char[] chars = S.toCharArray();
        int l = 0, r = chars.length - 1;
        while (l < r) {
            // if (Character.isLetter(chars[l]) && Character.isLetter(chars[r])) {
            //     char temp = chars[l];
            //     chars[l++] = chars[r];
            //     chars[r--] = temp;
            // }
            // if (!Character.isLetter(chars[l])) l++;
            // if (!Character.isLetter(chars[r])) r--;
            while (l < r && !Character.isLetter(chars[l])) { l++; }
            while (l < r && !Character.isLetter(chars[r])) { r--; }
            char temp = chars[l];
            chars[l++] = chars[r];
            chars[r--] = temp;
        }
        return String.valueOf(chars);
    }

    public String reverseOnlyLetters2(String S) {
        char[] chars = S.toCharArray();
        Deque<Character> stack = new ArrayDeque<>();
        for (char c : chars) {
            if (Character.isLetter(c)) {
                stack.offerLast(c);
            }
        }
        for (int i = 0; i < chars.length; ++i) {
            if (Character.isLetter(chars[i])) {
                chars[i] = stack.pollLast();
            }
        }
        return String.valueOf(chars);
    }
}
// @lc code=end

