package org.example.codingtest.z_quiz.dfs;

import java.util.Stack;

public class SearchOfTreeByDFS {
    public static void main(String[] args) {
        TreeNode1 treeNode = new TreeNode1(10);
        treeNode.left = new TreeNode1(11);
        treeNode.right = new TreeNode1(12);
        treeNode.left.left = new TreeNode1(13);
        treeNode.left.right = new TreeNode1(14);
        treeNode.left.right.left = new TreeNode1(15);
        treeNode.left.right.left.left = new TreeNode1(16);
        treeNode.left.right.left.left.left = new TreeNode1(17);

        int dfs = dfs(treeNode);
        System.out.println("max: "+dfs);
    }

    static int dfs(TreeNode1 root){
        if (root==null) return 0;

        Stack<TreeNode1> stack = new Stack<>();
        stack.push(root);

        int rightCnt = 1;
        int leftCnt = 1;
        while (!stack.isEmpty()){
            TreeNode1 node = stack.pop();
            System.out.println(node.val);

            if (node.right!=null){
                stack.push(node.right);
                rightCnt += 1;
            }
            if (node.left!=null){
                stack.push(node.left);
                leftCnt += 1;
            }
        }

        return Math.max(rightCnt, leftCnt);
    }

    static class TreeNode1{
        int val;
        TreeNode1 left, right;
        TreeNode1 (int x){
            this.val = x;
        }
    }
}
