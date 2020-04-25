/*
 * @lc app=leetcode id=88 lang=java
 *
 * [88] Merge Sorted Array
 */

// @lc code=start
class Solution {
    /**
     * 暴力法
     * @param nums1
     * @param m
     * @param nums2
     * @param n
     */
    public void merge1(int[] nums1, int m, int[] nums2, int n) {
        int start = 0;
        for (int i = 0; i < nums2.length; ++i) {
            for (int j = start; j < m; ++j) {
                if (nums2[i] < nums1[j]) {
                    insert(nums2[i],nums1, j, m);
                    start = j;
                    ++m;
                    break;
                }
                if (j == m - 1) {
                    break;
                }
            }
            if (i >= (m + n - nums1.length)){
                nums1[m++] = nums2[i];
            }
        }
    }

    public void insert(int element, int[] array, int start, int end) {
        for (int i = end; i > start; --i) {
            array[i] = array[i - 1];
        }
        array[start] = element;
    }

    /**
     * 标签：从后向前数组遍历
        因为 nums1 的空间都集中在后面，所以从后向前处理排序的数据会更好，节省空间，一边遍历一边将值填充进去
        设置指针 len1 和 len2 分别指向 nums1 和 nums2 的有数字尾部，从尾部值开始比较遍历，同时设置指针 len 指向 nums1 的最末尾，每次遍历比较值大小之后，则进行填充
        当 len1<0 时遍历结束，此时 nums2 中海油数据未拷贝完全，将其直接拷贝到 nums1 的前面，最后得到结果数组
        时间复杂度：O(m+n)O(m+n)
     * @param nums1
     * @param m
     * @param nums2
     * @param n
     */
    public void merge2(int[] nums1, int m, int[] nums2, int n) {
        int len1 = m - 1;
        int len2 = n - 1;
        int len = m + n - 1;
        while(len1 >= 0 && len2 >= 0) {
            // 注意--符号在后面，表示先进行计算再减1，这种缩写缩短了代码
            nums1[len--] = nums1[len1] > nums2[len2] ? nums1[len1--] : nums2[len2--];
        }
        // 表示将nums2数组从下标0位置开始，拷贝到nums1数组中，从下标0位置开始，长度为len2+1
        System.arraycopy(nums2, 0, nums1, 0, len2 + 1);
    }
}
// @lc code=end
