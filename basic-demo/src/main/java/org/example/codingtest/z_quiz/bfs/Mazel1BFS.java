package org.example.codingtest.z_quiz.bfs;

import java.util.LinkedList;
import java.util.Queue;

/**
 *
 * BFS를 쓴다는 것은 Queue를 쓴다는 것
 *
 * input으로 start와 destination이 주어진다.
 *
 * 0은 갈 수 있는 공간, 1은 갈 수 없는 공간
 * 출발 지점으로 부터 목적지까지 갈 수 있느냐?를 boolean 타입으로 리턴해야 한다.
 **/
public class Mazel1BFS {
    private static final Mazel1BFS o = new Mazel1BFS();
    public static void main(String[] args) {
        int start[] = {0,4};
        int end[] = {4,4};
        char[][] grid = {
                {'0','0','1','0','0'},
                {'0','0','0','0','0'},
                {'0','0','0','1','0'},
                {'1','1','0','1','1'},
                {'0','0','0','0','0'}};

        boolean solve = o.solve(grid, start, end);
        System.out.println(solve);
    }

    private boolean solve(char[][] grid, int[] start, int[] end) {
        int m = grid.length; //5
        int n = grid[0].length; //5

        boolean[][] visited = new boolean[n][m];

        return bfs(grid,start,end,m,n,visited);
    }

    private int[][] dirs = {{-1,0},{1,0},{0,-1},{0,1}};
    private boolean bfs(char[][] grid, int[] start, int[] end, int m, int n, boolean[][] visited) {

        Queue<int[]> queue = new LinkedList<>();
        queue.offer(start);
        visited[start[0]][start[1]] = true;

        while (!queue.isEmpty()){
            int[] poll = queue.poll();

            if (end[0] == poll[0] && end[1] == poll[1])
                return true;

            for (int[] dir : dirs) {
                int dx = poll[0] + dir[0];
                int dy = poll[1] + dir[1];

                if (dx>=0 && dy>=0 && dx<m && dy<n && !visited[dx][dy] && grid[dx][dy] == '0'){
                    visited[dx][dy] = true;
                    queue.offer(new int[]{dx,dy});
                    System.out.println("grid["+dx+"]["+dy+"]:"+grid[dx][dy]);
                }
            }
        }
        return false;
    }
}
