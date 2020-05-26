/*
 * @lc app=leetcode id=621 lang=java
 *
 * [621] Task Scheduler
 *
 * https://leetcode.com/problems/task-scheduler/description/
 *
 * algorithms
 * Medium (47.83%)
 * Likes:    2820
 * Dislikes: 627
 * Total Accepted:    154.4K
 * Total Submissions: 321.6K
 * Testcase Example:  '["A","A","A","B","B","B"]\n2'
 *
 * Given a char array representing tasks CPU need to do. It contains capital
 * letters A to Z where different letters represent different tasks. Tasks
 * could be done without original order. Each task could be done in one
 * interval. For each interval, CPU could finish one task or just be idle.
 * 
 * However, there is a non-negative cooling interval n that means between two
 * same tasks, there must be at least n intervals that CPU are doing different
 * tasks or just be idle.
 * 
 * You need to return the least number of intervals the CPU will take to finish
 * all the given tasks.
 * 
 * 
 * 
 * Example:
 * 
 * 
 * Input: tasks = ["A","A","A","B","B","B"], n = 2
 * Output: 8
 * Explanation: A -> B -> idle -> A -> B -> idle -> A -> B.
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * The number of tasks is in the range [1, 10000].
 * The integer n is in the range [0, 100].
 * 
 * 
 */

// @lc code=start
class Solution {
    /**
     * 思路很巧妙
     * https://leetcode-cn.com/problems/task-scheduler/solution/shi-jian-fu-za-du-on-kong-jian-fu-za-du-o1-by-dnan/
     */
    public int leastInterval(char[] tasks, int n) {
        int max = 0, maxCount = 0;
        int[] letters = new int[26];
        for(char task: tasks) {
            letters[task - 'A']++;
            int count = letters[task - 'A'];
            if (max == count) {
                maxCount++;
            } else if (max < count) {
                max = count;
                maxCount = 1;
            }
        }
        int partCount = max - 1;
        int partLength = n - (maxCount - 1);
        int emptySlots = partCount * partLength;
        int restTasks = tasks.length - max * maxCount;
        int idles = Math.max(0, emptySlots - restTasks);
        return tasks.length + idles;
    }

    public int leastInterval2(char[] tasks, int n) {
        
    }
}
// @lc code=end

