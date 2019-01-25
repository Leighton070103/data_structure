package sort;

public class ShellSort extends Sort {
    public ShellSort(int[] arr) {
        super(arr);
    }


    int gap;
    @Override
    public void sort() {
        gap = 0;
        while (gap<arr.length/3) gap = gap * 3 + 1;//初始化间隔

        while (gap > 0){
            for (int edge = gap; edge < arr.length; edge++){
                int num = arr[edge];
                int ptr = edge;
                while ( ptr > gap-1 && arr[ptr - gap] > num) {
                    arr[ptr] = arr[ptr - gap];
                    ptr -= gap;
                }
                arr[ptr] = num;
            }
            gap = nextGap();
        }
    }

    int nextGap(){
        return (gap-1)/3;
    }


}
