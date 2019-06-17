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
    }

    public int getVal() {
        return val;
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
