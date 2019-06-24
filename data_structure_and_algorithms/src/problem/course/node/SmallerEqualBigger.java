package problem.course.node;

import static util.ArrayUtil.randomArr;

/**
 * 将单链表按某值划分为小于等于大于
 *
 */
public class SmallerEqualBigger {

    public static void main(String[] args){
        Node node = new Node(randomArr(10, 10));
        System.out.println("Original node");
        node.print();
        SmallerEqualBigger s = new SmallerEqualBigger();
        System.out.println("Current");
        s.solve(node, 5).print();
        System.out.println("Advanced");
        s.advanced(node, 5).print();
    }

    /**
     *  保持稳定性，O(N), O(1)
     */
    public Node advanced(Node node, int val){
        Node cur = node;
        Node sHead = null;
        Node sTail = null;
        Node bHead = null;
        Node bTail = null;
        Node eHead = null;
        Node eTail = null;
        while (cur != null){
            if (cur.getVal() < val){
                if (sHead == null){
                    sHead = cur;
                    sTail = cur;
                }
                else {
                    sTail.setNext(cur);
                    sTail = sTail.getNext();
                }
            }
            else if (cur.getVal() > val){
                if (bHead == null){
                    bHead = cur;
                    bTail = cur;
                }
                else {
                    bTail.setNext(cur);
                    bTail = bTail.getNext();
                }
            }
            else {
                if (eHead == null){
                    eHead = cur;
                    eTail = cur;
                }
                else {
                    eTail.setNext(cur);
                    eTail = eTail.getNext();
                }
            }
            cur = cur.getNext();
        }
        if (sHead != null)  {
           if (eHead != null) {
               sTail.setNext(eHead);
           }
           else sTail.setNext(bHead);
        }
       if(eHead != null) eTail.setNext(bHead);
       if (bHead != null) bTail.setNext(null);

       if (sHead != null) return sHead;
       if (eHead != null) return eHead;
        return bHead;
    }

    public Node solve(Node node, int val){
        Node[] nodes = Node.toArray(node);
        for (int i=0, s = -1, l = nodes.length; i<l;){
            if (nodes[i].getVal() < val) swap(nodes, ++s, i++);
            else if (nodes[i].getVal() > val) swap(nodes, --l, i);
            else i++;
        }
        return Node.toNode(nodes);
    }

    private void swap(Node[] nodes, int a, int b){
        Node tmp = nodes[a];
        nodes[a] = nodes[b];
        nodes[b] = tmp;
    }
}
