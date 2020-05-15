import java.util.HashMap;

/*
 * @lc app=leetcode id=560 lang=java
 *
 * [560] Subarray Sum Equals K
 *
 * https://leetcode.com/problems/subarray-sum-equals-k/description/
 *
 * algorithms
 * Medium (43.55%)
 * Likes:    4165
 * Dislikes: 133
 * Total Accepted:    284.6K
 * Total Submissions: 650.5K
 * Testcase Example:  '[1,1,1]\n2'
 *
 * Given an array of integers and an integer k, you need to find the total
 * number of continuous subarrays whose sum equals to k.
 * 
 * Example 1:
 * 
 * 
 * Input:nums = [1,1,1], k = 2
 * Output: 2
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * The length of the array is in range [1, 20,000].
 * The range of numbers in the array is [-1000, 1000] and the range of the
 * integer k is [-1e7, 1e7].
 * 
 * 
 */

// @lc code=start
class Solution {
    public int subarraySum(int[] nums, int k) {
        int ans = 0;
        for (int i = 0; i < nums.length; ++i){
            int sum = 0;
            for (int j = i; j < nums.length;++j){
                sum += nums[j];
                if (sum == k) {
                    ++ans;
                }
            }
        }
        return ans;
    }

    /**
     * 前缀和
     */
    public int subarraySum1(int[] nums, int k) {
        int ans = 0;
        int[] sums = new int[nums.length + 1];
        for (int i = 0; i < nums.length; ++i){
            sums[i + 1] = sums[i] + nums[i];
        }
        for (int i = 1; i <= nums.length; ++i){
            for (int j = 0; j < i; ++j){
                if (sums[i] - sums[j] == k) {
                    ++ans;
                }
            }
        }
        return ans;
    }

    /**
     * 前缀和 优化
     * sums[i] - sums[j] == k 可以转化为sums[i] - k == sums[j]
     * https://leetcode-cn.com/problems/subarray-sum-equals-k/solution/qian-zhui-he-si-xiang-560-he-wei-kde-zi-shu-zu-by-/
     */
    public int subarraySum2(int[] nums, int k) {
        int ans = 0;
        HashMap<Integer, Integer> sumMap = new HashMap<>();
        sumMap.put(0, 1);
        int sum = 0;
        for (int i = 0; i < nums.length; ++i){
            sum += nums[i];
            if (sumMap.containsKey(sum - k)) { //sums[i] - k
                ans += sumMap.get(sum - k); //*可能有多个前缀和相等
            }
            sumMap.put(sum, sumMap.getOrDefault(sum, 0) + 1);
        }
        return ans;
    }
}
// @lc code=end

