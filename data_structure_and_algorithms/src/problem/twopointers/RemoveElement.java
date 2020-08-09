package problem.twopointers;

import static util.PrintUtil.printArr;

/**
 * Leetcode 27
 * 给你一个数组 nums 和一个值 val，你需要 原地 移除所有数值等于 val 的元素，并返回移除后数组的新长度。
 * 不要使用额外的数组空间，你必须仅使用 O(1) 额外空间并 原地 修改输入数组。
 * 元素的顺序可以改变。你不需要考虑数组中超出新长度后面的元素。
 */
public class RemoveElement {
    public int removeElement(int[] nums, int val) {
        if (nums.length == 0) return 0;
        int edge = nums.length-1;
        int ptr = 0;
        while (ptr  <= edge){
            if (nums[ptr] == val){
                swap(edge--, ptr, nums);
            }
            else ptr++;
        }
        return edge+1;
    }

    public void swap(int a, int b, int[] nums){
        int tmp = nums[a];
        nums[a] = nums[b];
        nums[b] = tmp;
    }

    public static void main(String[] args){
        RemoveElement re = new RemoveElement();
        int[] nums = new int[]{3, 2, 2, 3};
        re.removeElement(nums, 3);
        printArr(nums);
    }
}
