package main.java.LeetCode230;


import java.util.Stack;

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
    public int kthSmallest(TreeNode root, int k) {
        int count = 0;
        Stack<TreeNode> stack = new Stack<>();

        stack.add(root);

        do {
            while(root != null) {
                stack.add(root);
                root = root.left;
            }

            root = stack.pop();
            if(root != null) {
                count += 1;
                if( count == k) {
                    return root.val;
                }
            }

            root = root.right;
        } while(!stack.isEmpty());

        return 0;
    }
}
