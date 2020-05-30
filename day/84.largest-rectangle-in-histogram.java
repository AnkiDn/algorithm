/*
 * @lc app=leetcode id=84 lang=java
 *
 * [84] Largest Rectangle in Histogram
 *
 * https://leetcode.com/problems/largest-rectangle-in-histogram/description/
 *
 * algorithms
 * Hard (33.88%)
 * Likes:    3093
 * Dislikes: 77
 * Total Accepted:    237.2K
 * Total Submissions: 699.9K
 * Testcase Example:  '[2,1,5,6,2,3]'
 *
 * Given n non-negative integers representing the histogram's bar height where
 * the width of each bar is 1, find the area of largest rectangle in the
 * histogram.
 * 
 * 
 * 
 * 
 * Above is a histogram where width of each bar is 1, given height =
 * [2,1,5,6,2,3].
 * 
 * 
 * 
 * 
 * The largest rectangle is shown in the shaded area, which has area = 10
 * unit.
 * 
 * 
 * 
 * Example:
 * 
 * 
 * Input: [2,1,5,6,2,3]
 * Output: 10
 * 
 * 
 */

// @lc code=start
class Solution {
    public int largestRectangleArea(int[] heights) {
        int ans = 0;
        int n = heights.length;
        LinkedList<Integer> stack = new LinkedList<>();
        stack.offerLast(-1);
        for (int i = 0; i < n; ++i) {
            while (stack.size() != 1 && heights[i] < heights[stack.peekLast()]) {
                int height = heights[stack.pollLast()];
                ans = Math.max(ans, height * (i - stack.peekLast() - 1));
                // System.out.println(String.format("height: %s, left: %s, right: %s, ans: %s", height, stack.peekLast(), i, ans));
            }
            stack.offerLast(i);
        }
        while(stack.size() != 1) {
            int height = heights[stack.pollLast()];
            ans = Math.max(ans, height * (n - stack.peekLast() - 1));
            // System.out.println(String.format("height: %s, left: %s, right: %s, ans: %s", height, stack.peekLast(), n, ans));
        }
        return ans;
    }
}
// @lc code=end

