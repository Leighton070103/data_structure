package sort;


/**
 * 改进merge sort，将递归改为顺序遍历。
 */
public class ImprovedMergeSort extends Sort {

    public ImprovedMergeSort(int[] arr) {
        super(arr);
    }

    /**
     * 根据分组长度将数组分为不同的组，遍历不同的组进行归并。
     * length: 每组长度； groupCount：组数。
     * length每轮乘2。
     */
    @Override
    public void sort() {
       int length = 1; //分组长度
       while (length <= arr.length){
           int groupCount = arr.length/length;
           for (int i=0; i <= groupCount; i+=2){
               int lStart = i*length;
               int lEnd = lStart + length -1;
               int rStart = lEnd+1;
               int rEnd = rStart + length-1 < arr.length ?  rStart + length-1: arr.length-1;
               merge(lStart, lEnd, rStart, rEnd);
           }
           length *=2;
       }
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
