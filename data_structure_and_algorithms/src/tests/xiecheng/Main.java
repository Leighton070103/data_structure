package xiecheng;

import java.util.HashSet;
import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        String[] nodes = s.split(",");
        Node head = new Node(nodes[0].charAt(0));
        Node node = head;
        for (int i=1; i<nodes.length; i++){
            node.next = new Node(nodes[i].charAt(0));
            node = node.next;
        }
        System.out.println(hasLoop(head));

    }

    static class Node{
        char val;
        Node next;
        public Node(char val){
            this.val = val;
        }
    }

    public static boolean hasLoop(Node head){
//        if(head ==null) return false;//单链表为空时，单链表没有环
//        if(head.next==null) return false;//单链表中只有头结点，而且头结点的next为空，单链表没有环
//        Node slowPtr = head.next;//p表示从头结点开始每次往后走一步的指针
//        Node fastPtr = head.next.next;//q表示从头结点开始每次往后走两步的指针
//        while(fastPtr!=null && fastPtr.next != null) //q不为空执行while循环
//        {
//            if(slowPtr.val == fastPtr.val) return true;//p与q相等，单链表有环
//            slowPtr =slowPtr.next;
//            fastPtr=fastPtr.next.next;
//        }
//        return false;
        Node node = head;
        HashSet<Character> set = new HashSet<>();
        while (node != null){
            if (!set.add(node.val)) return true;
            node = node.next;
        }
        return false;
    }


}
