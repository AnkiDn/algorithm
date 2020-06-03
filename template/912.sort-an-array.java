/*
 * @lc app=leetcode id=912 lang=java
 *
 * [912] Sort an Array
 *
 * https://leetcode.com/problems/sort-an-array/description/
 *
 * algorithms
 * Medium (63.28%)
 * Likes:    382
 * Dislikes: 251
 * Total Accepted:    71.4K
 * Total Submissions: 112.8K
 * Testcase Example:  '[5,2,3,1]'
 *
 * Given an array of integers nums, sort the array in ascending order.
 * 
 * 
 * Example 1:
 * Input: nums = [5,2,3,1]
 * Output: [1,2,3,5]
 * Example 2:
 * Input: nums = [5,1,1,2,0,0]
 * Output: [0,0,1,1,2,5]
 * 
 * 
 * Constraints:
 * 
 * 
 * 1 <= nums.length <= 50000
 * -50000 <= nums[i] <= 50000
 * 
 * 
 */

// @lc code=start
class Solution {
    public int[] sortArray(int[] nums) {
        quickSort(nums, 0, nums.length - 1);
        mergeSort(nums, 0, nums.length - 1);
        insertSort(nums);
        bubbleSort(nums);
        countSort(nums);
        return nums;
    }

    public void quickSort(int[] nums, int left, int right) {
        if (left >= right) return;
        int i = left - 1, j = right + 1, mid = nums[(left + right) >>> 1];
        while (i < j) {
            do { i++; } while (nums[i] < mid);
            do { j--; } while (nums[j] > mid);
            if (i < j) swap(nums, i, j);
        }
    }

    public void mergeSort(int[] nums, int left, int right) {
        if (left >= right) return;
        int mid = (right + left) >>> 1;
        mergeSort(nums, left, mid);
        mergeSort(nums, mid + 1, right);

        int[] temp = new int[right - left + 1];
        int l = left, r = mid + 1, k = 0;
        while (l <= mid && r <= right) {
            if (nums[l] <= nums[r]) temp[k++] = nums[l++];
            else temp[k++] = nums[r++];
        }
        while (l <= mid) temp[k++] = nums[l++];
        while (r <= right) temp[k++] = nums[r++];
        for (int i = 0; i < k; ++i) nums[left++] = temp[i];
    }

    public void insertSort(int[] nums) {
        for (int i = 1; i < nums.length; ++i) {
            int j = i;
            while(j > 0; nums[j] < nums[j - 1]) {
                swap(nums, j, j - 1);
                j--;
            }
        }
    }

    public int[] bubbleSort(int[] nums) {
        for (int i = nums.length - 1; i >= 0; --i) {// 冒泡得到n-1个最大值
            for (int j = 0; j < i; ++j) {
                if (nums[j] > nums[j + 1]) {
                    swap(nums, j, j + 1) // 交换得到较大值
                }
            }
        }
        return nums;
    }

    public void countSort(int[] nums) {
        int max = -50001, min = 50001;
        for (int num : nums) {
            max = Math.max(max, num);
            min = Math.min(min, num);
        }
        int[] temp = new int[max - min + 1];
        for (int num : nums) {
            temp[num - min]++;
        }
        int index = 0;
        for (int i = min; i <= max; ++i) {
            while (temp[i - min]-- > 0) {
                nums[index++] = i;
            }
        }
    }

    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
// @lc code=end

