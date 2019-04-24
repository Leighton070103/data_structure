package problem;

import java.util.Scanner;
import java.util.Stack;

public class Main {

    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        String[] vals = scanner.nextLine().split(",");
        int i = 0;

    }
    public boolean isValidBST(BinaryNode root) {
        if(root == null)
            return true;
        Stack<BinaryNode> stack = new Stack<>();
        BinaryNode cur = root;
        BinaryNode pre = null;
        while(!stack.isEmpty() || cur != null){
            if(cur != null){
                stack.push(cur);
                cur = cur.left;
            }else {
                cur = stack.pop();
                if(pre != null && cur.val <= pre.val)
                    return false;
                pre = cur;
                cur = cur.right;
            }
        }
        return true;
    }

    class BinaryNode {
        int val;
        BinaryNode left;
        BinaryNode right;
        BinaryNode(int val){
            this.val = val;
        }
    }
}
