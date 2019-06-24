package problem.course.node;

import java.util.HashMap;
import java.util.Map;

import static util.ArrayUtil.randomArr;
import static util.NumUtil.randomNum;

/**
 * 一种特殊的链表节点类描述如下:
 * public class Node { public int value; public Node next; public
 * Node rand;
 * public Node(int data) { this.value = data; }
 * }
 * Node类中的value是节点值,next指针和正常单链表中next指针的意义一样,都指向下一个节点,
 * rand指针是Node类中新增的指针,这个指针可能指向链表中的任意一个节点,也可能指向null。
 * 给定一个由Node节点类型组成的无环单链表的头节点head,请实现一个函数完成
 * 这个链表中所有结构的复制,并返回复制的新链表的头节点。
 * 进阶:
 * 不使用额外的数据结构,只用有限几个变量,且在时间复杂度为 O(N)内完成原问题要实现的函数。
 */

class SpNode {
    int value;
    SpNode next;
    SpNode rand;

    public SpNode(int data) {
        this.value = data;
    }

    public static void print(SpNode sp){
        SpNode cur = sp;
        while (cur != null) {
            System.out.print(cur);
            cur = cur.next;
        }
        System.out.println();
    }

    public static SpNode getInstance (int[] arr){
        SpNode res = new SpNode(arr[0]);
        SpNode rHead = res;
        SpNode[] spNodes = new SpNode[arr.length];
        spNodes[0] = res;
        for (int i=0; i<arr.length-1; i++){
            res.next = new SpNode(arr[i+1]);
            res = res.next;
            spNodes[i+1] = res;
        }
        res = rHead;
        while (res != null){
            int r = randomNum(-1, arr.length-1);
            if (r != -1) res.rand = spNodes[r];
            res = res.next;
        }
        return rHead;
    }

    @Override
    public String toString() {
        return "{value: "+value + "; next:" + (next!=null? next.value: "null") + "; rand: " + (rand != null? rand.value: "null") + "}, ";
    }
}

public class CopyListWithRandom {

    public static void main(String[] args){
        SpNode sp = SpNode.getInstance(randomArr(10, 14));
        SpNode.print(sp);
        CopyListWithRandom c = new CopyListWithRandom();
        System.out.println("result: ");
        SpNode.print(c.advanced(sp));
    }

    SpNode advanced(SpNode node){
        SpNode cp;
        SpNode cur = node;
        while (cur != null){
            SpNode tmp = cur.next;
            cur.next = new SpNode(cur.value);
            cur.next.next = tmp;
            cur = tmp;
        }
        cur = node;
        cp = cur.next;
        SpNode tCur = cp;
        while (cur != null){
            SpNode tNext = cur.next.next;
            tCur.next = tNext == null? null: tNext.next;
            tCur.rand = cur.rand;
            cur.next = tNext;
            tCur = tCur.next;
            cur = tNext;
        }
        return cp;
    }

    SpNode solve(SpNode node){
        Map<SpNode, SpNode> nMap = new HashMap<>();
        SpNode cur = node;
        while (cur != null){
            nMap.put(cur, new SpNode(cur.value));
            cur = cur.next;
        }
        cur = node;
        while (cur != null){
            nMap.get(cur).next = nMap.get(cur.next);
            nMap.get(cur).rand = nMap.get(cur.rand);
            cur = cur.next;
        }
        return nMap.get(node);
    }
}
