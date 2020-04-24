import java.util.ArrayDeque;
import java.util.LinkedList;

/*
 * @lc app=leetcode id=239 lang=java
 *
 * [239] Sliding Window Maximum
 */

// @lc code=start
class Solution {
    /**
     * 暴力法
     * 
     * @param nums
     * @param k
     * @return
     */
    public int[] maxSlidingWindow1(int[] nums, int k) {
        int[] maxArray = new int[nums.length - k + 1];
        for (int i = 0; i <= nums.length - k; ++i) {
            int max = Integer.MIN_VALUE;
            for (int j = i; j < i + k; ++j) {
                max = Math.max(max, nums[j]);
            }
            maxArray[i] = max;
        }
        return maxArray;
    }

    /**
     * 双端队列法
     * 
     * @param nums
     * @param k
     * @return
     */
    public int[] maxSlidingWindow2(int[] nums, int k) {
        int[] maxArray = new int[nums.length - k + 1];
        ArrayDeque<Integer> deque = new ArrayDeque<>();
        for (int i = 0; i < nums.length; ++i) {
            if (!deque.isEmpty() && deque.peekLast() < i - k + 1) {
                deque.removeLast();
            }
            while (!deque.isEmpty() && nums[deque.peekFirst()] < nums[i]) {
                deque.removeFirst();
            }
            deque.addFirst(i);
            if (i >= k - 1) {
                maxArray[i - k + 1] = nums[deque.peekLast()];
            }
        }
        return maxArray;
    }

    /**
     * 暴力法优化 最优解
     * 
     * @param nums
     * @param k
     * @return
     */
    public int[] maxSlidingWindow3(int[] nums, int k) {
        int len = nums.length;
        if (len == 0 || k > len) {
            return new int[0];
        }
        // 定义结果数组
        int[] res = new int[len - k + 1];
        // maxInd记录每次最大值的下标，max记录最大值
        int maxInd = -1, max = Integer.MIN_VALUE;

        for (int i = 0; i < len - k + 1; i++) {
            // 判断最大值下标是否在滑动窗口的范围内
            if (maxInd >= i) {
                // 存在就只需要比较最后面的值是否大于上一个窗口最大值
                if (nums[i + k - 1] > max) {
                    max = nums[i + k - 1];
                    // 更新最大值下标
                    maxInd = i + k - 1;
                }
            }
            // 如果不在就重新寻找当前窗口最大值
            else {
                max = nums[i];
                for (int j = i; j < i + k; j++) {
                    if (max < nums[j]) {
                        max = nums[j];
                        maxInd = j;
                    }
                }
            }
            res[i] = max;
        }
        return res;

    }
}
// @lc code=end
