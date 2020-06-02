/*
 * @lc app=leetcode id=191 lang=java
 *
 * [191] Number of 1 Bits
 *
 * https://leetcode.com/problems/number-of-1-bits/description/
 *
 * algorithms
 * Easy (47.81%)
 * Likes:    785
 * Dislikes: 506
 * Total Accepted:    345.6K
 * Total Submissions: 711.9K
 * Testcase Example:  '00000000000000000000000000001011'
 *
 * Write a function that takes an unsigned integer and return the number of '1'
 * bits it has (also known as the Hamming weight).
 * 
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: 00000000000000000000000000001011
 * Output: 3
 * Explanation: The input binary string 00000000000000000000000000001011 has a
 * total of three '1' bits.
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: 00000000000000000000000010000000
 * Output: 1
 * Explanation: The input binary string 00000000000000000000000010000000 has a
 * total of one '1' bit.
 * 
 * 
 * Example 3:
 * 
 * 
 * Input: 11111111111111111111111111111101
 * Output: 31
 * Explanation: The input binary string 11111111111111111111111111111101 has a
 * total of thirty one '1' bits.
 * 
 * 
 * 
 * Note:
 * 
 * 
 * Note that in some languages such as Java, there is no unsigned integer type.
 * In this case, the input will be given as signed integer type and should not
 * affect your implementation, as the internal binary representation of the
 * integer is the same whether it is signed or unsigned.
 * In Java, the compiler represents the signed integers using 2's complement
 * notation. Therefore, in Example 3 above the input represents the signed
 * integer -3.
 * 
 * 
 * 
 * 
 * Follow up:
 * 
 * If this function is called many times, how would you optimize it?
 * 
 */

// @lc code=start
public class Solution {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        int ans = 0;
        while (n != 0) {
            n &= (n - 1);
            ++ans;
        }
        return ans;
    }

    public int hammingWeight2(int n) {
        int ans = 0, count = 0;
        while (count++ < 32) {
            if ((n & 1) == 1) ++ans;
            n >>= 1;
        }
        return ans;
    }
}
// @lc code=end

