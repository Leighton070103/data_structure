package sort;

public abstract class Sort {
    int[] arr;

    public Sort(int[] arr){
        this.arr = arr;
    }

    public abstract void sort();

    public int[] getArr(){ return arr; }

}
