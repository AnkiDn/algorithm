import java.util.HashMap;
import java.util.Map;
/*
 * @lc app=leetcode id=105 lang=java
 *
 * [105] Construct Binary Tree from Preorder and Inorder Traversal
 *
 * https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/description/
 *
 * algorithms
 * Medium (46.65%)
 * Likes:    2885
 * Dislikes: 84
 * Total Accepted:    327.2K
 * Total Submissions: 699K
 * Testcase Example:  '[3,9,20,15,7]\n[9,3,15,20,7]'
 *
 * Given preorder and inorder traversal of a tree, construct the binary tree.
 * 
 * Note:
 * You may assume that duplicates do not exist in the tree.
 * 
 * For example, given
 * 
 * 
 * preorder = [3,9,20,15,7]
 * inorder = [9,3,15,20,7]
 * 
 * Return the following binary tree:
 * 
 * 
 * ⁠   3
 * ⁠  / \
 * ⁠ 9  20
 * ⁠   /  \
 * ⁠  15   7
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
    int pre_idx = 0;
    int[] prepreorder, inorder;
    Map<Integer, Integer> idx_map = new HashMap<>();
    public TreeNode buildTree1(int[] preorder, int[] inorder) {
        if (preorder == null || inorder == null || preorder.length != inorder.length) return null;
        this.prepreorder = preorder;
        this.inorder = inorder;
        for (int i = 0; i < inorder.length; ++i) {
            idx_map.put(inorder[i], i);
        }
        return buildTree(0, preorder.length);
    }

    private TreeNode buildTree(int left, int right) {
        if (left > right) {
            return null;
        }
        int node_val = prepreorder[pre_idx];
        ++pre_idx;
        TreeNode node = new TreeNode(node_val);
        int index = idx_map.get(node_val);
        node.left = buildTree(left, index);
        node.right = buildTree(index + 1, right);
        return node;
    }

    public TreeNode buildTree2(int[] preorder, int[] inorder) {
        if (preorder.length == 0) return null;
        
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        
        Stack<TreeNode> stack = new Stack<>();
        int value = preorder[0];
        TreeNode root = new TreeNode(value);
        stack.push(root);
        
        // 迭代 从1开始
        for (int i = 1; i < preorder.length; i ++) {
            value = preorder[i];
            TreeNode node = new TreeNode(value);
            
            if (map.get(value) < map.get(stack.peek().val)) {
                //因为是前序遍历所以这个节点肯定是左节点
                stack.peek().left = node;
            } else {
                //节点肯定在右侧，可能是最底层的右节点，也可能是祖先的右节点，
                //不断出栈，直到找到这个的父节点。
                TreeNode parent = null;
                while(!stack.isEmpty() && map.get(value) > map.get(stack.peek().val)) {
                    parent = stack.pop();
                }
                parent.right = node;
            }
            stack.push(node);
        }
        
        return root;
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

