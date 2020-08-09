package problem.twopointers;

import java.util.Arrays;

public class ThreeSumClosest {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int av = target/3;
        int lPtr = 0;
        int rPtr = nums.length-1;
        if (nums[rPtr] <= target) return nums[rPtr] + nums[rPtr-1] + nums[rPtr-2];
        if (nums[lPtr] > target) return nums[lPtr] + nums[lPtr+1] + nums[lPtr+2];
        int closestPositive = 0;
        int closestNegative = 0;
        for (int i=0; i<nums.length; i++){
            nums[i] = nums[i] * 3;
            nums[i] -= target;
            if (nums[i] >= 0 && nums[i] < nums[closestPositive]) closestPositive = i;
            if (nums[i] <= 0 && nums[i] > nums[closestNegative]) closestNegative = i;
        }//处理完后数组存储的是3倍的值与target的差值

        int dVal = nums[lPtr] + nums[rPtr] + nums[lPtr+1];
        int twoSum;
        int threeSum;
        while (lPtr < rPtr){
            twoSum = nums[rPtr] + nums[lPtr];
            if (twoSum == 0) {
                dVal = absValIsLess(nums[closestNegative], nums[closestPositive]) ?
                        nums[closestNegative] : nums[closestPositive];
                break;
            }
            else if (twoSum > 0 ){

            }
            else {//twoSum<0

            }

        }


        return (dVal + 3*target)/3;
    }

    public boolean absValIsLess(int a, int b){
        return Math.abs(a) > Math.abs(b);
    }


}
