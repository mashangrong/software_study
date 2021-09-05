package array;

/**
 * 给定一个数组 A，将其划分为两个连续子数组 left 和 right， 使得：
 * left 中的每个元素都小于或等于 right 中的每个元素。
 * left 和 right 都是非空的。
 * left 的长度要尽可能小。
 * 在完成这样的分组后返回 left 的长度。可以保证存在这样的划分方法。
 *
 * 输入：[5,0,3,8,6]
 * 输出：3
 * 解释：left = [5,0,3]，right = [8,6]
 *
 * 输入：[1,1,1,0,6,12]
 * 输出：4
 * 解释：left = [1,1,1,0]，right = [6,12]
 */
public class PartitionDisjoint {
    public static void main(String[] args) {
        PartitionDisjoint solution = new PartitionDisjoint();
        int[] nums = {5,0,3,8,6};
        int res = solution.partitionDisjoint(nums);
        System.out.println(res);

    }

    public int partitionDisjoint(int[] nums) {
        int N = nums.length;
        int[] maxleft = new int[N];
        int[] minright = new int[N];

        int m = nums[0];
        for (int i = 0; i < N; ++i) {
            m = Math.max(m, nums[i]);
            maxleft[i] = m;
        }

        m = nums[N-1];
        for (int i = N-1; i >= 0; --i) {
            m = Math.min(m, nums[i]);
            minright[i] = m;
        }

        for (int i = 1; i < N; ++i)
            if (maxleft[i-1] <= minright[i])
                return i;

        throw null;
    }
}
