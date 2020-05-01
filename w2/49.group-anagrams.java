import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 * @lc app=leetcode id=49 lang=java
 *
 * [49] Group Anagrams
 *
 * https://leetcode.com/problems/group-anagrams/description/
 *
 * algorithms
 * Medium (55.13%)
 * Likes:    3133
 * Dislikes: 166
 * Total Accepted:    629.4K
 * Total Submissions: 1.1M
 * Testcase Example:  '["eat","tea","tan","ate","nat","bat"]'
 *
 * Given an array of strings, group anagrams together.
 * 
 * Example:
 * 
 * 
 * Input: ["eat", "tea", "tan", "ate", "nat", "bat"],
 * Output:
 * [
 * ⁠ ["ate","eat","tea"],
 * ⁠ ["nat","tan"],
 * ⁠ ["bat"]
 * ]
 * 
 * Note:
 * 
 * 
 * All inputs will be in lowercase.
 * The order of your output does not matter.
 * 
 * 
 */

// @lc code=start
class Solution {
    /**
     * 使用哈希表
     * @param strs
     * @return
     */
    public List<List<String>> groupAnagrams1(String[] strs) {
        List<List<String>> resultList = new ArrayList<>();
        Map<String, List<String>> map = new HashMap();
        for (String str : strs) {
            char[] sArray = str.toCharArray();
            Arrays.sort(sArray);
            String sTemp = new String(sArray);
            List<String> tempList = map.get(sTemp);
            if (tempList == null) {
                tempList = new ArrayList<>();
                map.put(sTemp, tempList);
                resultList.add(tempList);
            }
            tempList.add(str);
        }
        return resultList;
    }

    /**
     * 字母计数法
     * @param strs
     * @return
     */
    public List<List<String>> groupAnagrams2(String[] strs) {
        if (strs == null || strs.length == 0) return new ArrayList<>();
        Map<String, List<String>> map = new HashMap<>();
        for (String s : strs) {
            char[] ca = new char[26];
            for (char c : s.toCharArray()) ca[c - 'a']++;
            String keyStr = String.valueOf(ca);
            if (!map.containsKey(keyStr)) map.put(keyStr, new ArrayList<>());
            map.get(keyStr).add(s);
        }
        return new ArrayList<>(map.values());
    }
}
// @lc code=end

