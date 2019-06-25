package problem.leetcoderegular;

import java.util.LinkedList;
import java.util.List;

import static util.ArrayUtil.orderedArr;

/**
 * Leetcode 658 找到 K 个最接近的元素
 * 给定一个排序好的数组，两个整数 k 和 x，从数组中找到最靠近 x（两数之差最小）的 k 个数。返回的结果必须要是按升序排好的。
 * 如果有两个数与 x 的差值一样，优先选择数值较小的那个数。
 */
public class ClosestElements {

    public static void main(String[] args){
        ClosestElements c = new ClosestElements();
        List<Integer> res = c.findClosestElements(orderedArr(1, 5), 3, 2);
        for (Integer i: res) System.out.print(i+", ");
    }

    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        List<Integer> res = new LinkedList<>();
        int left = -1;
        int right = arr.length;
        if (x <= arr[0]) right = 0;
        else if (x>= arr[arr.length-1]) left = arr.length-1;
        else {
            int l = 0;
            int r = arr.length-1;
            while (l != r){
                int mid = (r+l)/2;
                if (mid + 1 < arr.length && arr[mid] <= x && arr[ mid + 1 ] >= x){
                    right = mid + 1;
                    left = mid;
                    break;
                }
                else if (mid - 1 < arr.length && arr[mid-1] <= x && arr[ mid ] >= x){
                    right = mid;
                    left = mid-1;
                    break;
                }
                else {
                    if (arr[mid] > x) r = mid;
                    else l = mid;
                }
            }
//            for (int i = 1; i < arr.length; i++){
//                if (arr[i] >= x && arr[i-1] <= x){
//                    left = i-1;
//                    right = i;
//                    break;
//                }
//            }
        }


        while ( k > 0){
            if (left == -1) res.add(arr[right++]);
            else if (right == arr.length) res.add(0, arr[left--]);
            else {
                if (arr[right] - x < x-arr[left] ) res.add(arr[right++]);
                else res.add(0, arr[left--]);
            }
            k--;
        }
        return res;
    }
}
