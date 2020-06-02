/*
 * @lc app=leetcode id=34 lang=java
 *
 * [34] Find First and Last Position of Element in Sorted Array
 *
 * https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/description/
 *
 * algorithms
 * Medium (35.69%)
 * Likes:    3203
 * Dislikes: 139
 * Total Accepted:    480.8K
 * Total Submissions: 1.3M
 * Testcase Example:  '[5,7,7,8,8,10]\n8'
 *
 * Given an array of integers nums sorted in ascending order, find the starting
 * and ending position of a given target value.
 * 
 * Your algorithm's runtime complexity must be in the order of O(log n).
 * 
 * If the target is not found in the array, return [-1, -1].
 * 
 * Example 1:
 * 
 * 
 * Input: nums = [5,7,7,8,8,10], target = 8
 * Output: [3,4]
 * 
 * Example 2:
 * 
 * 
 * Input: nums = [5,7,7,8,8,10], target = 6
 * Output: [-1,-1]
 * 
 */

// @lc code=start
class Solution {
    public int[] searchRange(int[] nums, int target) {
        if (nums == null || nums.length == 0) return new int[]{-1, -1};
        int start = 0, end = 0;
        start = searchLeft(nums, 0, nums.length - 1, target);
        end = searchRight(nums, 0, nums.length - 1, target);
        return new int[]{start, end};
    }

    public int searchLeft(int[] nums, int left, int right, int target) {
        while (left < right) {
            int mid = (left + right) >>> 1;
            if (nums[mid] >= target) right = mid;
            else left = mid + 1;
        }
        if (left > nums.length - 1 || nums[left] != target) left = -1;
        return left;
    }

    public int searchRight(int[] nums, int left, int right, int target) {
        while (left < right) {
            int mid = (left + right + 1) >>> 1;
            if (nums[mid] <= target) left = mid;
            else right = mid - 1;
        }
        if (left < 0 || nums[left] != target) left = -1;
        return left;
    }
}
// @lc code=end

