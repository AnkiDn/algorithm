/*
 * @lc app=leetcode id=128 lang=java
 *
 * [128] Longest Consecutive Sequence
 *
 * https://leetcode.com/problems/longest-consecutive-sequence/description/
 *
 * algorithms
 * Hard (44.53%)
 * Likes:    3072
 * Dislikes: 170
 * Total Accepted:    290.2K
 * Total Submissions: 651.2K
 * Testcase Example:  '[100,4,200,1,3,2]'
 *
 * Given an unsorted array of integers, find the length of the longest
 * consecutive elements sequence.
 * 
 * Your algorithm should run in O(n) complexity.
 * 
 * Example:
 * 
 * 
 * Input: [100, 4, 200, 1, 3, 2]
 * Output: 4
 * Explanation: The longest consecutive elements sequence is [1, 2, 3, 4].
 * Therefore its length is 4.
 * 
 * 
 */

// @lc code=start
class Solution {
    /**
     * 哈希表
     * @param nums
     * @return
     */
    public int longestConsecutive(int[] nums) {
        int ans = 0;
        Set<Integer> hashSet = new HashSet<>();
        for (int n : nums) hashSet.add(n);
        for (int n : hashSet) {
            if (hashSet.contains(n - 1)) continue;
            int currentNum = n;
            int currentLen = 1;
            while (hashSet.contains(currentNum + 1)) {
                currentNum++;
                currentLen++;
            }
            ans = Math.max(ans, currentLen);
        }
        return ans;
    }
}
// @lc code=end

