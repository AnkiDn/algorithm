import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/*
 * @lc app=leetcode id=77 lang=java
 *
 * [77] Combinations
 *
 * https://leetcode.com/problems/combinations/description/
 *
 * algorithms
 * Medium (52.87%)
 * Likes:    1279
 * Dislikes: 63
 * Total Accepted:    271K
 * Total Submissions: 511.3K
 * Testcase Example:  '4\n2'
 *
 * Given two integers n and k, return all possible combinations of k numbers
 * out of 1 ... n.
 * 
 * Example:
 * 
 * 
 * Input: n = 4, k = 2
 * Output:
 * [
 * ⁠ [2,4],
 * ⁠ [3,4],
 * ⁠ [2,3],
 * ⁠ [1,2],
 * ⁠ [1,3],
 * ⁠ [1,4],
 * ]
 * 
 * 
 */

// @lc code=start
class Solution {
    List<List<Integer>> result = new ArrayList<>();
    /**
     * 回溯
     * @param n
     * @param k
     * @return
     */
    public List<List<Integer>> combine(int n, int k) {
        recur(1, n, k, new LinkedList<>());
        return result;
    }

    private void recur(int start, int n, int k, LinkedList<Integer> temp) {
        if (temp.size() == k) {
            result.add(new LinkedList<>(temp));
            return;
        }
        //长度不够了 后面就不用执行了。
        for (int i = start; i <= n - (k - temp.size()) + 1; ++i) {
            temp.add(i);
            recur(i + 1, n, k, temp);
            temp.pop();
        }
        return;
    }
}
// @lc code=end
