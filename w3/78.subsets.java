import java.lang.System.Logger.Level;
import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode id=78 lang=java
 *
 * [78] Subsets
 *
 * https://leetcode.com/problems/subsets/description/
 *
 * algorithms
 * Medium (58.91%)
 * Likes:    3208
 * Dislikes: 75
 * Total Accepted:    520K
 * Total Submissions: 879K
 * Testcase Example:  '[1,2,3]'
 *
 * Given a set of distinct integers, nums, return all possible subsets (the
 * power set).
 * 
 * Note: The solution set must not contain duplicate subsets.
 * 
 * Example:
 * 
 * 
 * Input: nums = [1,2,3]
 * Output:
 * [
 * ⁠ [3],
 * [1],
 * [2],
 * [1,2,3],
 * [1,3],
 * [2,3],
 * [1,2],
 * []
 * ]
 * 
 */

// @lc code=start
class Solution {
    /**
     * 回溯
     * @param nums
     * @return
     */
    public List<List<Integer>> subsets1(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        result.add(new ArrayList<>());
        recur(0, nums, new ArrayList<>(), result);
        return result;
    }

    private void recur (int level, int[] nums, List<Integer> temp, List<List<Integer>> result) {
        if (level > nums.length) {
            return;
        }
        for (int i = level; i < nums.length; ++i) {
            level = i + 1;
            temp.add(nums[i]);
            result.add(new ArrayList<>(temp));
            recur(level, nums, temp, result);
            temp.remove(temp.size() - 1);
        }
    }

    /**
     * 位运算
     * 假设nums=[1,2,3,4]，二进制的0可以写成0000，代表一个数也不取，
     * 1=0001表示去第一个数也就是[1]，
     * 2=0010，表示取第二个数[2]，
     * 3=0011表示取1和2位[1,2]，
     * 4=0100表示[3]....
     * 15=1111表示[1,2,3,4]
     * @param nums
     * @return
     */
    public List<List<Integer>> subsets2(int[] nums) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        for (int i = 0; i < (1 << nums.length); i++) {
            List<Integer> sub = new ArrayList<Integer>();
            for (int j = 0; j < nums.length; j++)
                if (((i >> j) & 1) == 1) sub.add(nums[j]);
            res.add(sub);
        }
        return res;
    }

    /**
     * dfs 前序遍历
     * 每个元素选与不选可以构成一个二叉树，
     * 所以 前中后序 遍历都可以
     * @param nums
     * @return
     */
    public List<List<Integer>> subsets3(int[] nums) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        result.add(new ArrayList<>());
        preOrder(0, nums, new ArrayList<>(), result);
        return result;
    }

    private void preOrder (int level, int[] nums, List<Integer> temp, List<List<Integer>> result) {
        if (level >= nums.length) {
            return;
        }
        //返回到上层的时候，除非是返回值，不然状态不会回来
        temp = new ArrayList<>(temp);
        preOrder(level + 1, nums, temp, result);
        temp.add(nums[level]);
        result.add(temp);
        preOrder(level + 1, nums, temp, result);
    }
}
// @lc code=end

