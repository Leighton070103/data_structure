package datastructure;

import java.util.Stack;

public class BinaryTree<T> {
    T val;
    BinaryTree<T> left;
    BinaryTree<T> right;
    BinaryTree(T data){
        val = data;
    }

    @Override
    public String toString() {
        return "val: " + val + "; ";
    }

    /**
     * 先序遍历：根左右
     * 先打印左子树，再打印右子树
     */
    static void preOrderRer(BinaryTree node){
        if (node == null) return;
        System.out.print(node);
        preOrderRer(node.left);
        preOrderRer(node.right);
    }

    static void preOrderTra(BinaryTree node){
        if (node == null) return;
        Stack<BinaryTree> stack = new Stack<>();
        stack.add(node);
        BinaryTree cur;
        while (!stack.empty()){
            cur = stack.pop();
            System.out.print(cur);
            if (cur.right != null) stack.push(cur.right);
            if (cur.left != null) stack.push(cur.left);
        }

    }

    /**
     * 中序遍历：左根右
     * @param node
     */
    static void inOrderRec(BinaryTree node){
        if (node == null) return;
        inOrderRec(node.left);
        System.out.print(node);
        inOrderRec(node.right);
    }

    static void inOrderTra(BinaryTree node){
        if (node == null) return;
        Stack<BinaryTree> stack = new Stack<>();
        BinaryTree cur = node;
        while (!stack.isEmpty() || cur != null){
            if (cur != null){
                stack.add(cur);
                cur = cur.left;
            }
            else {
                cur = stack.pop();
                System.out.print(cur);
                cur = cur.right;
            }
        }
    }

    /**
     * 后续遍历：左右根
     * @param node
     */
    static void postOrderRec(BinaryTree node){
        if (node == null) return;
        postOrderRec(node.left);
        postOrderRec(node.right);
        System.out.print(node);
    }

    static void postOrderTra(BinaryTree node){
        if (node == null) return;
        Stack<BinaryTree> s1 = new Stack<>();
        Stack<BinaryTree> s2 = new Stack<>();
        s1.add(node);
        BinaryTree cur;
        while (!s1.empty()){
            cur = s1.pop();
            s2.add(cur);
            if (cur.left != null) s1.add(cur.left);
            if (cur.right != null) s1.add(cur.right);
        }
        while (!s2.empty()) System.out.print(s2.pop());
    }


}
