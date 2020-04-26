import java.util.Arrays;

/*
 * @lc app=leetcode id=42 lang=java
 *
 * [42] Trapping Rain Water
 */

// @lc code=start
class Solution {
    /**
     * TODO：未优化版
     * 先遍历找到最大高度， 然后分别从左和从右遍历，终止条件是遇到最大高度的下标。
     * 拿从左遍历举例：
     * 确定左边界，然后遍历
     * 比左边界小，就累加起面积；
     * 比左边界大就计算两者间的面积，并减去之前累加的面积就得出两者之前水的面积。
     * 然后将大的高度作为新的左边界，直到遇到最大高度。
     * 从右遍历同理。
     * @param height
     * @return
     */
    public int trap1(int[] height) {
        if (height.length == 0) return 0;
        int sum = 0;
        int temp = 0;
        int left = 0;
        int leftHeight = 0;
        int right = height.length - 1;
        int rightHeight = 0;
        int maxHeightIndex = 0;
        int maxHeight = 0;
        for (int i = 0; i < height.length; ++i) {
            if (height[i] > maxHeight){
                maxHeightIndex = i;
                maxHeight = height[i];
            } 
        }
        for (int i = 0; i <= maxHeightIndex; ++i) {
            if (height[i] >= leftHeight) {
                sum += (i - left - 1) * leftHeight - temp;
                left = i;
                leftHeight = height[i];
                temp = 0;
            } else {
                temp += height[i];
            }
        }
        for (int i = height.length - 1; i >= maxHeightIndex; --i) {
            if (height[i] >= rightHeight) {
                sum += (right - i - 1) * rightHeight - temp;
                right = i;
                rightHeight = height[i];
                temp = 0;
            } else {
                temp += height[i];
            }
        }
        return sum;
    }

    /**
     * 找出每列上方的水，累加。
     * @param height
     * @return
     */
    public int trap2(int[] height) {
        int sum = 0;
        //最两端的列不用考虑，因为一定不会有水。所以下标从 1 到 length - 2
        for (int i = 1; i < height.length - 1; i++) {
            int max_left = 0;
            //找出左边最高
            for (int j = i - 1; j >= 0; j--) {
                if (height[j] > max_left) {
                    max_left = height[j];
                }
            }
            int max_right = 0;
            //找出右边最高
            for (int j = i + 1; j < height.length; j++) {
                if (height[j] > max_right) {
                    max_right = height[j];
                }
            }
            //找出两端较小的
            int min = Math.min(max_left, max_right);
            //只有较小的一段大于当前列的高度才会有水，其他情况不会有水
            if (min > height[i]) {
                sum = sum + (min - height[i]);
            }
        }
        return sum;
    }

    /**
     * 动态规划
     * 对按列求的优化，把每列左端和右端的最大值分别存起来
     * @param height
     * @return
     */
    public int trap3(int[] height) {
        int sum = 0;
        int[] max_left = new int[height.length];
        int[] max_right = new int[height.length];
        
        for (int i = 1; i < height.length - 1; i++) {
            max_left[i] = Math.max(max_left[i - 1], height[i - 1]);
        }
        for (int i = height.length - 2; i >= 0; i--) {
            max_right[i] = Math.max(max_right[i + 1], height[i + 1]);
        }
        for (int i = 1; i < height.length - 1; i++) {
            int min = Math.min(max_left[i], max_right[i]);
            if (min > height[i]) {
                sum = sum + (min - height[i]);
            }
        }
        return sum;
    }

    /**
     * 双指针法，对上面的优化，也是算每一列上的水
     * 分别从左和从右遍历,那么从左遍历的左边最大值是确定的，同理如果从右遍历的最大值也确定
     * 左指针小于右指针的时候，就算左指针的，如果左边的最大值 > 左指针 那说明左指针上🈶️水，反之没有。
     * 右指针小于左指针的时候，同理。
     * @param height
     * @return
     */
    public int trap4(int[] height) {
        int sum = 0;
        int max_left = 0;
        int max_right = 0;
        int left = 0; 
        int right = height.length - 1;
        while(left < right) {
            //从左到右遍历
            if (height[left] < height[right]) {
                max_left = Math.max(max_left, height[left]);
                if (max_left > height[left]) {
                    sum += max_left - height[left];
                }
                ++left;
            //从右到左遍历
            } else {
                max_right = Math.max(max_right, height[right]);
                if (max_right > height[right]) {
                    sum += max_right - height[right];
                }
                --right;
            }
        }
        return sum;
    }

    /**
     * 使用栈
     * @param height
     * @return
     */
    public int trap6(int[] height) {
        int sum = 0;
        Stack<Integer> stack = new Stack<>();
        int current = 0;
        while (current < height.length) {
            //如果栈不空并且当前指向的高度大于栈顶高度就一直循环
            while (!stack.empty() && height[current] > height[stack.peek()]) {
                int h = height[stack.peek()]; //取出要出栈的元素
                stack.pop(); //出栈
                if (stack.empty()) { // 栈空就出去
                    break; 
                }
                int distance = current - stack.peek() - 1; //两堵墙之前的距离。
                int min = Math.min(height[stack.peek()], height[current]);
                sum = sum + distance * (min - h);
            }
            stack.push(current); //当前指向的墙入栈
            current++; //指针后移
        }
        return sum;
    }
}
// @lc code=end
