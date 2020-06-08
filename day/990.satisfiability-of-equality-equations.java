/*
 * @lc app=leetcode id=990 lang=java
 *
 * [990] Satisfiability of Equality Equations
 *
 * https://leetcode.com/problems/satisfiability-of-equality-equations/description/
 *
 * algorithms
 * Medium (43.70%)
 * Likes:    426
 * Dislikes: 4
 * Total Accepted:    16.7K
 * Total Submissions: 38.1K
 * Testcase Example:  '["a==b","b!=a"]'
 *
 * Given an array equations of strings that represent relationships between
 * variables, each string equations[i] has length 4 and takes one of two
 * different forms: "a==b" or "a!=b".  Here, a and b are lowercase letters (not
 * necessarily different) that represent one-letter variable names.
 * 
 * Return true if and only if it is possible to assign integers to variable
 * names so as to satisfy all the given equations.
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: ["a==b","b!=a"]
 * Output: false
 * Explanation: If we assign say, a = 1 and b = 1, then the first equation is
 * satisfied, but not the second.  There is no way to assign the variables to
 * satisfy both equations.
 * 
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: ["b==a","a==b"]
 * Output: true
 * Explanation: We could assign a = 1 and b = 1 to satisfy both equations.
 * 
 * 
 * 
 * Example 3:
 * 
 * 
 * Input: ["a==b","b==c","a==c"]
 * Output: true
 * 
 * 
 * 
 * Example 4:
 * 
 * 
 * Input: ["a==b","b!=c","c==a"]
 * Output: false
 * 
 * 
 * 
 * Example 5:
 * 
 * 
 * Input: ["c==c","b==d","x!=z"]
 * Output: true
 * 
 * 
 * 
 * 
 * Note:
 * 
 * 
 * 1 <= equations.length <= 500
 * equations[i].length == 4
 * equations[i][0] and equations[i][3] are lowercase letters
 * equations[i][1] is either '=' or '!'
 * equations[i][2] is '='
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 */

// @lc code=start
class Solution {
    private UnionFind uf;
    public boolean equationsPossible(String[] equations) {
        uf = new UnionFind();
        for (String s : equations) {
            if (s.charAt(1) == '=') {
                uf.union(s.charAt(0) - 'a', s.charAt(3) - 'a');
            }
        }
        for (String s: equations) {
            if (s.charAt(1) == '!') {
                if (uf.connected(s.charAt(0) - 'a', s.charAt(3) - 'a')) return false;
            }
        }
        return true;
    }
}

class UnionFind {
    int[] parent;

    public UnionFind() {
        parent = new int[26];
        for (int i = 0; i < 26; ++i) {
            parent[i] = i;
        }
    }

    public int find(int i) {
        while (parent[i] != i) {
            parent[i] = find(parent[i]);
            i = parent[i];
        }
        return i;
    }

    public boolean connected(int i, int j) {
        return find(i) == find(j);
    }

    public void union(int i, int j) {
        int rootI = find(i);
        int rootJ = find(j);
        parent[rootI] = rootJ;
    }
}
// @lc code=end

