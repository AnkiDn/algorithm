/*
 * @lc app=leetcode id=983 lang=java
 *
 * [983] Minimum Cost For Tickets
 *
 * https://leetcode.com/problems/minimum-cost-for-tickets/description/
 *
 * algorithms
 * Medium (58.60%)
 * Likes:    1159
 * Dislikes: 25
 * Total Accepted:    39.2K
 * Total Submissions: 66.5K
 * Testcase Example:  '[1,4,6,7,8,20]\n[2,7,15]'
 *
 * In a country popular for train travel, you have planned some train
 * travelling one year in advance.  The days of the year that you will travel
 * is given as an array days.  Each day is an integer from 1 to 365.
 * 
 * Train tickets are sold in 3 different ways:
 * 
 * 
 * a 1-day pass is sold for costs[0] dollars;
 * a 7-day pass is sold for costs[1] dollars;
 * a 30-day pass is sold for costs[2] dollars.
 * 
 * 
 * The passes allow that many days of consecutive travel.  For example, if we
 * get a 7-day pass on day 2, then we can travel for 7 days: day 2, 3, 4, 5, 6,
 * 7, and 8.
 * 
 * Return the minimum number of dollars you need to travel every day in the
 * given list of days.
 * 
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: days = [1,4,6,7,8,20], costs = [2,7,15]
 * Output: 11
 * Explanation: 
 * For example, here is one way to buy passes that lets you travel your travel
 * plan:
 * On day 1, you bought a 1-day pass for costs[0] = $2, which covered day 1.
 * On day 3, you bought a 7-day pass for costs[1] = $7, which covered days 3,
 * 4, ..., 9.
 * On day 20, you bought a 1-day pass for costs[0] = $2, which covered day 20.
 * In total you spent $11 and covered all the days of your travel.
 * 
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: days = [1,2,3,4,5,6,7,8,9,10,30,31], costs = [2,7,15]
 * Output: 17
 * Explanation: 
 * For example, here is one way to buy passes that lets you travel your travel
 * plan:
 * On day 1, you bought a 30-day pass for costs[2] = $15 which covered days 1,
 * 2, ..., 30.
 * On day 31, you bought a 1-day pass for costs[0] = $2 which covered day 31.
 * In total you spent $17 and covered all the days of your travel.
 * 
 * 
 * 
 * 
 * 
 * Note:
 * 
 * 
 * 1 <= days.length <= 365
 * 1 <= days[i] <= 365
 * days is in strictly increasing order.
 * costs.length == 3
 * 1 <= costs[i] <= 1000
 * 
 * 
 */

// @lc code=start
class Solution {
    int ans = Integer.MAX_VALUE;
    int[] validDays = new int[]{1, 7, 30};
    int[] memo;//缓存
    /**
     * 暴力回溯
     * @param days
     * @param costs
     * @return
     */
    public int mincostTickets1(int[] days, int[] costs) {
        memo = new int[days.length];
        backTrack(0, 0, days, costs);
        return ans;
    }

    private void backTrack (int dayIndex, int toalCost,int[] days, int[] costs) {
        if (toalCost >= ans) return; //剪枝
        if (dayIndex > days.length - 1) { //超过就返回，相等时就是最后天的票还要买
            ans = Math.min(ans, toalCost);
            return;
        }
        if(memo[dayIndex] != 0 && memo[dayIndex] <= toalCost) return; //剪枝
        memo[dayIndex] = toalCost;
        for (int i = 0; i < costs.length; ++i) {
            // int temp = dayIndex;
            // int day = days[dayIndex] + validDays[i] - 1;
            // for (int j = dayIndex; j < days.length; ++j) {
            //     if (day >= days[j]) {
            //         ++dayIndex;
            //     }
            // }
            backTrack(updateDayIndex(dayIndex, validDays[i], days), toalCost + costs[i], days, costs);
            // dayIndex = temp;
        }
    }

    private int updateDayIndex (int dayIndex, int validDay, int[] days) {
        int day = days[dayIndex] + validDay - 1;
        for (int i = dayIndex; i < days.length; ++i) {
            if (day < days[i]) {
                return i;
            }
        }
        return days.length;
    }

    /**
     * dp 
     * https://leetcode-cn.com/problems/minimum-cost-for-tickets/solution/xiong-mao-shua-ti-python3-dong-tai-gui-hua-yi-do-2/
     * @param days
     * @param costs
     * @return
     */
    public int mincostTickets2(int[] days, int[] costs) {
        int[] dp = new int[days[days.length - 1] + 1];//dp数组，每个元素代表到当前天数最少钱数，为下标方便对应，多加一个 0 位置
        int day_index= 0; //设定一个days指标，标记应该处理 days 数组中哪一个元素
        for (int i = 1; i < dp.length; ++i) {
            if (i != days[day_index]) { //若当前天数不是待处理天数，则其花费费用和前一天相同
                dp[i] = dp[i -1];
            } else {
                //若 i 走到了待处理天数，则从三种方式中选一个最小的
                int first = dp[Math.max(0, i - 1)] + costs[0];
                int second = dp[Math.max(0, i - 7)] + costs[1];
                int third = dp[Math.max(0, i - 30)] + costs[2];
                dp[i] = Math.min(first, Math.min(second, third));
                ++day_index;
            }
        }
        return dp[dp.length - 1];
    }
}
// @lc code=end

