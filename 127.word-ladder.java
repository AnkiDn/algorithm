import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

/*
 * @lc app=leetcode id=127 lang=java
 *
 * [127] Word Ladder
 *
 * https://leetcode.com/problems/word-ladder/description/
 *
 * algorithms
 * Medium (28.20%)
 * Likes:    2735
 * Dislikes: 1081
 * Total Accepted:    391.9K
 * Total Submissions: 1.4M
 * Testcase Example:  '"hit"\n"cog"\n["hot","dot","dog","lot","log","cog"]'
 *
 * Given two words (beginWord and endWord), and a dictionary's word list, find
 * the length of shortest transformation sequence from beginWord to endWord,
 * such that:
 * 
 * 
 * Only one letter can be changed at a time.
 * Each transformed word must exist in the word list.
 * 
 * 
 * Note:
 * 
 * 
 * Return 0 if there is no such transformation sequence.
 * All words have the same length.
 * All words contain only lowercase alphabetic characters.
 * You may assume no duplicates in the word list.
 * You may assume beginWord and endWord are non-empty and are not the same.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input:
 * beginWord = "hit",
 * endWord = "cog",
 * wordList = ["hot","dot","dog","lot","log","cog"]
 * 
 * Output: 5
 * 
 * Explanation: As one shortest transformation is "hit" -> "hot" -> "dot" ->
 * "dog" -> "cog",
 * return its length 5.
 * 
 * 
 * Example 2:
 * 
 * 
 * Input:
 * beginWord = "hit"
 * endWord = "cog"
 * wordList = ["hot","dot","dog","lot","log"]
 * 
 * Output: 0
 * 
 * Explanation: The endWord "cog" is not in wordList, therefore no possible
 * transformation.
 * 
 * 
 * 
 * 
 * 
 */

// @lc code=start
class Solution {
    /**
     * dfs 超时
     */
    int ans = Integer.MAX_VALUE;
    boolean[] wordSet;
    public int ladderLength_dfs(String beginWord, String endWord, List<String> wordList) {
        wordSet = new boolean[wordList.size()];
        dfs(1, beginWord, endWord, wordList);
        if (ans == Integer.MAX_VALUE) ans = 0;
        return ans;
    }

    private void dfs(int steps, String beginWord, String endWord, List<String> wordList) {
        if (steps >= ans) return;
        if (beginWord.equals(endWord)) {
            ans = steps;
        }
        for (int i = 0; i < wordList.size(); ++i) {
            int dif = 0;
            if (wordSet[i] == true) continue;
            String currentSelect = wordList.get(i);
            for (int j = 0; j < beginWord.length(); ++j) {
                if (beginWord.charAt(j) != currentSelect.charAt(j)) ++dif;
                if (dif > 1) break;
            }
            if (dif == 1 && !wordSet[i]) {
                wordSet[i] = true;
                dfs(steps + 1, currentSelect, endWord, wordList);
                wordSet[i] = false;
            }
        }
    }

    /**
     * bfs 单队列
     * @param beginWord
     * @param endWord
     * @param wordList
     * @return
     */
    public int ladderLength1(String beginWord, String endWord, List<String> wordList) {
        int result = 0;
        boolean[] wordVisited = new boolean[wordList.size()];
        Queue<String> queuq = new LinkedList<>();
        queuq.add(beginWord);
        while (!queuq.isEmpty()) {
            int size = queuq.size();
            ++result;
            for (int i = 0; i < size; ++i) {
                String word = queuq.poll();
                for (int j = 0; j < wordList.size(); ++j) {
                    if (wordVisited[j]) continue;
                    if (!canChange(word, wordList.get(j))) continue;
                    if (wordList.get(j).contains(endWord)) {
                        return result + 1;
                    }
                    wordVisited[j] = true;
                    queuq.add(wordList.get(j));
                }
            }
        }
        return 0;
    }

