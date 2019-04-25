package sort;

/**
 * 归并排序：将数组分为2个一组，相邻数组互相比较之后再合并。
 */
public class MergeSort extends Sort {

    public MergeSort(int[] arr) {
        super(arr);
    }

    @Override
    public void sort() {
        sort(0, arr.length-1);
    }

    /**
     * 将数组一分为二，对左右分别进行再次分割，然后将分割好的数组进行归并。
     * @param left
     * @param right
     */
    private void sort(int left, int right){
        if (left == right) return;
        int mid = (left + right ) / 2;
        sort(left, mid);
        sort(mid + 1, right);
        merge(left, mid, mid +1, right);
    }

    /**
     * 创建一个临时数组，用于存放merge好的数。
     * 对左右数组分别创建指针，对临时数组创建指针；
     * 比较左右指针所指向的数，将较小的一个数放入临时数组中，并把相应指针后移一位；
     * 当左右指针任何一个到达终点时，跳出循环；
     * 将未遍历完的数组直接塞入剩下的临时数组中。
     * 将临时数组的数重新导入原数组。
     * @param lStart 左边数组的开始
     * @param lEnd 左边数组的最后一个数
     * @param rStart 右边数组的第一个数
     * @param rEnd 右边数组的最后一个数
     */
    private void merge(int lStart, int lEnd, int rStart, int rEnd){
        int[] tmp = new int[rEnd - lStart+1];
        int lPtr = lStart;
        int rPtr = rStart;
        int nPtr = 0;
        while (lPtr <= lEnd && rPtr <= rEnd){
            tmp[nPtr++] = arr[lPtr] < arr[rPtr] ? arr[lPtr++] : arr[rPtr++];
        }
        int currentPtr = lPtr <= lEnd ? lPtr : rPtr;
        while ( nPtr < tmp.length){
            tmp[nPtr++] = arr[currentPtr++];
        }

        int i=0;
        while ( i < tmp.length ){
            arr[lStart + i] = tmp[i++];
        }
    }
}
