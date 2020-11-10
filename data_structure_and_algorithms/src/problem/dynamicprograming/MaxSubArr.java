package problem.dynamicprograming;


/**
 * 剑指offer42
 * 输入一个整型数组，数组中的一个或连续多个整数组成一个子数组。求所有子数组的和的最大值。
 * 要求时间复杂度为O(n)
 */
public class MaxSubArr {
    public int maxSubArray(int[] nums) {
        if (nums.length == 0) return 0;
        int[] f = new int[nums.length];
        int max = nums[0];
        f[0] = nums[0];
        for (int i = 1; i < nums.length; i++){
            f[i] = f[i-1] > 0 ? f[i-1] + nums[i] : nums[i];
            max = max > f[i] ? max : f[i];
        }
        return max;
    }

}
