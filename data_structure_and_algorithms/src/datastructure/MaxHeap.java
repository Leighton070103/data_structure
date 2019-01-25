package datastructure;

import static util.NumUtil.swap;

public class MaxHeap {
    int[] arr;
    int size;
    public MaxHeap(int[] arr){
        this.arr = arr;
        size = arr.length;
        for (int i = 0; i < arr.length; i++) insertByArr(i);
    }

    public MaxHeap(int size){
        arr = new int[1000];
        this.size = size;
    }

    public int getSize(){
        return size;
    }

    private void insertByArr(int index){
        int parent = getParent(index);
        while ( arr[index] > arr[parent]){
            swap(arr, index, parent);
            index = parent;
            parent = getParent(index);
        }
    }

    public void insert(int value){
        int parent = getParent(size);
        int index = size ++;
        arr[index] = value;
        while ( arr[index] > arr[parent]){
            swap(arr, index, parent);
            index = parent;
            parent = getParent(index);
        }
    }

    public void heapify(int size){
        int nPtr = 0;
        int leftChild = getLChild(nPtr);
        int rightChild = leftChild + 1;
        while (leftChild < size){
            int largest = rightChild < size && arr[rightChild] > arr[leftChild] ? rightChild : leftChild;
            if (arr[largest] > arr[nPtr]){
                swap(arr, largest, nPtr);
                nPtr = largest;
                leftChild = getLChild(nPtr);
                rightChild = leftChild + 1;
            }
            else break;
        }
    }

    private int getParent(int index){
        return (index-1) / 2;
    }
    private int getLChild(int index){
        return 2 * index + 1;
    }

}
