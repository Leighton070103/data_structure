package datastructure;

import static util.NumUtil.swap;

/**
 * 大根堆
 */
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

    /**
     * 在数组中通过遍历的方式假装插入。
     * 如果子节点大于父节点，将子节点与父节点交换。
     * @param index
     */
    private void insertByArr(int index){
        int parent = getParent(index); //获取父节点
        while ( arr[index] > arr[parent]){
            swap(arr, index, parent);
            index = parent;
            parent = getParent(index);
        }
    }

    /**
     * 通过数组进行插入。
     * @param value
     */
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

    /**
     *
     * @param size
     */
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

    /**
     * 通常，父节点 ×2 + 1 为左孩子，+2为右孩子。
     * 由于1/2 = 0， 所以（index-1）/2的结果必为父节点。
     * @param index
     * @return
     */
    private int getParent(int index){
        return (index-1) / 2;
    }

    /**
     * 将获取父节点的方式倒过来。
     * @param index
     * @return
     */
    private int getLChild(int index){
        return 2 * index + 1;
    }

}
