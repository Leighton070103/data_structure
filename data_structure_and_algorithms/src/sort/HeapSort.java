package sort;

import datastructure.MaxHeap;

import static util.NumUtil.swap;

/**
 * 堆排序
 * 额外空间复杂度O(1)
 * 自顶向上建堆O(n)；
 * 自定向下构建堆为nlogn
 * 不稳定排序
 */
public class HeapSort extends Sort {
    public HeapSort(int[] arr) {
        super(arr);
    }

    /**
     * 第一个数此时为最大值，将其与最后一个数交换。
     */
    @Override
    public void sort() {
        MaxHeap heap = new MaxHeap(arr);
        int size = arr.length;
        while (size > 0){
            swap(arr, 0, --size);
            heap.heapify(size);
        }
    }

}
