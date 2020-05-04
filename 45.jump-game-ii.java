/*
 * @lc app=leetcode id=45 lang=java
 *
 * [45] Jump Game II
 *
 * https://leetcode.com/problems/jump-game-ii/description/
 *
 * algorithms
 * Hard (29.94%)
 * Likes:    2179
 * Dislikes: 122
 * Total Accepted:    240.9K
 * Total Submissions: 801.5K
 * Testcase Example:  '[2,3,1,1,4]'
 *
 * Given an array of non-negative integers, you are initially positioned at the
 * first index of the array.
 * 
 * Each element in the array represents your maximum jump length at that
 * position.
 * 
 * Your goal is to reach the last index in the minimum number of jumps.
 * 
 * Example:
 * 
 * 
 * Input: [2,3,1,1,4]
 * Output: 2
 * Explanation: The minimum number of jumps to reach the last index is 2.
 * ⁠   Jump 1 step from index 0 to 1, then 3 steps to the last index.
 * 
 * Note:
 * 
 * You can assume that you can always reach the last index.
 * 
 */

// @lc code=start
class Solution {
    /**
     * 贪心 反向查找On^2
     * @param nums
     * @return
     */
    public int jump1(int[] nums) {
        if (nums == null) return 0;
        int position = nums.length - 1;
        int step = 0;
        while (position > 0) {
            //每一次都找最远的
            for (int i = 0; i < position; ++i) {
                if (i + nums[i] >= position) {
                    position = i;
                    ++step;
                    break;
                }
            }
        }
        return step;
    }

    /**
     * 贪心 正向查找 On
     * @param nums
     * @return
     */
    public int jump2(int[] nums) {
        if (nums == null) return 0;
        int last = nums.length - 1;
        int step = 0, bound = 0, maxPosition = 0;
        //有点类似bfs
        for (int i = 0; i < last; ++i) {
            //在一个边界里找最大距离，找到后就更新边界，并且步数+1
            maxPosition = Math.max(maxPosition, i + nums[i]);
            if (i == bound) {
                bound = maxPosition;
                ++step;
            }
        }
        return step;
    }
}
// @lc code=end

