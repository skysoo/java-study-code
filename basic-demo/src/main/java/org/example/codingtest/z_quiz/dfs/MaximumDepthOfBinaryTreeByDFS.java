package org.example.codingtest.z_quiz.dfs;

import java.util.Stack;

/**
 * 스택 방식의 DFS로 문제를 푼다.
 *
 **/
public class MaximumDepthOfBinaryTreeByDFS {
    public static void main(String[] args) {
        TreeNode1 treeNode = new TreeNode1(1);
        treeNode.left = new TreeNode1(2);
        treeNode.right = new TreeNode1(3);
        treeNode.left.left = new TreeNode1(4);
        treeNode.left.right = new TreeNode1(5);
        treeNode.left.left.left = new TreeNode1(6);

        int dfs = dfs(treeNode);
        System.out.println("max: "+dfs);
    }

    /**
     * 스택 DFS
     **/
    static int dfs(TreeNode1 root){
        Stack<TreeNode1> stack = new Stack<>();
        Stack<Integer> valueStack = new Stack<>();
        stack.push(root);
        valueStack.push(1);

        int maxDepth = 0; // 깊이

        while (!stack.isEmpty()){
            TreeNode1 node = stack.pop();
            System.out.println(node.val);

            int currentNodeDepth = valueStack.pop();
            maxDepth = Math.max(maxDepth, currentNodeDepth);

            if (node.right!=null){
                stack.push(node.right);
                valueStack.push(currentNodeDepth+1);
            }
            if (node.left != null){
                stack.push(node.left);
                valueStack.push(currentNodeDepth+1);
            }
        }
        return maxDepth;
    }

    static class TreeNode1{
        int val;
        TreeNode1 left, right;
        TreeNode1 (int x){
            this.val = x;
        }
    }
}
