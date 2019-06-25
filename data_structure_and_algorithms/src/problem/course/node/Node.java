package problem.course.node;

import org.omg.CORBA.NO_IMPLEMENT;

import java.util.HashSet;

import static util.ArrayUtil.orderedArr;
import static util.ArrayUtil.randomArr;
import static util.PrintUtil.printNum;

public class Node {
    private int val;
    private Node next;

    public Node(int val) {
        this.val = val;
    }

    public Node(int[] vals) {
        this.val = vals[0];
        Node cur = this;
        for (int i = 1; i < vals.length; i++) {
            cur.next = new Node(vals[i]);
            cur = cur.next;
        }
    }

    public void print() {
        Node cur = this;
        while (cur != null) {
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


    public static Node toNode(Node[] nodes) {
        Node res = nodes[0];
        Node node = nodes[0];
        for (int i = 1; i < nodes.length; i++) {
            node.next = nodes[i];
            node = node.next;
        }
        node.next = null;
        return res;
    }

    public static Node[] toArray(Node node) {
        int i = 1;
        Node cur = node.getNext();
        while (cur != null) {
            i++;
            cur = cur.getNext();
        }
        Node n = node;
        Node[] nodes = new Node[i];
        for (int j = 0; j < i; j++) {
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

    public Node hasCircle() {
        Node cur = next;
        HashSet<Node> nodes = new HashSet<>();
        nodes.add(this);
        while (cur != null) {
            if (!nodes.add(cur)) return cur;
            cur = cur.next;
        }
        return null;
    }

    public static void main(String[] args){
        Node n = new Node(orderedArr(10, 10));
        n.print();
        Node[] nodes = toArray(n);
        nodes[nodes.length-1].next = nodes[3];
        System.out.println(hasCircle(n).val);

    }

    /**
     * 记第一个节点为1，入环第一个节点为i，环总长度为r。
     * 则fast与slow相遇时，假定slow之前共走了Ss个节点，且在第i+k个点上相遇， Sf = 2*Ss => Sf-Ss = Ss = n*r
     * 又 Ss = i + k + a * r => i + k =  b * r
     * 当fast回到0位置，重新走到i，需要走i步，对于low而言，则有Ss = i + k + a * r + i-1 = （i + k）+ i + a * r = ( a + b ) * r + i
     * 两个点在i处相遇
     * @param node
     * @return
     */
    public static Node hasCircle(Node node) {
        if (node == null || node.next == null || node.next.next == null) return null;
        Node fast = node.next.next;//step1
        Node slow = node.next;
        while (fast != null && fast.next != null) {
            if (fast == slow) {
                fast = node;
                while (fast != slow) {
                    slow = slow.next;
                    fast = fast.next;
                }
                return fast;
            }
            fast = fast.next.next;
            slow = slow.next;
        }
        return null;
    }


}
