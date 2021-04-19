package main.java.LeetCode1315;


import java.util.LinkedList;
import java.util.Queue;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

public class Solution {
    // 부모의 부모 노드의 값이 짝수인 자식 노드의 value의 합
    // 결국 짝수 노드의 자식의 자식들의 노드 value의 합

    public int sumEvenGrandparent(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        int sum = 0;

        while(!queue.isEmpty()) {
            TreeNode tn = queue.poll();
            if(tn.val %2 == 0) sum += getGrandChildSum(tn);

            if(tn.left != null) queue.offer(tn.left);
            if(tn.right != null) queue.offer(tn.right);
        }

        return sum;
    }

    public int getGrandChildSum(TreeNode root) {
        TreeNode tl = root.left != null ? root.left : new TreeNode();
        TreeNode tr = root.right != null ? root.right : new TreeNode();

        int sum = 0;

        if(tl.left != null) sum += tl.left.val;
        if(tl.right != null) sum += tl.right.val;
        if(tr.left != null) sum += tr.left.val;
        if(tr.right != null) sum += tr.right.val;

        return sum;
    }

}
