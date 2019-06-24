package problem.course.node;

import static util.PrintUtil.printNum;

public class Node {
    private int val;
    private Node next;

    public Node(int val){
        this.val = val;
    }

    public Node(int[] vals){
        this.val = vals[0];
        Node cur = this;
        for (int i = 1; i<vals.length; i++){
            cur.next = new Node(vals[i]);
            cur = cur.next;
        }
    }

    public void print(){
        Node cur = this;
        while (cur != null){
            printNum(cur.val);
            cur = cur.next;
        }
        System.out.println();
    }

    public int getVal() {
        return val;
    }

    @Override
    public String toString() {
        return val + ", ";
    }


    public static Node toNode(Node[] nodes){
        Node res = nodes[0];
        Node node = nodes[0];
        for (int i = 1; i<nodes.length; i++){
            node.next = nodes[i];
            node = node.next;
        }
        node.next = null;
        return res;
    }

    public static Node[] toArray(Node node){
        int i=1;
        Node cur = node.getNext();
        while (cur != null){
            i++;
            cur = cur.getNext();
        }
        Node n = node;
        Node[] nodes = new Node[i];
        for (int j=0; j<i; j++){
            nodes[j] = n;
            n = n.getNext();
        }
        return nodes;
    }

    public void setVal(int val) {
        this.val = val;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }


}
