/*
 * @lc app=leetcode id=26 lang=java
 *
 * [26] Remove Duplicates from Sorted Array
 */

// @lc code=start
class Solution {
    /**
     * 双指针 慢指针🈯️向队尾
     * @param nums
     * @return
     */
    public int removeDuplicates1(int[] nums) {
        int newArrayTail = 0;
        for (int i = 1; i < nums.length; ++i) {
            if (nums[i] != nums[i -1]){
                nums[++newArrayTail] = nums[i];
            }
        }
        return newArrayTail + 1;
    }

    /**
     * 双指针 慢指针指向重复的第一个位置
     * @param nums
     * @return
     */
    public int removeDuplicates2(int[] nums) {
        int firstDup = 0;
        for (int i = 1; i < nums.length; ++i) {
            if (nums[i] != nums[firstDup]){
                nums[++firstDup] = nums[i];
            }
        }
        return firstDup + 1;
    }
}
// @lc code=end
