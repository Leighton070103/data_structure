package problem.course.stackandqueue;

public class ArrayStack {
    int[] arr;
    int last;
    public ArrayStack(int capacity){
        this.arr = new int[capacity];
        last = -1;
    }

    public void insert(int val){
        if(last + 1 < arr.length){
            arr[last++] = val;
        }
    }

    public void pop(){
        last--;
    }

    public int top(){
        return arr[last];
    }

}
