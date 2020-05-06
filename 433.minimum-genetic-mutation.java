import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/*
 * @lc app=leetcode id=433 lang=java
 *
 * [433] Minimum Genetic Mutation
 *
 * https://leetcode.com/problems/minimum-genetic-mutation/description/
 *
 * algorithms
 * Medium (40.76%)
 * Likes:    362
 * Dislikes: 47
 * Total Accepted:    28.8K
 * Total Submissions: 70.6K
 * Testcase Example:  '"AACCGGTT"\n"AACCGGTA"\n["AACCGGTA"]'
 *
 * A gene string can be represented by an 8-character long string, with choices
 * from "A", "C", "G", "T".
 * 
 * Suppose we need to investigate about a mutation (mutation from "start" to
 * "end"), where ONE mutation is defined as ONE single character changed in the
 * gene string.
 * 
 * For example, "AACCGGTT" -> "AACCGGTA" is 1 mutation.
 * 
 * Also, there is a given gene "bank", which records all the valid gene
 * mutations. A gene must be in the bank to make it a valid gene string.
 * 
 * Now, given 3 things - start, end, bank, your task is to determine what is
 * the minimum number of mutations needed to mutate from "start" to "end". If
 * there is no such a mutation, return -1.
 * 
 * Note:
 * 
 * 
 * Starting point is assumed to be valid, so it might not be included in the
 * bank.
 * If multiple mutations are needed, all mutations during in the sequence must
 * be valid.
 * You may assume start and end string is not the same.
 * 
 * 
 * 
 * 
 * Example 1:
 * 
 * 
 * start: "AACCGGTT"
 * end:   "AACCGGTA"
 * bank: ["AACCGGTA"]
 * 
 * return: 1
 * 
 * 
 * 
 * 
 * Example 2:
 * 
 * 
 * start: "AACCGGTT"
 * end:   "AAACGGTA"
 * bank: ["AACCGGTA", "AACCGCTA", "AAACGGTA"]
 * 
 * return: 2
 * 
 * 
 * 
 * 
 * Example 3:
 * 
 * 
 * start: "AAAAACCC"
 * end:   "AACCCCCC"
 * bank: ["AAAACCCC", "AAACCCCC", "AACCCCCC"]
 * 
 * return: 3
 * 
 * 
 * 
 * 
 */

// @lc code=start
class Solution {
    int minStep = Integer.MAX_VALUE;
    //保存变化的值，不然会无限循环
    Set<String> stringSet = new HashSet<>();
    public int minMutation(String start, String end, String[] bank) {
        if (start.length() != end.length()) return -1;
        dfs(0, start, end, bank);
        if (minStep == Integer.MAX_VALUE) minStep = -1;
        return minStep;
    }

    private void dfs (int step, String start, String end, String[] bank) {
        if (step > minStep) return;
        if (start.equals(end)) {
            minStep = step;
            return;
        }
        for (int i = 0; i < bank.length; ++i) {
            int difCount = 0;
            String currentSelect = bank[i];
            for (int j = 0; j < start.length(); ++j) {
                if (currentSelect.charAt(j) != start.charAt(j)) ++difCount;
                if (difCount > 1) break;
            }
            if (difCount == 1 && !stringSet.contains(currentSelect)) {
                stringSet.add(currentSelect);
                dfs(step + 1, currentSelect, end, bank);
                stringSet.remove(currentSelect);
            }
        }
    }
}
// @lc code=end

