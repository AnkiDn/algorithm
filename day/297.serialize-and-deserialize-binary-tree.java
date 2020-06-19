/*
 * @lc app=leetcode id=297 lang=java
 *
 * [297] Serialize and Deserialize Binary Tree
 */

// @lc code=start
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {
    private static final String NULL = "null";
    private static final String SEPARATE = ",";
    // int i;
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        serialize(root, sb);
        return sb.toString();
    }

    private void serialize(TreeNode root, StringBuilder sb) {
        if (root == null) {
            sb.append(NULL).append(SEPARATE);
            return;
        }
        sb.append(root.val).append(SEPARATE);
        serialize(root.left, sb);
        serialize(root.right, sb);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] str = data.split(SEPARATE);
        Deque<String> deque = new ArrayDeque<>(str.length);
        deque.addAll(Arrays.asList(str));
        return deserialize(deque);
    }

    private TreeNode deserialize(Deque<String> d) {
        String value = d.pollFirst();
        // String value = str[i++];
        // if (i >= str.length) return null;
        if (value.equals(NULL)) return null;
        TreeNode root = new TreeNode(Integer.valueOf(value));
        root.left = deserialize(d);
        root.right = deserialize(d);
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));
// @lc code=end

