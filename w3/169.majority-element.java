import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 * @lc app=leetcode id=169 lang=java
 *
 * [169] Majority Element
 *
 * https://leetcode.com/problems/majority-element/description/
 *
 * algorithms
 * Easy (56.40%)
 * Likes:    2740
 * Dislikes: 211
 * Total Accepted:    545.5K
 * Total Submissions: 964.9K
 * Testcase Example:  '[3,2,3]'
 *
 * Given an array of size n, find the majority element. The majority element is
 * the element that appears more than ⌊ n/2 ⌋ times.
 * 
 * You may assume that the array is non-empty and the majority element always
 * exist in the array.
 * 
 * Example 1:
 * 
 * 
 * Input: [3,2,3]
 * Output: 3
 * 
 * Example 2:
 * 
 * 
 * Input: [2,2,1,1,1,2,2]
 * Output: 2
 * 
 * 
 */

// @lc code=start
class Solution {
    /**
     * hash缓存
     * @param nums
     * @return
     */
    public int majorityElement1(int[] nums) {
        int n = nums.length / 2;
        Map<Integer, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < nums.length; ++i) {
            Integer temp = hashMap.get(nums[i]);
            if (temp != null) {
                temp += 1;
                hashMap.put(nums[i], temp);
            } else {
                temp = 1;
                hashMap.put(nums[i], temp);
            }
            if (temp > n) {
                return nums[i];
            }
        }
        return 0;
    }

    /**
     * 多数元素x
     * x > (n / 2)
     * 所以排序后最中间x必然存在
     * @param nums
     * @return
     */
    public int majorityElement2(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length >> 1];
    }

    /**
     * 将任意两个数做消除，最后留下来的必定是 result
     * result 必然大于 nums长度的一半
     * 这也是 摩尔投票法的思路
     * @param nums
     * @return
     */
    public int majorityElement3(int[] nums) {
        int currentNum = nums[0];
        int cureentCount = 1;
        for (int i = 1; i < nums.length; ++i) {
            if (cureentCount == 0) {
                currentNum = nums[i];
                cureentCount = 1;
            } else {
                if (currentNum == nums[i]) cureentCount += 1;
                else cureentCount -= 1;
            }
        }
        return currentNum;
    }
}
// @lc code=end

