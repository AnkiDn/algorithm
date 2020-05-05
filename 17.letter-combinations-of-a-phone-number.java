import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/*
 * @lc app=leetcode id=17 lang=java
 *
 * [17] Letter Combinations of a Phone Number
 *
 * https://leetcode.com/problems/letter-combinations-of-a-phone-number/description/
 *
 * algorithms
 * Medium (45.45%)
 * Likes:    3504
 * Dislikes: 385
 * Total Accepted:    567.5K
 * Total Submissions: 1.2M
 * Testcase Example:  '"23"'
 *
 * Given a string containing digits from 2-9 inclusive, return all possible
 * letter combinations that the number could represent.
 * 
 * A mapping of digit to letters (just like on the telephone buttons) is given
 * below. Note that 1 does not map to any letters.
 * 
 * 
 * 
 * Example:
 * 
 * 
 * Input: "23"
 * Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
 * 
 * 
 * Note:
 * 
 * Although the above answer is in lexicographical order, your answer could be
 * in any order you want.
 * 
 */

// @lc code=start
class Solution {
    Map<Character, String> hashMap = new HashMap<>();
    /**
     * 回溯
     */
    public List<String> letterCombinations1(String digits) {
        List<String> result = new ArrayList<>();
        if ("".equals(digits)) return result;
        hashMap.put('2', "abc");
        hashMap.put('3', "def");
        hashMap.put('4', "ghi");
        hashMap.put('5', "jkl");
        hashMap.put('6', "mno");
        hashMap.put('7', "pkrs");
        hashMap.put('8', "tuv");
        hashMap.put('9', "wxyz");
        recur(0, digits, new StringBuilder(), result);
        return result;
    }
    
    private void recur(int level, String digits, StringBuilder temp, List<String> result) {
        if (level >= digits.length()) {
            result.add(temp.toString());
            return;
        }
        String charString = hashMap.get(digits.charAt(level));
        for (int j = 0; j < charString.length(); ++j) {
            recur(level + 1, digits, temp.append(charString.charAt(j)), result);
            temp.deleteCharAt(temp.length() - 1);
        }
    }

    /**
     * bfs 
     * @param digits
     * @return
     */
    public List<String> letterCombinations2(String digits) {
        LinkedList<String> result = new LinkedList<>();
        if ("".equals(digits)) return result;
        String[] mapping = new String[] {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        result.add("");
        while (result.peek().length() != digits.length()) {
            String first = result.remove();
            String currentStr = mapping[digits.charAt(first.length()) - '0'];
            for (int i = 0; i < currentStr.length(); ++i) {
                result.add(first + currentStr.charAt(i));
            }
        }
        return result;
    }
}
// @lc code=end

