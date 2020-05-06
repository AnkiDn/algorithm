/*
 * @lc app=leetcode id=470 lang=java
 *
 * [470] Implement Rand10() Using Rand7()
 *
 * https://leetcode.com/problems/implement-rand10-using-rand7/description/
 *
 * algorithms
 * Medium (46.08%)
 * Likes:    364
 * Dislikes: 118
 * Total Accepted:    20.3K
 * Total Submissions: 44.1K
 * Testcase Example:  '1'
 *
 * Given a function rand7 which generates a uniform random integer in the range
 * 1 to 7, write a function rand10 which generates a uniform random integer in
 * the range 1 to 10.
 * 
 * Do NOT use system's Math.random().
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
 * Input: 1
 * Output: [7]
 * 
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: 2
 * Output: [8,4]
 * 
 * 
 * 
 * Example 3:
 * 
 * 
 * Input: 3
 * Output: [8,1,10]
 * 
 * 
 * 
 * 
 * Note:
 * 
 * 
 * rand7 is predefined.
 * Each testcase has one argument: n, the number of times that rand10 is
 * called.
 * 
 * 
 * 
 * 
 * Follow up:
 * 
 * 
 * What is the expected value for the number of calls to rand7() function?
 * Could you minimize the number of calls to rand7()?
 * 
 * 
 * 
 * 
 * 
 */

// @lc code=start
/**
 * The rand7() API is already defined in the parent class SolBase.
 * public int rand7();
 * @return a random integer in the range 1 to 7
 */
class Solution extends SolBase {
    /**
     * 生成一个棋盘，7*7=49 所以为平均取前40；
     */
    public int rand10() {
        int row, col, idx;
        do {
            row = rand7();
            col = rand7();
            idx = (row - 1) * 7 + col;
        } while (idx > 40);
        //任意非负整数取mod 范围是0～9 所以需要变成 1～10
        return 1 + (idx - 1) % 10;
    }
    
    /**
     * 将上面的优化
     * @return
     */
    public int rand10_() {
        while (true){
            int num = (rand7() - 1) * 7 + rand7();
            // 如果在40以内，那就直接返回
            if(num <= 40) return 1 + num % 10;
            // 说明刚才生成的在41-49之间，利用随机数再操作一遍
            num = (num - 40 - 1) * 7 + rand7();
            if(num <= 60) return 1 + num % 10;
            // 说明刚才生成的在61-63之间，利用随机数再操作一遍
            num = (num - 60 - 1) * 7 + rand7();
            if(num <= 20) return 1 + num % 10;

        }
    }

    private int rand7() {
        return Math.random();
    }
}
// @lc code=end

