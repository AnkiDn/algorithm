/*
 * @lc app=leetcode id=493 lang=java
 *
 * [493] Reverse Pairs
 *
 * https://leetcode.com/problems/reverse-pairs/description/
 *
 * algorithms
 * Hard (24.70%)
 * Likes:    784
 * Dislikes: 115
 * Total Accepted:    35.7K
 * Total Submissions: 144.5K
 * Testcase Example:  '[1,3,2,3,1]'
 *
 * Given an array nums, we call (i, j) an important reverse pair if i < j and
 * nums[i] > 2*nums[j].
 * 
 * You need to return the number of important reverse pairs in the given
 * array.
 * 
 * Example1:
 * 
 * Input: [1,3,2,3,1]
 * Output: 2
 * 
 * 
 * Example2:
 * 
 * Input: [2,4,3,5,1]
 * Output: 3
 * 
 * 
 * Note:
 * 
 * The length of the given array will not exceed 50,000.
 * All the numbers in the input array are in the range of 32-bit integer.
 * 
 * 
 */

// @lc code=start
class Solution {
    int ans = 0;
    /**
     * 归并
     * @param nums
     * @return
     */
    public int reversePairs(int[] nums) {
        sortAndCount(nums, 0, nums.length - 1);
        return ans;
    }

    public void mergeSort(int[] nums, int left, int right) {
        if (left >= right) return;
        int mid = (right + left) >>> 1;
        // mergeSort(nums, left, mid);
        // mergeSort(nums, mid + 1, right);

        int[] temp = new int[right - left + 1];
        int l = left, r = mid + 1, k = 0;
        while (l <= mid && r <= right) {
            if (nums[l] <= nums[r]) temp[k++] = nums[l++];
            else {
                // if (nums[l] > nums[r] * 2) ans += mid - l + 1;
                temp[k++] = nums[r++];
            }
        }
        while (l <= mid) temp[k++] = nums[l++];
        while (r <= right) temp[k++] = nums[r++];
        for (int i = 0; i < k; ++i) nums[left++] = temp[i];
    }

    public void sortAndCount(int[] nums, int left, int right) {
        if (left >= right) return;
        int mid = (right + left) >>> 1;
        sortAndCount(nums, left, mid);
        sortAndCount(nums, mid + 1, right);

        int l = left, r = mid + 1;
        while (l <= mid) {
            if (r <= right && nums[l] > nums[r] * 2l) {
                ans += mid - l + 1;
                r++;
            } else {
                l++;
            }
        }
        mergeSort(nums, left, right);
    }
}
// @lc code=end

