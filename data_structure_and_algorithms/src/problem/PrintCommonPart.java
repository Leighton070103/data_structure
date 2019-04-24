package problem;

import datastructure.LinkedList;

import static util.ArrayUtil.orderedRandGapArray;
import static util.PrintUtil.*;

public class PrintCommonPart {

    public static void main(String[] args){
        int[] arrA = orderedRandGapArray(15, 0, 2);
        int[] arrB = orderedRandGapArray(10, 0, 2);
        printArr(arrA);
        printArr(arrB);
        LinkedList<Integer> nodeA = new LinkedList<>(arrA[0]);
        for (int i = 1; i<arrA.length; i++) nodeA.add(new LinkedList(arrA[i]));
        LinkedList<Integer> nodeB = new LinkedList<>(arrB[0]);
        for (int i = 1; i<arrB.length; i++) nodeB.add(new LinkedList(arrB[i]));
        System.out.println("Printing common part...");
        printCommonPart(nodeA, nodeB);
    }

    public static void printCommonPart(LinkedList nodeA, LinkedList nodeB){
        LinkedList<Integer> aPtr = nodeA;
        LinkedList<Integer> bPtr = nodeB;
        while (aPtr != null && bPtr != null){
            if (aPtr.getValue() == bPtr.getValue()){
                printNum(aPtr.getValue());
                aPtr = aPtr.getNext();
                bPtr = bPtr.getNext();
            }
            else if (aPtr.getValue() < bPtr.getValue()) aPtr = aPtr.getNext();
            else if (aPtr.getValue() > bPtr.getValue()) bPtr = bPtr.getNext();
        }
    }
}
