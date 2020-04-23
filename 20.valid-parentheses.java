import java.util.Stack;

/*
 * @lc app=leetcode id=20 lang=java
 *
 * [20] Valid Parentheses
 */

// @lc code=start
class Solution {

    //字符串替换
    public boolean isValid1(String s) {
        if (s.length() % 2 != 0) return false;
        int length = 0;
        while(length != s.length()) {
            length = s.length();
            s = s.replace("()", "");
            s = s.replace("[]", "");
            s = s.replace("{}", "");

        }
        return length == 0;
    }

    public boolean isValid2(String s) {
        if (s.length() % 2 != 0) return false;
        char[] charArray = s.toCharArray();
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < charArray.length; ++i) {
            if (charArray[i] == '[') {
                stack.push(']');
            } else if (charArray[i] == '(') {
                stack.push(')');
            } else if (charArray[i] == '{') {
                stack.push('}');
            } else if (stack.isEmpty() || stack.pop() != charArray[i]) {
                return false;
            }
        }
        return stack.isEmpty();
    }
}
// @lc code=end

