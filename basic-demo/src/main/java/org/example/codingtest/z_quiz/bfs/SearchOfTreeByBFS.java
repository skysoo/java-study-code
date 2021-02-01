package org.example.codingtest.z_quiz.bfs;

import java.util.LinkedList;
import java.util.Queue;

public class SearchOfTreeByBFS {
    public static void main(String[] args) {
        TreeNode1 treeNode = new TreeNode1(10);
        treeNode.left = new TreeNode1(11);
        treeNode.right = new TreeNode1(12);
        treeNode.left.left = new TreeNode1(13);
        treeNode.left.right = new TreeNode1(14);
        treeNode.left.right.left = new TreeNode1(15);
        treeNode.left.right.left.left = new TreeNode1(16);
        treeNode.left.right.left.left.left = new TreeNode1(17);

        int bfs = bfs(treeNode);
        System.out.println("max: "+bfs);
    }

    static int bfs(TreeNode1 root){
        if (root==null) return 0;

        Queue<TreeNode1> queue = new LinkedList<>();
        queue.offer(root);

        int rightCnt = 1;
        int leftCnt = 1;
        while (!queue.isEmpty()){
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode1 poll = queue.poll();
                System.out.println(poll.val);
                if (poll.left!=null){
                    queue.offer(poll.left);
                    leftCnt += 1;
                }
                if (poll.right!=null){
                    queue.offer(poll.right);
                    rightCnt += 1;
                }
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
