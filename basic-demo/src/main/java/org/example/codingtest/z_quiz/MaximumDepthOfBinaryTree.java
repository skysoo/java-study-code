package org.example.codingtest.z_quiz;


/**
 * 가장 깊은 곳의 깊이를 구해라.
 * tree 문제이고, 0은 null을 뜻한다.
 *
 * 순서대로 top, left, right, left-left-child, left-right-child, right-left-child, right-right-child
 **/
public class MaximumDepthOfBinaryTree {
    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(3);
        treeNode.left = new TreeNode(9);
        treeNode.right = new TreeNode(20);
        treeNode.right.left = new TreeNode(15);
        treeNode.right.right = new TreeNode(7);

        int solution = maxDepth(treeNode);
        System.out.println(solution);
    }

    /**
     * 1. 먼저 트리에 담는다.
     **/
    static int maxDepth(TreeNode root){
        if (root==null)
            return 0;

        int leftMax = maxDepth(root.left);
        int rightMax = maxDepth(root.right);
        System.out.println("leftMax: "+leftMax+" rightMax: "+rightMax);
        return Math.max(leftMax, rightMax)+1;
    }

    static class TreeNode {
        int val;
        TreeNode left, right;

        TreeNode(int x){
            this.val = x;
        }
    }
}