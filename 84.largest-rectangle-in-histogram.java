import java.util.Stack;

/*
 * @lc app=leetcode id=84 lang=java
 *
 * [84] Largest Rectangle in Histogram
 */

// @lc code=start
class Solution {
    /**
     * 暴力法
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
     * 辅助栈法
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
}
// @lc code=end
