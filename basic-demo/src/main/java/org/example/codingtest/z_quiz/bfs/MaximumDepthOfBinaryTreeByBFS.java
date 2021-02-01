package org.example.codingtest.z_quiz.bfs;

import java.util.LinkedList;
import java.util.Queue;

public class MaximumDepthOfBinaryTreeByBFS {
    public static void main(String[] args) {
        TreeNode1 treeNode = new TreeNode1(3);
        treeNode.left = new TreeNode1(1);
        treeNode.right = new TreeNode1(4);
        treeNode.left.left = new TreeNode1(5);
        treeNode.left.right = new TreeNode1(8);
        treeNode.left.left.left = new TreeNode1(7);

        int bfs = bfs(treeNode);
        System.out.println("bfs : "+bfs);
    }

    static int bfs(TreeNode1 root){
        if (root==null)
            return 0;

        Queue<TreeNode1> queue = new LinkedList<>();
        queue.offer(root);
        int count = 0;

        while (!queue.isEmpty()){
            System.out.println("queue size : "+queue.size());
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode1 poll = queue.poll();
                System.out.println(poll.val);

                if (poll.left!=null){
                    queue.offer(poll.left);
                }
                if (poll.right!=null){
                    queue.offer(poll.right);
                }
            }
            count++;
        }

        return count;
    }

    static class TreeNode1 {
        int val;
        TreeNode1 left, right;
        TreeNode1 (int x){
            this.val = x;
        }
    }
}
