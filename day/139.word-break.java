/*
 * @lc app=leetcode id=139 lang=java
 *
 * [139] Word Break
 */

// @lc code=start
class Solution {
    /**
     * dfs
     * 符合条件的不用管，主要就是不符合条件的要能迅速的剔除
       所以此备忘录 记录的是不符合条件的
     */
    private boolean[] visited;
    public boolean wordBreak(String s, List<String> wordDict) {
        if (s == null) return false;
        visited = new boolean[s.length()];
        return dfs(s, new HashSet<String>(wordDict), 0);
    }

    private boolean dfs(String s, Set<String> wordDict, int start) {
        if (start >= s.length()) return true;
        if (visited[start]) return false;
        for (int i = start; i <= s.length(); ++i) {
            if (!wordDict.contains(s.substring(start, i))) continue;
            if (dfs(s, wordDict, i)) return true;
        }
        visited[start] = true;
        return false;
    } 

    /**
     * dfs优化
     */
    private boolean[] visited;
    public boolean wordBreak(String s, List<String> wordDict) {
        if (s == null) return false;
        visited = new boolean[s.length()];
        return dfs(s, wordDict, 0);
    }

    private boolean dfs(String s, List<String> wordDict, int start) {
        if (start >= s.length()) return true;
        if (visited[start]) return false;
        for (String word : wordDict) {
            int len = word.length();
            if (start + len > s.length()) continue;
            if (!word.equals(s.substring(start, start + len))) continue;
            if (dfs(s, wordDict, start + len)) return true;
        }
        visited[start] = true;
        return false;
    } 

    /**
     * dp
     * @param s
     * @param wordDict
     * @return
     */
    public boolean wordBreak3(String s, List<String> wordDict) {
        Set<String> set = new HashSet(wordDict);
        int len = s.length();
        boolean[] dp = new boolean[len + 1];
        dp[0] = true;
        for (int i = 1; i <= len; ++i) {
            for (int j = 0; j < i; ++j) {
                if (dp[j] && set.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[len];
    }

    /**
     * dp优化
     * @param s
     * @param wordDict
     * @return
     */
    public boolean wordBreak4(String s, List<String> wordDict) {
        Set<String> set = new HashSet(wordDict);
        int len = s.length();
        boolean[] dp = new boolean[len + 1];
        dp[0] = true;
        for (int i = 1; i <= len; ++i) {
            for (String word : wordDict) {
                int n = word.length();
                if (n > i) continue;
                if (dp[i - n] && word.equals(s.substring(i - n, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[len];
    }

}
// @lc code=end

