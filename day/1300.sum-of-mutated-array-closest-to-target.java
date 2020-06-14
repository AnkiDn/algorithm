/*
 * @lc app=leetcode id=1300 lang=java
 *
 * [1300] Sum of Mutated Array Closest to Target
 */

// @lc code=start
class Solution {
    public int findBestValue(int[] arr, int target) {
        int left = 0, right = 0, sum = 0;
        for (int a : arr) {
            sum += a;
            right = Math.max(right, a);
        }
        //target比原数组和还大就直接返回最大值
        if (sum <= target) return right;
        while (left < right) {
            int mid = (left + right) >>> 1;
            sum = 0;
            for (int a : arr) sum += Math.min(mid, a);
            //寻找比target的值大于等于的数
            if (sum >= target) right = mid;
            else left = mid + 1; 
        }
        //因为可能是大于target的所以计算一下小于target的 取最接近的。
        int sum1 = 0, sum2 = 0;
        for (int a : arr) {
            sum1 += Math.min(left - 1, a);
            sum2 += Math.min(left, a);
        }
        return Math.abs(sum1 - target) <= Math.abs(sum2 - target) ? left - 1 : left;
    }
}
// @lc code=end

