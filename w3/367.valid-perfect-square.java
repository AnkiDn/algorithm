/*
 * @lc app=leetcode id=367 lang=java
 *
 * [367] Valid Perfect Square
 *
 * https://leetcode.com/problems/valid-perfect-square/description/
 *
 * algorithms
 * Easy (41.03%)
 * Likes:    657
 * Dislikes: 143
 * Total Accepted:    153.8K
 * Total Submissions: 374.7K
 * Testcase Example:  '16'
 *
 * Given a positive integer num, write a function which returns True if num is
 * a perfect square else False.
 * 
 * Note: Do not use any built-in library function such as sqrt.
 * 
 * Example 1:
 * 
 * 
 * 
 * Input: 16
 * Output: true
 * 
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: 14
 * Output: false
 * 
 * 
 * 
 */

// @lc code=start
class Solution {
    /**
     * 二分查找
     * @param num
     * @return
     */
    public boolean isPerfectSquare(int num) {
        if (num < 2) return true;
        long left = 2;
        long right = num / 2;
        while (left <= right) {
            long mid = (left + right) >>> 1;
            long sqrt = mid * mid;
            if (sqrt == num) {
                return true;
            }
            if (sqrt > num) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return false;
    }

    /**
     *牛顿迭代法
     */
    public boolean isPerfectSquare2(int num) {
        if (num < 2) return true;
        long x = num / 2;
        while (x * x > num) {
            x = (x + num / x) / 2;
        }
        return (x * x == num);
    }
}
// @lc code=end

