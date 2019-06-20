package problem.course.node;

import java.util.Stack;

/**
 * 判断一个链表是否为回文结构
 */
public class IsPalindromeList {
    /**
     * n extra space
     * @param node
     * @return
     */
    boolean isPalindromeList1(Node node){
        Stack<Node> stack = new Stack<Node>();
        Node cur = node;
        while (cur != null) {
            stack.push(cur);
            cur = cur.getNext();
        }
        while (node != null) {
            if (node.getVal() != stack.pop().getVal()) {
                return false;
            }
            node = node.getNext();
        }
        return true;
    }

    /**
     * n/2 extra space
     * @param node
     * @return
     */
    boolean isPalindromeList2(Node node){
        if (node == null || node.getNext() == null) {
            return true;
        }
        Node right = node.getNext();
        Node cur = node;
        while (cur.getNext() != null && cur.getNext().getNext() != null) {
            right = right.getNext();
            cur = cur.getNext().getNext();
        }
        Stack<Node> stack = new Stack<Node>();
        while (right != null) {
            stack.push(right);
            right = right.getNext();
        }
        while (!stack.isEmpty()) {
            if (node.getVal() != stack.pop().getVal()) {
                return false;
            }
            node = node.getNext();
        }
        return true;
    }

    /**
     * 技术个时来到重点位置，偶数位时来到中点前一位
     * @param node
     * @return
     */
    public boolean isPalindrome3(Node node) {
        if (node == null || node.getNext() == null) {
            return true;
        }
        Node n1 = node;//走一步
        Node n2 = node;//走两步
        while (n2.getNext() != null && n2.getNext().getNext() != null) { // find mid node
            n1 = n1.getNext(); // n1 -> mid
            n2 = n2.getNext().getNext(); // n2 -> end
        }
        n2 = n1.getNext(); // n2 -> right part first node
        n1.setNext(null); // mid.next -> null
        Node n3 = null;
        while (n2 != null) { // right part convert
            n3 = n2.getNext(); // n3 -> save next node
            n2.setNext(n1); // next of right node convert
            n1 = n2; // n1 move
            n2 = n3; // n2 move
        }
        n3 = n1; // n3 -> save last node
        n2 = node;// n2 -> left first node
        boolean res = true;
        while (n1 != null && n2 != null) { // check palindrome
            if (n1.getVal() != n2.getVal()) {
                res = false;
                break;
            }
            n1 = n1.getNext(); // left to mid
            n2 = n2.getNext(); // right to mid
        }
        n1 = n3.getNext();
        n3.setNext(null);
        while (n1 != null) { // recover list
            n2 = n1.getNext();
            n1.setNext(n3);
            n3 = n1;
            n1 = n2;
        }
        return res;
    }
}
