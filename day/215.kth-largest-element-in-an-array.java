/*
 * @lc app=leetcode id=215 lang=java
 *
 * [215] Kth Largest Element in an Array
 */

// @lc code=start
class Solution {
    //基于快排
    public int findKthLargest(int[] nums, int k) {
        return quickSort(nums, 0, nums.length - 1, k);
    }

    private int quickSort(int[] nums, int l, int r, int k) {
        if (l >= r) return nums[l];
        int i = l - 1, j = r + 1, x = nums[(l + r) >>> 1];
        while (i < j) {
            do i++; while (nums[i] < x);
            do j--; while (nums[j] > x);
            if (i < j) swap(nums, i, j);
        }
        if (j >= nums.length - k) return quickSort(nums, l, j, k);
        else return quickSort(nums, j + 1, r, k);
    }

    //基于堆排序
    public int findKthLargest(int[] nums, int k) {
        buildHeap(nums);
        int size = nums.length, ans = 0;;
        while (k-- > 1) {
            swap(nums, 0, size - 1);
            size--;
            siftDown(nums, 0, size);
        }
        return nums[0];
    }

    private void buildHeap(int[] nums) {
        int size = nums.length;
        for (int i = size / 2; i >= 0; --i) siftDown(nums, i, size);
    }

    private void siftDown(int[] nums, int i, int size) {
        int left = 2 * i + 1, right = 2 * i + 2;
        int max = i;
        if (left < size && nums[left] > nums[max]) max = left;
        if (right < size && nums[right] > nums[max]) max = right;
        if (i != max) {
            swap(nums, i, max);
            siftDown(nums, max, size);
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    //调用库函数排序
    public int findKthLargest(int[] nums, int k) {
        Arrays.sort(nums);
        return nums[nums.length - k];
    }

    //使用优先队列
    public int findKthLargest(int[] nums, int k) {
        int len = nums.length;
        PriorityQueue<Integer> pq = new PriorityQueue(k);
        for (int i = 0; i < len; ++i) {
            if (pq.size() < k) {
                pq.offer(nums[i]);
                continue;
            }
            if (pq.peek() < nums[i]) {
                pq.poll();
                pq.offer(nums[i]);
            }
        }
        return pq.peek();
    }
}
// @lc code=end

