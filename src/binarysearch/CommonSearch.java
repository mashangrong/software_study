package binarysearch;

/**
 * 给定一个n个元素有序的（升序）整型数组nums 和一个目标值target ，
 * 写一个函数搜索nums中的 target，如果目标值存在返回下标，否则返回 -1。
。 输入: nums = [-1,0,3,5,9,12], target = 9
   输出: 4
   解释: 9 出现在 nums 中并且下标为 4

    输入: nums = [-1,0,3,5,9,12], target = 2
    输出: -1
    解 释: 2 不存在 nums 中因此返回 -1
 */
public class CommonSearch {
    public static void main(String[] args) {

    }

    public int search(int[] nums, int target) {
        int pivot, left = 0, right = nums.length - 1;
        while (left <= right) {
            pivot = left + (right - left) / 2;
            if (nums[pivot] == target) return pivot;
            if (target < nums[pivot]) right = pivot - 1;
            else left = pivot + 1;
        }
        return -1;
    }
}
