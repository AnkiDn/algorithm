/*
 * @lc app=leetcode id=76 lang=java
 *
 * [76] Minimum Window Substring
 *
 * https://leetcode.com/problems/minimum-window-substring/description/
 *
 * algorithms
 * Hard (33.76%)
 * Likes:    4096
 * Dislikes: 286
 * Total Accepted:    374.4K
 * Total Submissions: 1.1M
 * Testcase Example:  '"ADOBECODEBANC"\n"ABC"'
 *
 * Given a string S and a string T, find the minimum window in S which will
 * contain all the characters in T in complexity O(n).
 * 
 * Example:
 * 
 * 
 * Input: S = "ADOBECODEBANC", T = "ABC"
 * Output: "BANC"
 * 
 * 
 * Note:
 * 
 * 
 * If there is no such window in S that covers all characters in T, return the
 * empty string "".
 * If there is such window, you are guaranteed that there will always be only
 * one unique minimum window in S.
 * 
 * 
 */

// @lc code=start
class Solution {
    public String minWindow(String s, String t) {
        int sLen = s.length();
        int tLen = t.length();

        if (sLen == 0 || tLen == 0 || sLen < tLen) {
            return "";
        }

        char[] charArrayS = s.toCharArray();
        char[] charArrayT = t.toCharArray();

        int[] tFreq = new int[128];
        for (char c : charArrayT) {
            tFreq[c]++;
        }

        // 滑动窗口内部还差多少 T 中的字符，对应字符频数超过不重复计算
        int distance = tLen;
        int minLen = sLen + 1;
        int begin = 0;

        int left = 0;
        int right = 0;
        // [left..right)
        while (right < sLen) {
            char charRight = charArrayS[right];
            if (tFreq[charRight] > 0) {
                distance--;
            }
            tFreq[charRight]--;
            right++;

            while (distance == 0) {
                if (right - left < minLen) {
                    minLen = right - left;
                    begin = left;
                }

                char charLeft = charArrayS[left];
                if (tFreq[charLeft] == 0) {
                    distance++;
                }
                tFreq[charLeft]++;
                left++;
            }
        }

        if (minLen == sLen + 1) {
            return "";
        }
        return s.substring(begin, begin + minLen);
    }

    public String minWindow2(String s, String t) {
        int start = 0, len = Integer.MAX_VALUE, valid = 0, letters = 0, left = 0, right = 0;
        int[] letterArray = new int[128], windows = new int[128];
        int size = s.length();
        for (int i = 0; i < t.length(); ++i) {
            letterArray[t.charAt(i)] ++;
            if (letterArray[t.charAt(i)] == 1) ++letters;
        }
        while(right < size) {
            int c = s.charAt(right);
            ++right;
            if (letterArray[c] > 0) {
                windows[c]++;
                if (windows[c] == letterArray[c]) {
                    ++valid;
                }
            }
            while(valid == letters) {
                if (right - left < len) {
                    start = left;
                    len = right - left;
                }
                int d = s.charAt(left);
                ++left;
                if (letterArray[d] > 0) {
                    if (windows[d] == letterArray[d]) {
                        --valid;
                    }
                    windows[d]--;
                }
            }
        }
        return len == Integer.MAX_VALUE ? "" : s.substring(start, start + len);
    }
}
// @lc code=end

