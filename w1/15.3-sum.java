import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

/*
 * @lc app=leetcode id=15 lang=java
 *
 * [15] 3Sum
 */

// @lc code=start
class Solution {
    // 暴力法
    public List<List<Integer>> threeSum1(final int[] nums) {
        Arrays.sort(nums);
        final Set<List<Integer>> targetList = new LinkedHashSet<>();
        for (int i = 0; i < nums.length - 2; ++i) {
            for (int j = i + 1; j < nums.length - 1; ++j) {
                for (int k = j + 1; k < nums.length; ++k) {
                    if (nums[i] + nums[j] + nums[k] == 0) {
                        final List<Integer> tempList = Arrays.asList(nums[i], nums[j], nums[k]);
                        targetList.add(tempList);
                    }
                }
            }
        }
        return new ArrayList<>(targetList);
    }

    // 双指针法
    public List<List<Integer>> threeSum2(final int[] nums) {
        Arrays.sort(nums);
        final Set<List<Integer>> targetList = new LinkedHashSet<>();
        for (int i = 0; i < nums.length - 2; ++i) {
            int left = i + 1;
            int right = nums.length - 1;
            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                if (sum < 0) {
                    ++left;
                } else if (sum > 0) {
                    --right;
                } else {
                    final List<Integer> tempList = Arrays.asList(nums[i], nums[left++], nums[right--]);
                    targetList.add(tempList);
                }
            }
        }
        return new ArrayList<>(targetList);
    }

    // 双指针法 优化版
    public List<List<Integer>> threeSum3(final int[] nums) {
        Arrays.sort(nums);
        final List<List<Integer>> targetList = new ArrayList<>();
        for (int i = 0; i < nums.length - 2; ++i) {
            // 加速1：c为非负数，就不能满足a+b+c=0了
            if (nums[i] > 0) {
                return targetList;
            }
            // 加速2：跳过计算过的数据，同时防止结果重复
            if (i > 0 && nums[i] == nums[i -1]) continue;
            int left = i + 1;
            int right = nums.length - 1;
            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                if (sum < 0) {
                    ++left;
                } else if (sum > 0) {
                    --right;
                } else {
                    final List<Integer> tempList = Arrays.asList(nums[i], nums[left], nums[right]);
                    targetList.add(tempList);
                    while(left < right && nums[left] == nums[++left]);
                    while(left < right && nums[right] == nums[--right]);
                }
            }
        }
        return targetList;
    }

    
}
// @lc code=end
