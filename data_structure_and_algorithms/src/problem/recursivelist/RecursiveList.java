package problem.recursivelist;

import static problem.recursivelist.Node.recurse;
import static util.ArrayUtil.orderedArr;
import static util.PrintUtil.printArr;

public class RecursiveList {

    public static void main(String[] args){
        int[] arr = orderedArr(1, 10);
        printArr(arr);
        Node node = new Node(arr);
        node = recurse(node);
        node.print();
        DoubleNode doubleNode = new DoubleNode(arr);
        DoubleNode.print(doubleNode);
        DoubleNode.printDoubleLinkedList(doubleNode);

//        doubleNode = DoubleNode.reverseList(doubleNode);
//        DoubleNode.printDoubleLinkedList(doubleNode);
//        DoubleNode.print(doubleNode);
//        DoubleNode.print(doubleNode);
        doubleNode = DoubleNode.recurse(doubleNode);
        DoubleNode.print(doubleNode);
    }

}
