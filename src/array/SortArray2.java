package array;

//归并排序
//归并排序利用了分治的思想来对序列进行排序。对一个长为 n的待排序的序列，我们将其分解成两个长度为n/2的子序列。
//每次先递归调用函数使两个子序列有序，然后我们再线性合并两个有序的子序列使整个序列有序。
public class SortArray2 {
    int[] tmp;
    public static void main(String[] args) {

    }

    public int[] sortArray(int[] nums) {
        tmp = new int[nums.length];
        mergeSort(nums, 0, nums.length - 1);
        return nums;
    }

    //定义 mergeSort(nums, l, r) 函数表示对 nums 数组里 [l,r][l,r] 的部分进行排序，整个函数流程如下：
    //递归调用函数 mergeSort(nums, l, mid) 对 nums 数组里 [l,mid] 部分进行排序。
    //递归调用函数 mergeSort(nums, mid + 1, r) 对 nums 数组里 [mid+1,r] 部分进行排序。
    //此时 nums 数组里 [l,mid] 和 [mid+1,r] 两个区间已经有序，我们对两个有序区间线性归并即可使 nums 数组里 [l,r][l,r] 的部分有序。
    //线性归并的过程并不难理解，由于两个区间均有序，所以我们维护两个指针 i和 j表示当前考虑到 [l,mid] 里的第 i个位置
    // 和 [mid+1,r] 的第 j个位置。
    //如果 nums[i] <= nums[j] ，那么我们就将nums[i] 放入临时数组 tmp 中并让 i += 1 ，即指针往后移。
    // 否则我们就将nums[j] 放入临时数组 tmp 中并让 j += 1 。
    // 如果有一个指针已经移到了区间的末尾，那么就把另一个区间里的数按顺序加入 tmp 数组中即可。
    //这样能保证我们每次都是让两个区间中较小的数加入临时数组里，那么整个归并过程结束后 [l,r][l,r] 即为有序的。
    public void mergeSort(int[] nums, int l, int r) {
        if (l >= r) {
            return;
        }
        int mid = (l + r) >> 1;
        mergeSort(nums, l, mid);
        mergeSort(nums, mid + 1, r);
        int i = l, j = mid + 1;
        int cnt = 0;
        while (i <= mid && j <= r) {
            if (nums[i] <= nums[j]) {
                tmp[cnt++] = nums[i++];
            } else {
                tmp[cnt++] = nums[j++];
            }
        }
        while (i <= mid) {
            tmp[cnt++] = nums[i++];
        }
        while (j <= r) {
            tmp[cnt++] = nums[j++];
        }
        for (int k = 0; k < r - l + 1; ++k) {
            nums[k + l] = tmp[k];
        }
    }
}
