package sort;

import util.ArrayUtil;

import java.util.Arrays;

import static util.ArrayUtil.copyArray;

public class SortTest {

    int[] sorted;

    SortTest(int[] arr) {
        sorted = copyArray(arr);
        Arrays.sort(sorted);
    }

    public static void main(String[] args) {
        int[] arr = ArrayUtil.randomArr(900000);
        System.out.println("Sorting test: [Array length: " + arr.length + "]");
//        printArr(arr);
        SortTest sortTest = new SortTest(arr);



//        test("Merge sort", new MergeSort(copyArray(arr)), sortTest);
//        test("Improved Merge sort", new ImprovedMergeSort(copyArray(arr)), sortTest);
//        test("Quick sort", new QuickSort(copyArray(arr)), sortTest);
//        test("Improved Quick sort", new ImprovedQuickSort(copyArray(arr)), sortTest);
//        test("Heap sort", new HeapSort(copyArray(arr)), sortTest);
//        test("Non-recursive Synthetical Sort", new NonRecursiveSyntheticalSort(copyArray(arr)), sortTest);
//        test("Recursive Synthetical Sort", new RecursiveSyntheticalSort(copyArray(arr)), sortTest);
//        test("Bucket Sort", new BucketSort(copyArray(arr), 100), sortTest);

        test("Shell sort", new ShellSort(copyArray(arr)), sortTest);
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
