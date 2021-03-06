package problem.twopointers;

import java.util.HashMap;
import java.util.Map;

/**
 * 题目：
 * 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
 * 你可以假设每种输入只会对应一个答案。但是，你不能重复利用这个数组中同样的元素。
 */
public class SumOfTwoIntegers {
    /**
     * 哈希表查找的时间开销为O(1).
     * @param target
     * @param nums
     * @return
     */
    public int[] getSumOfTwoIntegers(int target, int[] nums){
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {

            int complement = target - nums[i];

            if (map.containsKey(complement)) {

                return new int[] { map.get(complement), i };

            }

            map.put(nums[i], i);

        }

        throw new IllegalArgumentException("No two sum solution");
    }
}
