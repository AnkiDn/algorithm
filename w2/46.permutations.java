import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/*
 * @lc app=leetcode id=46 lang=java
 *
 * [46] Permutations
 *
 * https://leetcode.com/problems/permutations/description/
 *
 * algorithms
 * Medium (61.33%)
 * Likes:    3400
 * Dislikes: 98
 * Total Accepted:    556.1K
 * Total Submissions: 904.1K
 * Testcase Example:  '[1,2,3]'
 *
 * Given a collection of distinct integers, return all possible permutations.
 * 
 * Example:
 * 
 * 
 * Input: [1,2,3]
 * Output:
 * [
 * ⁠ [1,2,3],
 * ⁠ [1,3,2],
 * ⁠ [2,1,3],
 * ⁠ [2,3,1],
 * ⁠ [3,1,2],
 * ⁠ [3,2,1]
 * ]
 * 
 * 
 */

// @lc code=start
class Solution {
    List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> permute(int[] nums) {
        if (nums == null)
            return null;
        recur(nums, new LinkedList<>());
        return result;
    }

    private void recur(int[] nums, LinkedList<Integer> temp) {
        if (nums.length == temp.size()) {
            result.add(new LinkedList<>(temp));
            return;
        }
        for (int i = 0; i < nums.length; ++i) {
            if (!temp.contains(nums[i])) {
                temp.push(nums[i]);
                recur(nums, temp);
                temp.pop();
            }
        }
    }
}
// @lc code=end
