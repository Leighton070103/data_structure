package problem.nodes;

import java.util.Stack;

/**
 * 给定一个链表，删除链表的倒数第 n 个节点，并且返回链表的头结点。
 */
class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {val = x;}

    @Override
    public String toString() {
        return  val +
                "->" + (next == null? "" : next);
    }
}

public class ListNodeDeletion{
    public ListNode removeNthFromEnd(ListNode head, int n) {
        Stack<ListNode> s = new Stack<>();
        ListNode ptr = head;
        while (ptr != null){
            s.push(ptr);
            ptr = ptr.next;
        }
        if (s.size() == 1) return null;
        if (n == s.size()) return head.next;
        ListNode tail = null;
        int i = 0;
        while (++i < n) {
            tail = s.pop();
        }
        s.pop();
        if (s.empty()) return tail;
        ListNode tmp = s.pop();
        tmp.next = tail;
        return head;
    }

    public static void main(String[] args){
        ListNodeDeletion d = new ListNodeDeletion();
//        ListNode n= d.removeNthFromEnd(getNode(new int[]{1, 2, 3, 4, 5}), 2);
        ListNode n= d.removeNthFromEnd(getNode(new int[]{1, 2}), 1);
        System.out.println(n.toString());
    }

   public static ListNode getNode(int[] nums){
        ListNode n = new ListNode(nums[0]);
        ListNode ptr = n;
        for (int i=1; i<nums.length; i++) {
            ptr.next = new ListNode(nums[i]);
            ptr = ptr.next;
        }
        return n;
    }

}


