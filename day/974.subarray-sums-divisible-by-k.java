/*
 * @lc app=leetcode id=974 lang=java
 *
 * [974] Subarray Sums Divisible by K
 *
 * https://leetcode.com/problems/subarray-sums-divisible-by-k/description/
 *
 * algorithms
 * Medium (47.72%)
 * Likes:    750
 * Dislikes: 60
 * Total Accepted:    29.9K
 * Total Submissions: 62.2K
 * Testcase Example:  '[4,5,0,-2,-3,1]\n5'
 *
 * Given an array A of integers, return the number of (contiguous, non-empty)
 * subarrays that have a sum divisible by K.
 * 
 * 
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: A = [4,5,0,-2,-3,1], K = 5
 * Output: 7
 * Explanation: There are 7 subarrays with a sum divisible by K = 5:
 * [4, 5, 0, -2, -3, 1], [5], [5, 0], [5, 0, -2, -3], [0], [0, -2, -3], [-2,
 * -3]
 * 
 * 
 * 
 * 
 * Note:
 * 
 * 
 * 1 <= A.length <= 30000
 * -10000 <= A[i] <= 10000
 * 2 <= K <= 10000
 * 
 * 
 */

// @lc code=start
class Solution {
    public int subarraysDivByK(int[] A, int K) {
        int ans = 0;
        int[] modCount = new int[K];
        int sum = 0;
        modCount[0] = 1;
        for(int a : A) {
            sum += a;
            int mod = Math.floorMod(sum, K);
            ans += modCount[mod];
            ++modCount[mod];
        }
        return ans;
    }
}
// @lc code=end

