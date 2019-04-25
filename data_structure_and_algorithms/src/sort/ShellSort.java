package sort;

/**
 * 希尔排序：把记录按下标的一定增量分组，对每组使用直接插入排序算法排序；随着增量逐渐减少，每组包含的关键词越来越多，当增量减至1时，
 * 整个文件恰被分成一组，算法便终止。
 * gap与gap之间的关系为gap = gap * 3 + 1.
 * 初始gap在arr.length的三分之一左右。
 * 希尔排序是基于插入排序的以下两点性质而提出改进方法的：
 * 插入排序在对几乎已经排好序的数据操作时，效率高，即可以达到线性排序的效率。
 * 但插入排序一般来说是低效的，因为插入排序每次只能将数据移动一位。
 */
public class ShellSort extends Sort {
    public ShellSort(int[] arr) {
        super(arr);
    }

    int gap;

    /**
     * 从下标为gap的数开始，向前对间隔gap的数进行插入排序。
     */
    @Override
    public void sort() {
        gap = 0;
        while (gap < arr.length/3) gap = gap * 3 + 1;//初始化间隔

        while (gap > 0){
            for (int start = 0; start < gap; start ++){
                for (int ptr = start + gap; ptr < arr.length; ptr += gap){
                    int mark = ptr;
                    int val = arr[mark];
                    while (mark - gap >=0 && arr[mark - gap] > val){
                        arr[mark] = arr[mark - gap];
                        mark -= gap;
                    }
                    arr[mark] = val;
                }
            }
            gap = nextGap();
        }
    }

    /**
     * 获得下一个间隔。
     * @return
     */
    int nextGap(){
        return (gap-1)/3;
    }


}
