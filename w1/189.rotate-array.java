/*
 * @lc app=leetcode id=189 lang=java
 *
 * [189] Rotate Array
 */

// @lc code=start
class Solution {

    /**
     * 循环替换 把元素看做同学，把下标看做座位，大家换座位。第一个同学离开座位去第k+1个座位，
     * 第k+1个座位的同学被挤出去了，他就去坐他后k个座位，如此反复。但是会出现一种情况，
     * 就是其中一个同学被挤开之后，坐到了第一个同学的位置（空位置，没人被挤出来）， 但是此时还有人没有调换位置，这样就顺着让第二个同学换位置。
     * 那么什么时候就可以保证每个同学都换完了呢？n个同学，换n次，所以用一个count来计数即可。
     * 
     * @param nums
     * @param k
     */
    public void rotate1(int[] nums, int k) {
        int length = nums.length;
        k = k % nums.length;
        int count = 0;
        for (int i = 0; i < length; ++i) {
            if (count == length)
                return;
            int start = i;
            int startValue = nums[start];
            do {
                int next = (start + k) % length;
                int temp = nums[next];
                nums[next] = startValue;
                startValue = temp;
                start = next;
                count++;
            } while (i != start);
        }
    }

    /**
     * 三次翻转
     * 将所有元素反转。然后反转前 k 个元素，再反转后面 n-k 个元素
     * @param nums
     * @param k
     */
    public void rotate2(int[] nums, int k) {
        k %= nums.length;
        if (k == 0) return;
        reverse(nums, 0, nums.length - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, nums.length - 1);
    }

    public void reverse(int[] array, int start, int end) {
        while (start < end) {
            int temp = array[start];
            array[start] = array[end];
            array[end] = temp;
            ++start;
            --end;
        }
    }
}
// @lc code=end
