package array;

import java.util.Random;

//quick sort
//输入：nums = [5,2,3,1]
//输出：[1,2,3,5]
public class SortArray {
    public static void main(String[] args) {

    }

    //基于随机选取主元的快速排序时间复杂度为期望 O(n\log n)，其中 n 为数组的长度
    //空间复杂度：O(h)，其中 h 为快速排序递归调用的层数。我们需要额外的 O(h)的递归调用的栈空间，
    // 由于划分的结果不同导致了快速排序递归调用的层数也会不同，最坏情况下需 O(n)的空间，
    // 最优情况下每次都平衡，此时整个递归树高度为logn，空间复杂度为 O(logn)。
    public int[] sortArray(int[] nums) {
        randomizedQuicksort(nums, 0, nums.length - 1);
        return nums;
    }

    public void randomizedQuicksort(int[] nums, int l, int r) {
        if (l < r) {
            int pos = randomizedPartition(nums, l, r);
            randomizedQuicksort(nums, l, pos - 1);
            randomizedQuicksort(nums, pos + 1, r);
        }
    }

    public int randomizedPartition(int[] nums, int l, int r) {
        int i = new Random().nextInt(r - l + 1) + l; // 随机选一个作为我们的主元
        swap(nums, r, i);
        return partition(nums, l, r);
    }

    public int partition(int[] nums, int l, int r) {
        int pivot = nums[r];
        int i = l - 1;
        for (int j = l; j <= r - 1; ++j) {
            if (nums[j] <= pivot) {
                i = i + 1;
                swap(nums, i, j);
            }
        }
        swap(nums, i + 1, r);
        return i + 1;
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
