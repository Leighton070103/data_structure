package problem.recursivelist;

import static util.PrintUtil.printNum;

public class DoubleNode {
    int val;
    DoubleNode pre;
    DoubleNode next;
    DoubleNode(int val){
        this.val = val;
        pre = null;
        next = null;
    }

    DoubleNode(int[] arr){
        this.val = arr[3];
        this.addFirst(new DoubleNode(arr[2]));
        this.addFirst(new DoubleNode(arr[1]));
        this.addFirst(new DoubleNode(arr[0]));
        for (int i = 4; i < arr.length; i++) this.add(new DoubleNode(arr[i]));

    }

    public void add(DoubleNode node){

            DoubleNode last = this;
            while (last.next != null) last = last.next;
            node.pre = last;
            last.next = node;

    }

    public void addFirst(DoubleNode node){
        DoubleNode first = this;
        while (first.pre != null) first = first.pre;
        node.next = first;
        first.pre = node;
    }

    public static DoubleNode getFirst(DoubleNode node){
        if (node == null) return null;
        while (node.pre != null) node = node.pre;
        return node;
    }

    public static DoubleNode reverseList(DoubleNode head) {
        DoubleNode pre = null;
        DoubleNode next = null;
        while (head != null) {
            next = head.next;
            head.next = pre;
            head.pre = next;
            pre = head;
            head = next;
        }
        return pre;
    }

    public static void printDoubleLinkedList(DoubleNode head) {
        System.out.print("Double Linked List: ");
        DoubleNode end = null;
        while (head != null) {
            System.out.print(head.val + " ");
            end = head;
            head = head.next;
        }
        System.out.print("| ");
        while (end != null) {
            System.out.print(end.val + " ");
            end = end.pre;
        }
        System.out.println();
    }

    public static void print(DoubleNode node){
        node = getFirst(node);
        while (node != null){
            printNum(node.val);
            node = node.next;
        }
        System.out.println();
    }


    public static DoubleNode recurse(DoubleNode node){
        DoubleNode current = getFirst(node);
        DoubleNode pre = null;
        DoubleNode next;
        while (current != null){
            next = current.next;
            current.next = pre;
            current.pre = next;
            pre = current;
            current = next;
        }
        return pre;
    }
}
