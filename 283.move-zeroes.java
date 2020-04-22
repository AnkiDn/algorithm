/*
 * @lc app=leetcode id=283 lang=java
 *
 * [283] Move Zeroes
 */

// @lc code=start
class Solution {
    //快慢指针 慢指针指向第一个0 交换 
    public void moveZeroes1(int[] nums) {
        int firstZero = 0;
        for (int i = 0; i < nums.length; ++i) {
            if (nums[i] != 0) {
                if (nums[firstZero] != nums[i]) {
                    int temp = nums[firstZero];
                    nums[firstZero] = nums[i];
                    nums[i] = temp;
                }
                ++firstZero;
            }
        }
    }

    //双指针 非0队尾
    public void moveZeroes2(int[] nums) {
        int unZeroTail = 0;
        for (int i = 0; i < nums.length; ++i) {
            if (nums[i] != 0) {
                nums[unZeroTail++] = nums[i];
            }
        }
        for (int i = unZeroTail + 1; i < nums.length; ++i){
            nums[i] = 0;
        }
    }
}
// @lc code=end
