import java.util.HashMap;

/*
 * @lc app=leetcode id=1 lang=java
 *
 * [1] Two Sum
 */

// @lc code=start
class Solution {
    // 暴力法
    public int[] twoSum1(int[] nums, int target) {
        for (int i = 0; i < nums.length - 1; ++i) {
            for (int j = i + 1; j < nums.length; ++j) {
                if (target == nums[i] + nums[j]) {
                    return new int[] { i, j };
                }
            }
        }
        return new int[]{};
    }

    //缓存法
    public int[] twoSum2(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; ++i) {
            map.put(nums[i], i);
        }
        for (int i = 0; i < nums.length; ++i) {
            int other = target - nums[i];
            if (map.containsKey(other) && map.get(other) != i) {
                return new int[]{i, map.get(other)};
            }
        }
        return new int[]{};
    }

    //缓存法 优化版
    public int[] twoSum3(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; ++i) {
            Integer index = map.get(target - nums[i]);
            if (index != null) {
                return new int[]{index, i};
            } else {
                map.put(nums[i], i);
            }
        }
        return new int[]{};
    }
}
// @lc code=end
