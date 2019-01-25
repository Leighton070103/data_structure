package problem.recursivelist;

import static util.PrintUtil.printNum;

public class Node {
    int val;
    Node next;
    int count;

    Node(int val){
        this.val = val;
        next = null;
        count = 1;
    }

    Node(int[] arr){
        Node.this.val = arr[0];
        for (int i = 1; i<arr.length; i++) this.add(new Node(arr[i]));
    }

    void add(Node node){
        Node current = this;
        while (current.next != null) current = current.next;
        current.next = node;
        count++;
    }

    void print(){
        Node node = this;
        while (node != null){
            printNum(node.val);
            node = node.next;
        }
        System.out.println();
    }

    public static Node recurse(Node node){
        Node pre = null;
        Node next = null;
        while (node != null){
            next = node.next;
            node.next = pre;
            pre = node;
            node = next;
        }
        return pre;
    }
}
