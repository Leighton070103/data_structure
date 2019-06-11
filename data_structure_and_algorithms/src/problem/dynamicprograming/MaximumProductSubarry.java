package problem.dynamicprograming;

/**
 * Leetcode 152
 * 给定一个整数数组 nums ，找出一个序列中乘积最大的连续子序列（该序列至少包含一个数）。
 */
public class MaximumProductSubarry {

    public static void main(String[] args){
        int[] arr = new int[] {2, 3, -2, 4};
        MaximumProductSubarry m = new MaximumProductSubarry();
       System.out.println(m.maxProduct(arr));
    }

    public int maxProduct(int[] nums) {
        return firstSolution(nums);
    }

    private int firstSolution(int[] nums){
        if(nums.length == 0) return 0;
        int result = nums[0];
        int max = nums[0];
        int min = nums[0];
        for(int i = 1; i < nums.length; i++){
            if(nums[i] < 0){
                int tmp = max;
                max = min * nums[i] > nums[i] ? min * nums[i] : nums[i];
                min = tmp * nums[i] < nums[i] ? tmp * nums[i] : nums[i];
            }
            else {
                max = max * nums[i] > nums[i] ? max * nums[i] : nums[i];
                min = min * nums[i] < nums[i] ? min * nums[i] : nums[i];
            }
            result = Math.max(max, result);
        }
        return result;
    }



}
