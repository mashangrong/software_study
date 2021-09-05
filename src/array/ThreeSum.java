package array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {
    public static void main(String[] args) {
        ThreeSum solution = new ThreeSum();
        int[] nums = {-1,0,1,2,-1,-4};
    }

    public List<List<Integer>> threeSum(int[] nums) {
        int len = nums.length;
        List<List<Integer>> result = new ArrayList<>();
        if (len < 3){
            return result;
        }

        Arrays.sort(nums);
        for (int i = 0; i < nums.length && nums[i] <= 0; i++){
            if (i > 0 && nums[i] == nums[i - 1]){
                continue;
            }
            int l = i + 1;
            int r = len - 1;
            while (l < r){
                int sum = nums[i] + nums[l] + nums[r];
                if (sum == 0){
                    result.add(Arrays.asList(nums[i], nums[l], nums[r]));
                    while (l < r && nums[l] == nums[++l]);
                    while (l < r && nums[r] == nums[--r]);
                }else if (sum < 0){
                    l++;
                }else {
                    r--;
                }
            }
        }
        return result;
    }
}