    /**
     * bfs 双队列
     * @param beginWord
     * @param endWord
     * @param wordList
     * @return
     */
    public int ladderLength2(String beginWord, String endWord, List<String> wordList) {
        if (!wordList.contains(endWord)) return 0;
        int result = 0;
        boolean[] wordVisited1 = new boolean[wordList.size()];
        boolean[] wordVisited2 = new boolean[wordList.size()];
        Queue<String> queuq1 = new LinkedList<>();
        Queue<String> queuq2 = new LinkedList<>();
        queuq1.add(beginWord);
        queuq2.add(endWord);
        //防止多加i次 如start = ‘a'; end = 'b'; words = [a, b ,c];
        //不把end加入会多加一次
        wordVisited2[wordList.indexOf(endWord)] = true;
        while (!queuq1.isEmpty() && !queuq2.isEmpty()) {
            //查链条短的 快些
            if (queuq1.size() > queuq2.size()) {
                Queue<String> tempQ = queuq1;
                queuq1 = queuq2;
                queuq2 = tempQ;
                boolean[] temp = wordVisited1;
                wordVisited1 = wordVisited2;
                wordVisited2 = temp;
            }
            int size = queuq1.size();
            ++result;
            for (int i = 0; i < size; ++i) {
                String word = queuq1.poll();
                for (int j = 0; j < wordList.size(); ++j) {
                    if (wordVisited1[j]) continue;
                    if (!canChange(word, wordList.get(j))) continue;
                    if (wordVisited2[j]) {
                        return result + 1;
                    }
                    wordVisited1[j] = true;
                    queuq1.add(wordList.get(j));
                }
            }
        }
        return 0;
    }

    /**
     * bfs 双队列 canChang方法优化
     */
    public int ladderLength3(String beginWord, String endWord, List<String> wordList) {
        if (!wordList.contains(endWord)) return 0;
        int result = 0;
        Set<String> wordVisited1 = new HashSet<>();
        Set<String> wordVisited2 = new HashSet<>();
        Queue<String> queuq1 = new LinkedList<>();
        Queue<String> queuq2 = new LinkedList<>();
        queuq1.add(beginWord);
        queuq2.add(endWord);
        //防止多加i次 如start = ‘a'; end = 'b'; words = [a, b ,c];
        //不把end加入会多加一次
        wordVisited2.add(endWord);
        //加速查询
        Set<String> allWordSet = new HashSet<>(wordList);
        while (!queuq1.isEmpty() && !queuq2.isEmpty()) {
            if (queuq1.size() > queuq2.size()) {
                Queue<String> tempQ = queuq1;
                queuq1 = queuq2;
                queuq2 = tempQ;
                Set<String> temp = wordVisited1;
                wordVisited1 = wordVisited2;
                wordVisited2 = temp;
            }
            int size = queuq1.size();
            ++result;
            for (int i = 0; i < size; ++i) {
                String word = queuq1.poll();
                char[] wordChar = word.toCharArray();
                for (int j = 0; j < wordChar.length; ++j) {
                    char tempChar = wordChar[j];
                    for (char c = 'a'; c <= 'z'; ++c) {
                        wordChar[j] = c;
                        String tempString = new String(wordChar);
                        if (wordVisited1.contains(tempString)) continue;
                        if (wordVisited2.contains(tempString)) {
                            return result + 1;
                        }
                        if (allWordSet.contains(tempString)) {
                            queuq1.add(tempString);
                            wordVisited1.add(tempString);
                        }
                    }
                    wordChar[j] = tempChar;
                }
            }
        }
        return 0;
    }


    private boolean canChange (String s1, String s2) {
        int dif = 0;
        for (int i = 0; i < s1.length(); ++i) {
            if (s1.charAt(i) != s2.charAt(i)) {
                ++dif;
            }
            if (dif > 1) return false;
        }
        return dif == 1;
    }
}
// @lc code=end

