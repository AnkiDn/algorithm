/*
 * @lc app=leetcode id=212 lang=java
 *
 * [212] Word Search II
 *
 * https://leetcode.com/problems/word-search-ii/description/
 *
 * algorithms
 * Hard (32.64%)
 * Likes:    2145
 * Dislikes: 98
 * Total Accepted:    186.2K
 * Total Submissions: 562.3K
 * Testcase Example:  '[["o","a","a","n"],["e","t","a","e"],["i","h","k","r"],["i","f","l","v"]]\n["oath","pea","eat","rain"]'
 *
 * Given a 2D board and a list of words from the dictionary, find all words in
 * the board.
 * 
 * Each word must be constructed from letters of sequentially adjacent cell,
 * where "adjacent" cells are those horizontally or vertically neighboring. The
 * same letter cell may not be used more than once in a word.
 * 
 * 
 * 
 * Example:
 * 
 * 
 * Input: 
 * board = [
 * ⁠ ['o','a','a','n'],
 * ⁠ ['e','t','a','e'],
 * ⁠ ['i','h','k','r'],
 * ⁠ ['i','f','l','v']
 * ]
 * words = ["oath","pea","eat","rain"]
 * 
 * Output: ["eat","oath"]
 * 
 * 
 * 
 * 
 * Note:
 * 
 * 
 * All inputs are consist of lowercase letters a-z.
 * The values of words are distinct.
 * 
 * 
 */

// @lc code=start
class Solution {
    Set<String> ans = new HashSet<>();
    char[][] board;
    int row, col;
    int[][] vectors = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    /**
     * trie
     */
    public List<String> findWords(char[][] board, String[] words) {
        row = board.length;
        col = board[0].length;
        this.board = board;
        TrieTree root = new TrieTree();
        for(String str : words) root.insert(str);
        for (int i = 0; i < row; ++i) {
            for (int j = 0; j < col; ++j) {
                dfs(i, j, root);
            }
        }
        return new ArrayList<String>(ans);
    }

    public void dfs(int x, int y, TrieTree root) {
        char c = board[x][y];
        if (c == '#' || root.tt[c - 'a'] == null ) return;
        TrieTree next = root.tt[c - 'a'];
        if (next.word != null) {
            ans.add(next.word);
            next.word = null;
        }
        board[x][y] = '#';
        for (int i = 0; i < vectors.length; ++i) {
            int newX = x + vectors[i][0];
            int newY = y + vectors[i][1];
            if (!isValid(newX, newY)) continue;
            dfs(newX, newY, next);
        }
        board[x][y] = c;
    }

    class TrieTree {
        TrieTree[] tt;
        String word;
    
        public TrieTree() {
            this.tt = new TrieTree[26];
        }
    
        public void insert(String word) {
            TrieTree root = this;
            for (char c : word.toCharArray()) {
                if (root.tt[c - 'a'] == null) {
                    root.tt[c - 'a'] = new TrieTree();
                }
                root = root.tt[c - 'a'];
            }
            root.word = word;
        }
    
        public String find(String word) {
            TrieTree root = this;
            for (char c : word.toCharArray()) {
                if (root.tt[c - 'a'] == null) {
                    return null;
                }
                root = root.tt[c - 'a'];
            }
            return root.word;
        }
    }

    int[][] vectors = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    int row, col;
    char[][] board;
    boolean[][] visited;
    /**
     * DFS
     */
    public List<String> findWords3(char[][] board, String[] words) {
        this.board = board;
        row = board.length;
        col = board[0].length;
        List<String> ans = new ArrayList<>();
        for (String str : words) {
            visited = new boolean[row][col];
            for (int i = 0; i < row; ++i) {
                for (int j = 0; j < col; ++j) {
                    if (board[i][j] != str.charAt(0)) continue;
                    if (dfs(i, j, str.toCharArray(), 0)) {
                        ans.add(str);
                        i = row;
                        break;
                    }
                }
            }
        }
        return ans;
    }

    public boolean dfs (int x, int y, char[] chars, int start) {
        if (visited[x][y]) return false;
        if (start == chars.length - 1) {
            return chars[start] == board[x][y];
        }
        if (board[x][y] == chars[start]) {
            visited[x][y] = true;
            for (int i = 0; i < vectors.length; ++i) {
                int newX = x + vectors[i][0];
                int newY = y + vectors[i][1];
                if (!isValid(newX, newY)) continue;
                if (dfs(newX, newY, chars, start + 1)) {
                    return true;
                }
            }
            visited[x][y] = false;
        }
        return false;
    }

    public boolean isValid(int x, int y) {
        return (x >= 0 && y >= 0 && x < row && y < col);
    }
}
// @lc code=end

