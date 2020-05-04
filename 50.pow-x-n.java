/*
 * @lc app=leetcode id=50 lang=java
 *
 * [50] Pow(x, n)
 *
 * https://leetcode.com/problems/powx-n/description/
 *
 * algorithms
 * Medium (29.26%)
 * Likes:    1296
 * Dislikes: 2811
 * Total Accepted:    436.3K
 * Total Submissions: 1.5M
 * Testcase Example:  '2.00000\n10'
 *
 * Implement pow(x, n), which calculates x raised to the power n (x^n).
 * 
 * Example 1:
 * 
 * 
 * Input: 2.00000, 10
 * Output: 1024.00000
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: 2.10000, 3
 * Output: 9.26100
 * 
 * 
 * Example 3:
 * 
 * 
 * Input: 2.00000, -2
 * Output: 0.25000
 * Explanation: 2^-2 = 1/2^2 = 1/4 = 0.25
 * 
 * 
 * Note:
 * 
 * 
 * -100.0 < x < 100.0
 * n is a 32-bit signed integer, within the range [−2^31, 2^31 − 1]
 * 
 * 
 */

// @lc code=start
class Solution {
    /**
     * 暴力法超时
     * @param x
     * @param n
     * @return
     */
    public double myPow1(double x, int n) {
        double ans = 1;
        if (n < 0) {
            x = 1 / x;
            n = -n;
        }
        for (int i = 0; i < n; ++i) {
            ans *= x;
        }
        return ans;
    }

    /**
     * 快速幂递归
     * @param x
     * @param n
     * @return
     */
    public double myPow2(double x, int n) {
        if (n < 0) {
            x = 1 / x;
            n = -n;
        }
        return fastPow(x, n);
    }

    private double fastPow(double x, int n) {
        if (n == 0) {
            return 1;
        }
        int half = fastPow(x, n / 2);
        if (n % 2 == 0) {
            return half * half;
        } else {
            return half * half * x;
        }
    }

     /**
     * 快速幂递归
     * @param x
     * @param n
     * @return
     */
    public double myPow3(double x, int n) {
        double ans = 1;
        // 防止当 n 取 Integer.MIN_VALUE 转换成正数的时候丢失
        long longN = n;
        if (longN < 0) {
            x = 1 / x;
            longN = -longN;
        }
        for (long i = longN; i > 0; i /= 2) {
            // 无论奇偶 最后一次必然i = 1；
            if (i % 2 == 1) {
                ans *= x;
            }
            x *= x;
        }
        return ans;
    }
}
// @lc code=end
