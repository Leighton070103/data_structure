package problem.course.node;

import java.util.HashSet;

import static problem.course.node.Node.toArray;
import static util.ArrayUtil.orderedArr;

/**
 * 单链表可能有环,也可能无环。给定两个单链表的头节点 head1和head2,这两个链表可能相交,也可能不相交。请实现一个函数, 如果两个链表相交,请
 * 返回相交的第一个节点;如果不相交,返回null 即可。
 * 要求:如果链表1的长度为N,链表2的长度为M,时间复杂度请达到 O(N+M), 额外空间复杂度请达到O(1)。
 */
public class FindFirstIntersectNode {

    public static void main(String[] args){
        Node n1 = new Node(orderedArr(10, 10));
        n1.print();
        Node[] nodes1 = toArray(n1);
        Node n2 = new Node(orderedArr(3, 3));
        n2.print();
        Node[] nodes2 = toArray(n2);
        nodes2[nodes2.length-1].setNext(nodes1[2]);
        FindFirstIntersectNode f = new FindFirstIntersectNode();
        System.out.println(f.solve(n1, n2));
        nodes1[nodes1.length-1].setNext(nodes1[3]);
    }

    public Node solve(Node n1, Node n2) {
        Node loop1 = Node.hasCircle(n1);
        Node loop2 = Node.hasCircle(n2);
        if (loop1 == null && loop2 != null || loop1 != null && loop2 == null) return null;
        if (loop1 == loop2) {
            int count1 = 0;
            int count2 = 0;
            Node cur1 = n1;
            Node cur2 = n2;
            while (cur1 != loop1) {
                cur1 = cur1.getNext();
                count1++;
            }
            while (cur2 != loop2) {
                cur2 = cur2.getNext();
                count2++;
            }
            if (count1 > count2) {
                cur1 = n1;
                while (count1 > count2) {
                    cur1 = cur1.getNext();
                    count1--;
                }
                cur2 = n2;
            } else if (count1 < count2) {
                cur2 = n2;
                while (count2 > count1) {
                    cur2 = cur2.getNext();
                    count2--;
                }
                cur1 = n1;
            }

            while (cur1 != loop1) {
                if (cur1 == cur2) return cur1;
                cur1 = cur1.getNext();
                cur2 = cur2.getNext();
            }
            return loop1;
        }

        Node cur = loop1;
        do {
            cur = cur.getNext();
            if (cur == loop2) return loop1;
        } while (cur != loop1);
        return null;
    }
}
