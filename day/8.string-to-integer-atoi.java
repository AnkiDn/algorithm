/*
 * @lc app=leetcode id=8 lang=java
 *
 * [8] String to Integer (atoi)
 *
 * https://leetcode.com/problems/string-to-integer-atoi/description/
 *
 * algorithms
 * Medium (15.13%)
 * Likes:    1482
 * Dislikes: 8759
 * Total Accepted:    537K
 * Total Submissions: 3.5M
 * Testcase Example:  '"42"'
 *
 * Implement atoi which converts a string to an integer.
 * 
 * The function first discards as many whitespace characters as necessary until
 * the first non-whitespace character is found. Then, starting from this
 * character, takes an optional initial plus or minus sign followed by as many
 * numerical digits as possible, and interprets them as a numerical value.
 * 
 * The string can contain additional characters after those that form the
 * integral number, which are ignored and have no effect on the behavior of
 * this function.
 * 
 * If the first sequence of non-whitespace characters in str is not a valid
 * integral number, or if no such sequence exists because either str is empty
 * or it contains only whitespace characters, no conversion is performed.
 * 
 * If no valid conversion could be performed, a zero value is returned.
 * 
 * Note:
 * 
 * 
 * Only the space character ' ' is considered as whitespace character.
 * Assume we are dealing with an environment which could only store integers
 * within the 32-bit signed integer range: [−2^31,  2^31 − 1]. If the numerical
 * value is out of the range of representable values, INT_MAX (2^31 − 1) or
 * INT_MIN (−2^31) is returned.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: "42"
 * Output: 42
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: "   -42"
 * Output: -42
 * Explanation: The first non-whitespace character is '-', which is the minus
 * sign.
 * Then take as many numerical digits as possible, which gets 42.
 * 
 * 
 * Example 3:
 * 
 * 
 * Input: "4193 with words"
 * Output: 4193
 * Explanation: Conversion stops at digit '3' as the next character is not a
 * numerical digit.
 * 
 * 
 * Example 4:
 * 
 * 
 * Input: "words and 987"
 * Output: 0
 * Explanation: The first non-whitespace character is 'w', which is not a
 * numerical 
 * digit or a +/- sign. Therefore no valid conversion could be performed.
 * 
 * Example 5:
 * 
 * 
 * Input: "-91283472332"
 * Output: -2147483648
 * Explanation: The number "-91283472332" is out of the range of a 32-bit
 * signed integer.
 * Thefore INT_MIN (−2^31) is returned.
 * 
 */

// @lc code=start
class Solution {
    /**
     * 有限状态机，DFA
     */
    public int myAtoi(String str) {
        
    }

    /**
     * 笨方法一个一个判断
     * @param str
     * @return
     */
    public int myAtoi2(String str) {
        int ans = 0, index = 0, flag = 1, length = str.length();
        while(index < length) {
            if (str.charAt(index) == ' ') {
                ++index;
            } else {
                break;
            }
        }
        if (index == length) return ans;
        if (str.charAt(index) == '-') flag = -1;
        if (str.charAt(index) == '-' || str.charAt(index) == '+') ++index;
        while(index < length) {
            int cur = str.charAt(index) - '0';
            if (cur < 0 || cur > 9) break;
            if (ans > Integer.MAX_VALUE / 10 || (ans == Integer.MAX_VALUE / 10 && cur > 7)) {
                return flag > 0 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }
            ans = ans * 10 + cur;
            ++index;
        }
        return ans * flag;
    }

    /**
     * 取巧 使用regex
     * @param str
     * @return
     */
    public int myAtoi3(String str) {
        str = str.trim();
        Pattern p = Pattern.compile("^[+-]?\\d+");
        Matcher m = p.matcher(str);
        int ans = 0;
        if (m.find()) {
            try {
                ans = Integer.parseInt(str.substring(m.start(), m.end()));
            } catch(Exception e) {
                ans = str.charAt(0) == '-' ? Integer.MIN_VALUE : Integer.MAX_VALUE;
            }
        }
        return ans;
    }
}
// @lc code=end

