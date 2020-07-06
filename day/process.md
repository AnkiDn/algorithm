# 每日打卡题

## 前缀和

1. [256.和为K的子数组](https://leetcode-cn.com/problems/subarray-sum-equals-k/)
   1. 有多个相同的前缀和时 多个相同的前缀和组成了一个求子组的问题 求一个数组的所有不同子组(不包含空)公式为 `f(i) = f(i - 1) + i` and `f(0) = 0` 也就是当前是第几个前缀和时 累加上`i-1`之前的和再加上自己本身`i`就行。
2. [1371. 每个元音包含偶数次的最长子字符串](https://leetcode-cn.com/problems/find-the-longest-substring-containing-vowels-in-even-counts/)
3. [974.和可被 K 整除的子数组](https://leetcode-cn.com/problems/subarray-sums-divisible-by-k/)

## 动态规划

1. [887.鸡蛋掉落](https://leetcode-cn.com/problems/super-egg-drop/)
2. [5.最长回文子串](https://leetcode-cn.com/problems/longest-palindromic-substring/)
3. [837.新21点](https://leetcode-cn.com/problems/new-21-game/)
4. [139. 单词拆分](https://leetcode-cn.com/problems/word-break/)

## 二分

1. [4.寻找两个正序数组的中位数](https://leetcode-cn.com/problems/median-of-two-sorted-arrays/)
2. [287.寻找重复数](https://leetcode-cn.com/problems/find-the-duplicate-number/)

## 栈-递归

1. [394.字符串解码](https://leetcode-cn.com/problems/decode-string/)

## 哈希表

1. [最长连续序列](https://leetcode-cn.com/problems/longest-consecutive-sequence/)

### 状态机DFA
1. [10. 正则表达式匹配](https://leetcode-cn.com/problems/regular-expression-matching/)
2. [65. 有效数字](https://leetcode-cn.com/problems/valid-number/)

题号 | 难易度 | 次数 | level | title | url
---|---|---|---|---|---
560 | 中等 |  1 | 不太熟 | 和为K的子数组 | [subarray-sum-equals-k](https://leetcode-cn.com/problems/subarray-sum-equals-k/)
210 | 中等 | 0 | 不会图 | 课程表 II | [Course Schedule II](https://leetcode-cn.com/problems/course-schedule-ii/)
152 | 中等 | 1 | dp | 乘积最大子数组 | [maximum-product-subarray](https://leetcode-cn.com/problems/maximum-product-subarray/)
1371 | 中等 | 0 | dp | 每个元音包含偶数次的最长子字符串 | [find-the-longest-substring-containing-vowels-in-even-counts](https://leetcode-cn.com/problems/find-the-longest-substring-containing-vowels-in-even-counts/)
887 | 困难 | 0 | dp | 鸡蛋掉落 | [super-egg-drop](https://leetcode-cn.com/problems/super-egg-drop/)
5 | 中等 | 1 | dp 马拉车 | 最长回文子串 | [longest-palindromic-substring](https://leetcode-cn.com/problems/longest-palindromic-substring/)
8 | 中等 | 1 | dfa | 字符串转换整数 (atoi) | [string-to-integer-atoi](https://leetcode-cn.com/problems/string-to-integer-atoi/)
4 | 困难 | 0 | 二分，归并，双端队列 | 寻找两个正序数组的中位数 | [median-of-two-sorted-arrays](https://leetcode-cn.com/problems/median-of-two-sorted-arrays/)
287 | 中等 | 1 | 二分，双指针 | 寻找重复数 | [find-the-duplicate-number](https://leetcode-cn.com/problems/find-the-duplicate-number/)
974 | 中等 | 1 | 前缀和，同余定理 | 和可被 K 整除的子数组 | [subarray-sums-divisible-by-k](https://leetcode-cn.com/problems/subarray-sums-divisible-by-k/)
394 | 中等 | 1 | 栈-递归-编译原理 | 字符串解码 | [decode-string](https://leetcode-cn.com/problems/decode-string/)
837 | 中等 | 1 | dp | 新21点 | [new-21-game](https://leetcode-cn.com/problems/new-21-game/)
128 | 困难 | 1 | 哈希表 | [最长连续序列](https://leetcode-cn.com/problems/longest-consecutive-sequence/) | [Longest Consecutive Sequence](https://leetcode-cn.com/problems/longest-consecutive-sequence/)
126 | 困难 | 0 | bfs | [单词接龙 II](https://leetcode-cn.com/problems/word-ladder-ii/) | [Word Ladder II](https://leetcode-cn.com/problems/word-ladder-ii/)
990 | 中等 | 1 | 并查集 | [等式方程的可满足性](https://leetcode-cn.com/problems/satisfiability-of-equality-equations/) | [Satisfiability of Equality Equations](https://leetcode-cn.com/problems/satisfiability-of-equality-equations/)
面试题.46 | 中等 | 1 | dp | [把数字翻译成字符串](https://leetcode-cn.com/problems/ba-shu-zi-fan-yi-cheng-zi-fu-chuan-lcof/) | 无
739 | 中等 | 1 | 单调栈 | [每日温度](https://leetcode-cn.com/problems/daily-temperatures/) | [Daily Temperatures](https://leetcode-cn.com/problems/daily-temperatures/)
1300 | 中等 | 1 | 二分 | 转变数组后最接近目标值的数组和 | [Sum of Mutated Array Closest to Target](https://leetcode-cn.com/problems/sum-of-mutated-array-closest-to-target/)
297 | 困难 | 1 | dfs | 二叉树的序列化与反序列化 | [Serialize and Deserialize Binary Tree](https://leetcode-cn.com/problems/serialize-and-deserialize-binary-tree/)
1014 | 中等 | 1 | dp | 最佳观光组合 | [Best Sightseeing Pair](https://leetcode-cn.com/problems/best-sightseeing-pair/)
1028 | 困难 | 1 | dfs | 从先序遍历还原二叉树 | [Recover a Tree From Preorder Traversal](https://leetcode-cn.com/problems/recover-a-tree-from-preorder-traversal/)
10 | 困难 | 0 | dp，有限状态机 | 正则表达式匹配 | [Regular Expression Matching](https://leetcode-cn.com/problems/regular-expression-matching/)
124 | 困难 | 1 | dfs | 二叉树中的最大路径和 | [Binary Tree Maximum Path Sum](https://leetcode-cn.com/problems/binary-tree-maximum-path-sum/)
139 | 中等 | 1 | dfs-dp| 单词拆分 | [Word Break](https://leetcode-cn.com/problems/word-break/)
41 | 困难 | 1 | hash-置换 | 缺失的第一个正数 | [First Missing Positive](https://leetcode-cn.com/problems/first-missing-positive/)
209 | 中等 | 1 | 滑动窗口-前缀和+二分 | 长度最小的子数组 | [Minimum Size Subarray Sum](https://leetcode-cn.com/problems/minimum-size-subarray-sum/)
215 | 中等 | 1 | 快排-堆排| 数组中的第K个最大元素 | [Kth Largest Element in an Array](https://leetcode-cn.com/problems/kth-largest-element-in-an-array/)
718 | 中等 | 1 | dp-滑动窗口-二分 | 最长重复子数组 | [Maximum Length of Repeated Subarray](https://leetcode-cn.com/problems/maximum-length-of-repeated-subarray/)
378 | 中等 | 1 | 二分 | 有序矩阵中第K小的元素 | [Kth Smallest Element in a Sorted Matrix](https://leetcode-cn.com/problems/kth-smallest-element-in-a-sorted-matrix/)
32 | 困难 | 1 | 栈-dp | 最长有效括号 | [Longest Valid Parentheses](https://leetcode-cn.com/problems/longest-valid-parentheses/)
44 | 困难 | 1 | dp | 通配符匹配 | [Wildcard Matching](https://leetcode-cn.com/problems/wildcard-matching/)
63 | 中等 | 1 | dp | 不同路径 II | [Unique Paths II](https://leetcode-cn.com/problems/unique-paths-ii/)