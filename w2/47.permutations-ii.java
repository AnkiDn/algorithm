/*
 * @lc app=leetcode id=47 lang=java
 *
 * [47] Permutations II
 *
 * https://leetcode.com/problems/permutations-ii/description/
 *
 * algorithms
 * Medium (44.88%)
 * Likes:    1695
 * Dislikes: 58
 * Total Accepted:    328.6K
 * Total Submissions: 730.4K
 * Testcase Example:  '[1,1,2]'
 *
 * Given a collection of numbers that might contain duplicates, return all
 * possible unique permutations.
 * 
 * Example:
 * 
 * 
 * Input: [1,1,2]
 * Output:
 * [
 * ⁠ [1,1,2],
 * ⁠ [1,2,1],
 * ⁠ [2,1,1]
 * ]
 * 
 * 
 */

// @lc code=start
class Solution {
    List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> permuteUnique(int[] nums) {
        if (nums == null)
            return null;
        Arrays.sort(nums);
        recur(nums, new boolean[nums.length], new LinkedList<>());
        return result;
    }

    private void recur(int[] nums, boolean[] used, LinkedList<Integer> temp) {
        if (nums.length == temp.size()) {
            result.add(new LinkedList<>(temp));
            return;
        }
        for (int i = 0; i < nums.length; ++i) {
            if (used[i])
                continue;

            // 剪枝条件：i > 0 是为了保证 nums[i - 1] 有意义
            // 写 !used[i - 1] 是因为 nums[i - 1] 在深度优先遍历的过程中刚刚被撤销选择
            if (i > 0 && nums[i] == nums[i - 1] && !used[i - 1]) {
                continue;
            }

            temp.push(nums[i]);
            used[i] = true;
            recur(nums, used, temp);
            used[i] = false;
            temp.pop();
        }
    }
}
// @lc code=end
