package problem.leetcoderegular;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }

    @Override
    public String toString() {
        return val+", ";
    }

    void print(){
        Queue<TreeNode> queue = new LinkedList<>();
        System.out.print(this);
        if (left != null) queue.add(left);
        if (right != null) queue.add(right);
        while (!queue.isEmpty()){
            TreeNode n = queue.poll();
            System.out.print(n);
            if (n.left != null) queue.add(n.left);
            if (n.right != null) queue.add(n.right);
        }
    }

//    static TreeNode build(Integer[] vals){
//        int index = 0;
//        TreeNode node = new TreeNode(vals[0]);
//        TreeNode cur = node;
//
//        return node;
//    }
}
public class IncresingBST {


    public static void main(String[] args){
        TreeNode node = new TreeNode(5);
        node.left = new TreeNode(3);
        node.left.left = new TreeNode(2);
        node.left.right = new TreeNode(4);
        node.left.left.left = new TreeNode(1);
        node.right = new TreeNode(6);
        node.right.right = new TreeNode(8);
        node.right.right.left = new TreeNode(7);
        node.right.right.right = new TreeNode(9);
        IncresingBST i = new IncresingBST();
        i.increasingBST(node).print();


    }

    public TreeNode increasingBST(TreeNode root) {
        // = new TreeNode();
        LinkedList<TreeNode> nodes = new LinkedList<>();
        build(nodes, root);
        TreeNode res = nodes.pollFirst();
        TreeNode cur = res;

        while (!nodes.isEmpty()){
            cur.right = nodes.poll();
            cur.left = null;
            cur = cur.right;
        }
        cur.right = null;
        cur.left = null;

        return res;
    }

    public void build(LinkedList<TreeNode> nodes, TreeNode node){

        if (node != null) {
            build(nodes, node.left);
            nodes.add(node);
            build(nodes, node.right);
        }

    }
}
