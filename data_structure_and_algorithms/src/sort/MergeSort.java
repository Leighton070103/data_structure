package sort;

/**
 * TODO：内部缓存法
 */
public class MergeSort extends Sort {

    public MergeSort(int[] arr) {
        super(arr);
    }

    @Override
    public void sort() {
        sort(0, arr.length-1);
    }

    private void sort(int left, int right){
        if (left == right) return;
        int mid = (left + right ) / 2;
        sort(left, mid);
        sort(mid + 1, right);
        merge(left, mid, mid +1, right);
    }

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
