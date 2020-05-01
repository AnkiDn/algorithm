import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/*
 * @lc app=leetcode id=429 lang=java
 *
 * [429] N-ary Tree Level Order Traversal
 *
 * https://leetcode.com/problems/n-ary-tree-level-order-traversal/description/
 *
 * algorithms
 * Medium (63.24%)
 * Likes:    477
 * Dislikes: 42
 * Total Accepted:    66.2K
 * Total Submissions: 104.5K
 * Testcase Example:  '[1,null,3,2,4,null,5,6]'
 *
 * Given an n-ary tree, return the level order traversal of its nodes' values.
 * 
 * Nary-Tree input serialization is represented in their level order traversal,
 * each group of children is separated by the null value (See examples).
 * 
 * 
 * Example 1:
 * 
 * 
 * 
 * 
 * Input: root = [1,null,3,2,4,null,5,6]
 * Output: [[1],[3,2,4],[5,6]]
 * 
 * 
 * Example 2:
 * 
 * 
 * 
 * 
 * Input: root =
 * [1,null,2,3,4,5,null,null,6,7,null,8,null,9,10,null,null,11,null,12,null,13,null,null,14]
 * Output: [[1],[2,3,4,5],[6,7,8,9,10],[11,12,13],[14]]
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * The height of the n-ary tree is less than or equal to 1000
 * The total number of nodes is between [0, 10^4]
 * 
 * 
 */

// @lc code=start
/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

class Solution {
    /**
     * 递归
     * @param root
     * @return
     */
    public List<List<Integer>> levelOrder1(Node root) {
        List<List<Integer>> result = new ArrayList<>();
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        recur (0, root, map, result);
        return result;
    }

    private void recur (int level, Node node, HashMap<Integer, List<Integer>> map, List<List<Integer>> result) {
        if (node == null) {
            return;
        }
        List<Integer> list = map.get(level);
        if (list == null) {
            list = new ArrayList<>();
            map.put(level, list);
            result.add(list);
        }
        list.add(node.val);
        ++level;
        for (Node child : node.children) {
            recur(level, child, map, result);
        }
    }

    /**
     * BFS
     * 用一个列表存放节点值，队列存放节点。首先将根节点放到队列中，
     * 当队列不为空时，则在队列取出一个节点，并将其子节点添加到队列中。
     * 再构造下一层的列表时,我们需要创建新的子列表,
     * 然后将该层的所有节点的值插入到列表中 
     * 一个很好的方法时在 while 循环体开始时记录队列的当前大小 size 
     * 然后用另一个循环来处理 size 数量的节点 
     * 这样可以保证 while 循环在每一次迭代处理一层
     * @param root
     * @return
     */
    public List<List<Integer>> levelOrder2(Node root) {      
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) return result;
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            List<Integer> level = new ArrayList<>();
            int size = queue.size(); //每一层的size
            for (int i = 0; i < size; i++) {
                Node node = queue.poll();
                level.add(node.val);
                queue.addAll(node.children);
            }
            result.add(level);
        }
        return result;
    }
}

class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
// @lc code=end

