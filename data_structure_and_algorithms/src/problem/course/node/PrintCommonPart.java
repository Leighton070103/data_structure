package problem.course.node;

import static util.PrintUtil.printNum;

/**
 * 打印两个有序链表的公共部分
 */
public class PrintCommonPart {

    public static void main(String[] args){
        Node node1 = new Node(new int[]{1, 2, 3, 4, 5, 6});
        Node node2 = new Node(new int[]{2, 4, 5,6 });
        System.out.println("Print common part");
        node1.print();
        System.out.println();
        node2.print();
        System.out.println();
        PrintCommonPart p = new PrintCommonPart();
        p.print(node1, node2);
    }

    public void print(Node node1, Node node2){
        while (node1 != null && node2 != null){
            if (node1.getVal() < node2.getVal()) node1 = node1.getNext();
            else if(node2.getVal() < node1.getVal()) node2 = node2.getNext();
            else {
                printNum(node1.getVal());
                node1 = node1.getNext();
                node2 = node2.getNext();
            }
        }
    }
}
