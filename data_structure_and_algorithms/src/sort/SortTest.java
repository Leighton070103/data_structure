package sort;

import util.ArrayUtil;

import java.util.Arrays;

public class SortTest {

    int[] sorted;

    SortTest(int[] arr) {
        sorted = ArrayUtil.copyArray(arr);
        Arrays.sort(sorted);
    }

    public static void main(String[] args) {
        int[] arr = ArrayUtil.randomArr(900000);
        System.out.println("Sorting test: [Array length: " + arr.length + "]");
//        printArr(arr);
        SortTest sortTest = new SortTest(arr);



        test("Merge sort", new MergeSort(ArrayUtil.copyArray(arr)), sortTest);
        test("Improved Merge sort", new ImprovedMergeSort(ArrayUtil.copyArray(arr)), sortTest);
        test("Quick sort", new QuickSort(ArrayUtil.copyArray(arr)), sortTest);
        test("Improved Quick sort", new ImprovedQuickSort(ArrayUtil.copyArray(arr)), sortTest);
        test("Heap sort", new HeapSort(ArrayUtil.copyArray(arr)), sortTest);
        test("Non-recursive Synthetical Sort", new NonRecursiveSyntheticalSort(ArrayUtil.copyArray(arr)), sortTest);
        test("Recursive Synthetical Sort", new RecursiveSyntheticalSort(ArrayUtil.copyArray(arr)), sortTest);
//        test("Bucket Sort", new BucketSort(copyArray(arr), 100), sortTest);

//        test("Shell sort", new ShellSort(copyArray(arr)), sortTest);
//        test("Improved Bubble sort", new ImprovedBubbleSort(copyArray(arr)), sortTest);
//        test("Bubble sort", new BubbleSort(copyArray(arr)), sortTest);
//        test("Selection sort", new SelectionSort(copyArray(arr)), sortTest);
//        test("Insertion sort", new InsertionSort(copyArray(arr)), sortTest);

    }

    static void test(String method, Sort sort, SortTest sortTest) {
        long start = System.currentTimeMillis();
        sort.sort();
        long end = System.currentTimeMillis();
        System.out.print("[Name: "+ method + "; Time: " + (end - start) + "; Result: ");
        System.out.print(sortTest.isSorted(sort.getArr()) ? "success.": "fail.");
        System.out.println("]");
//        printArr(sort.getArr());

    }

    boolean isSorted(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != sorted[i]) return false;
        }
        return true;
    }
}
