package sort;



public class ImprovedMergeSort extends Sort {

    public ImprovedMergeSort(int[] arr) {
        super(arr);
    }

    @Override
    public void sort() {
       int length = 1;
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
