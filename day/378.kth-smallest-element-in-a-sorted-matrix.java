/*
 * @lc app=leetcode id=378 lang=java
 *
 * [378] Kth Smallest Element in a Sorted Matrix
 */

// @lc code=start
class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        int n = matrix.length, left = matrix[0][0], right = matrix[n - 1][n - 1];
        while (left < right) {
            int mid = left + right >>> 1;
            if (check(matrix, mid, k)) right = mid;
            else left = mid + 1;
        }
        return left;
    }

    private boolean check(int[][] nums, int mid, int k) {
        int n = nums.length, i = 0, j = n - 1;
        int count = 0;
        while (i < n && j >= 0) {
            if (nums[i][j] <= mid) {
                count += j + 1;
                i++;
            } else {
                j--;
            }
        }
        return count >= k;
    }
}
// @lc code=end

