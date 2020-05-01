import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

/*
 * @lc app=leetcode id=297 lang=java
 *
 * [297] Serialize and Deserialize Binary Tree
 *
 * https://leetcode.com/problems/serialize-and-deserialize-binary-tree/description/
 *
 * algorithms
 * Hard (45.80%)
 * Likes:    2648
 * Dislikes: 131
 * Total Accepted:    293K
 * Total Submissions: 637.9K
 * Testcase Example:  '[1,2,3,null,null,4,5]'
 *
 * Serialization is the process of converting a data structure or object into a
 * sequence of bits so that it can be stored in a file or memory buffer, or
 * transmitted across a network connection link to be reconstructed later in
 * the same or another computer environment.
 * 
 * Design an algorithm to serialize and deserialize a binary tree. There is no
 * restriction on how your serialization/deserialization algorithm should work.
 * You just need to ensure that a binary tree can be serialized to a string and
 * this string can be deserialized to the original tree structure.
 * 
 * Example: 
 * 
 * 
 * You may serialize the following tree:
 * 
 * ⁠   1
 * ⁠  / \
 * ⁠ 2   3
 * ⁠    / \
 * ⁠   4   5
 * 
 * as "[1,2,3,null,null,4,5]"
 * 
 * 
 * Clarification: The above format is the same as how LeetCode serializes a
 * binary tree. You do not necessarily need to follow this format, so please be
 * creative and come up with different approaches yourself.
 * 
 * Note: Do not use class member/global/static variables to store states. Your
 * serialize and deserialize algorithms should be stateless.
 * 
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
    private final static String SPLITER = ",";
    private final static String N = "null";

    // Encodes a tree to a single string.
    /**
     * 前序遍历 可以还原二叉树
     */
    public String serialize1(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        toSerialize(root , sb);
        return sb.toString();
    }

    private void toSerialize1(TreeNode node, StringBuilder builder) {
        if (node == null) {
            builder.append(N).append(SPLITER);
            return;
        }
        builder.append(node.val).append(SPLITER);
        toSerialize(node.left, builder);
        toSerialize(node.right, builder);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize1(String data) {
        Deque<String> deque = new LinkedList<>();
        deque.addAll(Arrays.asList(data.split(SPLITER)));
        return toDeserialize(deque);
    }

    private TreeNode toDeserialize1(Deque<String> deque) {
        String val = deque.remove();
        if (N.equals(val)) {
            return null;
        }
        TreeNode node = new TreeNode(Integer.valueOf(val));
        node.left = toDeserialize(deque);
        node.right = toDeserialize(deque);
        return node;
    }

    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        toSerialize(root , sb);
        return sb.toString();
    }

    private void toSerialize(TreeNode node, StringBuilder builder) {
        if (node == null) {
            builder.append(N).append(SPLITER);
            return;
        }
        builder.append(node.val).append(SPLITER);
        toSerialize(node.left, builder);
        toSerialize(node.right, builder);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        Deque<String> deque = new LinkedList<>();
        deque.addAll(Arrays.asList(data.split(SPLITER)));
        return toDeserialize(deque);
    }

    private TreeNode toDeserialize(Deque<String> deque) {
        String val = deque.remove();
        if (N.equals(val)) {
            return null;
        }
        TreeNode node = new TreeNode(Integer.valueOf(val));
        node.left = toDeserialize(deque);
        node.right = toDeserialize(deque);
        return node;
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}
// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));
// @lc code=end

