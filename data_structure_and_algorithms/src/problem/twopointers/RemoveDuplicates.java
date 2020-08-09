package problem.twopointers;

import static util.PrintUtil.printArr;

/**
 * 给定一个排序数组，你需要在 原地 删除重复出现的元素，使得每个元素只出现一次，返回移除后数组的新长度。
 * 不要使用额外的数组空间，你必须在 原地 修改输入数组 并在使用 O(1) 额外空间的条件下完成。
 *
 */
public class RemoveDuplicates {
    public int removeDuplicates(int[] nums) {
        if (nums.length == 0) return 0;
        int length = 0;
        int ptr = 0;
        int prev = nums[0];
        while (++ptr < nums.length) {
            if (prev != nums[ptr]) {
                swap(ptr, ++length, nums);
                prev = nums[length];
            }

        }
        return length + 1;
    }

    public void swap(int a, int b, int[] nums){
        int tmp = nums[a];
        nums[a] = nums[b];
        nums[b] = tmp;
    }

    public static void main(String[] args){
        int[] nums = new int[]{0,0,1,1,1,2,2,3,3,4};
        RemoveDuplicates r = new RemoveDuplicates();
        System.out.println(r.removeDuplicates(nums));
        printArr(nums);
    }
}
