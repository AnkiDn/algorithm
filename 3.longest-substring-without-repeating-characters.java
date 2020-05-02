import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import jdk.nashorn.internal.ir.WithNode;

/*
 * @lc app=leetcode id=3 lang=java
 *
 * [3] Longest Substring Without Repeating Characters
 *
 * https://leetcode.com/problems/longest-substring-without-repeating-characters/description/
 *
 * algorithms
 * Medium (29.83%)
 * Likes:    8426
 * Dislikes: 509
 * Total Accepted:    1.4M
 * Total Submissions: 4.8M
 * Testcase Example:  '"abcabcbb"'
 *
 * Given a string, find the length of the longest substring without repeating
 * characters.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: "abcabcbb"
 * Output: 3 
 * Explanation: The answer is "abc", with the length of 3. 
 * 
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: "bbbbb"
 * Output: 1
 * Explanation: The answer is "b", with the length of 1.
 * 
 * 
 * 
 * Example 3:
 * 
 * 
 * Input: "pwwkew"
 * Output: 3
 * Explanation: The answer is "wke", with the length of 3. 
 * ⁠            Note that the answer must be a substring, "pwke" is a
 * subsequence and not a substring.
 * 
 * 
 * 
 * 
 * 
 */

// @lc code=start
class Solution {
    /**
     * 一开始用的linkedList
     * 之后使用set和左指针优化
     */
    public int lengthOfLongestSubstring1(String s) {
        if(s == null) return 0;
        int left = 0;
        int max = 0;
        Set<Character> set = new HashSet<>();
        for (int i = 0; i < s.length(); ++i) {
            char charAt = s.charAt(i);
            if (!set.contains(charAt)) {
                set.add(charAt);
            }else {
                while(!set.isEmpty() && set.contains(charAt)) {
                    set.remove(s.charAt(left));
                    ++left;
                }
                set.add(charAt);
            }
            max = Math.max(max, set.size());
        }
        return max;
    }

    /**
     * 优化第一种方法
     * @param s
     * @return
     */
    public int lengthOfLongestSubstring2(String s) {
        if (s.length()==0) return 0;
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        int max=0;
        for (int i=0, tail=0; i<s.length(); ++i){
            if (map.containsKey(s.charAt(i))){
                tail = Math.max(tail,map.get(s.charAt(i))+1);
            }
            map.put(s.charAt(i),i);
            max = Math.max(max,i-tail+1);
        }
        return max;
    }
}
// @lc code=end

