/*
 * @lc app=leetcode id=238 lang=java
 *
 * [238] Product of Array Except Self
 *
 * https://leetcode.com/problems/product-of-array-except-self/description/
 *
 * algorithms
 * Medium (59.46%)
 * Likes:    4582
 * Dislikes: 397
 * Total Accepted:    515.2K
 * Total Submissions: 866.3K
 * Testcase Example:  '[1,2,3,4]'
 *
 * Given an array nums of n integers where n > 1,  return an array output such
 * that output[i] is equal to the product of all the elements of nums except
 * nums[i].
 * 
 * Example:
 * 
 * 
 * Input:  [1,2,3,4]
 * Output: [24,12,8,6]
 * 
 * 
 * Constraint: It's guaranteed that the product of the elements of any prefix
 * or suffix of the array (including the whole array) fits in a 32 bit
 * integer.
 * 
 * Note: Please solve it without division and in O(n).
 * 
 * Follow up:
 * Could you solve it with constant space complexity? (The output array does
 * not count as extra space for the purpose of space complexity analysis.)
 * 
 */

// @lc code=start
class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n];
        //ans[i] 表示索引 i 左侧所有元素的乘积
        ans[0] = 1;
        for (int i = 1; i < n; ++i) {
            ans[i] = ans[i - 1] * nums[i - 1];
        }
        // r 为右侧所有元素的乘积
        int r = 1;
        for (int i = n - 1; i >= 0; --i) {
            // 对于索引 i，左边的乘积为 ans[i]，右边的乘积为 R
            ans[i] = ans[i] * r;
            // r 需要包含右边所有的乘积，所以计算下一个结果时需要将当前值乘到 r 上
            r *= nums[i];
        }
        return ans;
    }

    public int[] productExceptSelf2(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n];
        // l 和 r 分别表示左右两侧的乘积列表
        int[] l = new int[n];
        int[] r = new int[n];
        l[0] = 1;
        r[n - 1] = 1;
        for (int i = 1; i < n; i++) {
            l[i] = l[i - 1] * nums[i - 1];
        }
        for (int i = n - 2; i >= 0; --i) {
            r[i] = r[i + 1] * nums[i + 1];
        }
        for (int i = 0; i < n; ++i) {
            ans[i] = l[i] * r[i];
        }
        return ans;
    }
}
// @lc code=end

