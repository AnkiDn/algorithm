import java.util.Stack;

/*
 * @lc app=leetcode id=84 lang=java
 *
 * [84] Largest Rectangle in Histogram
 */

// @lc code=start
class Solution {
    /**
     * 暴力法 超时
     * 
     * @param heights
     * @return
     */
    public int largestRectangleArea1(int[] heights) {
        int max = 0;
        for (int i = 0; i < heights.length; ++i) {
            for (int j = i; j < heights.length; ++j) {
                int minHeight = Integer.MAX_VALUE;
                for (int k = i; k <= j; ++k) {
                    minHeight = Math.min(minHeight, heights[k]);
                }
                max = Math.max(max, minHeight * (j - i + 1));
            }
        }
        return max;
    }

    /**
     * 暴力法优化 
     */
    public int largestRectangleArea4(int[] heights) {
        int max = 0;
        for (int i = 0; i < heights.length; ++i) {
            int left = i, right = i;
            while (left > 0) {
                --left;
                if (heights[left] < heights[i]) {
                    ++left;
                    break;
                }
            }
            while (right < heights.length - 1) {
                ++right;
                if (heights[right] < heights[i]) {
                    --right;
                    break;
                }
            }
            max = Math.max(max, (right - left + 1) * heights[i]);
        }
        return max;
    }

    /**
     * 辅助栈法，可以优化掉额外掉Rect类
     * 
     * @param heights
     * @return
     */
    public int largestRectangleArea2(int[] heights) {
        int max = 0;
        Stack<Rect> stack = new Stack<>();
        stack.push(new Rect(-1, -1));
        for (int i = 0; i < heights.length; ++i) {
            while (stack.peek().height >= heights[i]){
                max = Math.max(max, stack.pop().height * (i - stack.peek().position - 1));
            }
            stack.push(new Rect(i, heights[i]));
            // if (heights[i] >= stack.peek().height) {
            //     stack.push(new Rect(i, heights[i]));
            // } else {
            //     max = Math.max(max, stack.pop().height * (i - stack.peek().position - 1));
            // }
        }
        while (stack.size() > 1) {
            Rect rect = stack.pop();
            max = Math.max(max, rect.height * (heights.length - stack.peek().position - 1));
        }
        return max;
    }

    class Rect {
        int position = 0;
        int height = 0;

        public Rect(int position, int height){
            this.position = position;
            this.height = height;
        };
    }

    /**
     * 辅助栈2
     * @param heights
     * @return
     */
    public int largestRectangleArea3(int[] heights) {
        int len = heights.length;
        int maxArea = 0;
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i <= len;) {
            int h = (i == len ? 0 : heights[i]);
            if (stack.isEmpty() || h >= heights[stack.peek()]) {
                stack.push(i);
                i++;
            }else {
                int curHeight = heights[stack.pop()];
                int rightBoundary = i - 1;
                int leftBoundary = stack.isEmpty() ? 0 : stack.peek() + 1;
                int width = rightBoundary - leftBoundary + 1;
                maxArea = Math.max(maxArea, (curHeight * width));
            }
        }
        return maxArea;
    }
}
// @lc code=end
