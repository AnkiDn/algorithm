import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/*
 * @lc app=leetcode id=515 lang=java
 *
 * [515] Find Largest Value in Each Tree Row
 *
 * https://leetcode.com/problems/find-largest-value-in-each-tree-row/description/
 *
 * algorithms
 * Medium (60.01%)
 * Likes:    741
 * Dislikes: 57
 * Total Accepted:    89.8K
 * Total Submissions: 149.1K
 * Testcase Example:  '[1,3,2,5,3,null,9]'
 *
 * You need to find the largest value in each row of a binary tree.
 * 
 * Example:
 * 
 * Input: 
 * 
 * ⁠         1
 * ⁠        / \
 * ⁠       3   2
 * ⁠      / \   \  
 * ⁠     5   3   9 
 * 
 * Output: [1, 3, 9]
 * 
 * 
 * 
 */

// @lc code=start
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    /**
     * bfs
     */
    public List<Integer> largestValues(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        if (root == null) return ans;
        LinkedList<TreeNode> deque = new LinkedList<>();
        deque.addFirst(root);
        while (!deque.isEmpty()) {
            int size = deque.size();
            int max = Integer.MIN_VALUE;
            for (int i = 0; i < size; ++i) {
                TreeNode node = deque.removeLast();
                max = Math.max(max, node.val);
                if (node.left != null) deque.addFirst(node.left);
                if (node.right != null) deque.addFirst(node.right);
            }
            ans.add(max);
        }
        return ans;
    }

    /**
     * dfs
     */
    public List<Integer> largestValues2(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        if (root == null) return ans;
        dfs(0, root, ans);
        return ans;
    }

    private void dfs (int level, TreeNode node, List<Integer> ans) {
        if (level >= ans.size()) {
            ans.add(node.val);
        }
        ans.set(level, Math.max(ans.get(level), node.val));
        if (node.left != null) dfs(level + 1, node.left, ans);
        if (node.right != null) dfs(level + 1, node.right, ans);
    }
}

public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
// @lc code=end

