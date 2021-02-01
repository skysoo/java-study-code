package org.example.codingtest.z_quiz.bfs;

import java.util.LinkedList;
import java.util.Queue;

public class NumberOfIslandBFS {
    public static void main(String[] args) {
        int answer = 0;
        char[][] grid = {{'1','1','1','0','1'},
                         {'1','1','0','0','0'},
                         {'1','1','0','0','1'},
                         {'0','0','0','0','1'}};

        m = grid.length;
        n = grid[0].length;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == '1'){
                    answer++;
                    System.out.println("=========");
                    bfsByQueue(grid,i,j);
                }
            }
        }
        System.out.println(answer);
    }

    static int m, n;
    static int[][] dirs = {{-1,0},{1,0},{0,1},{0,-1}};
    // queue 를 이용한 bfs
    private static void bfsByQueue(char[][] grid, int x, int y) {
        grid[x][y] ='0';
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[] {x,y});
        while(!queue.isEmpty()) {

            int[] p = queue.poll(); // 큐에 넣는 것 다 제외할 때까지 꺼내서 확인

            for(int[] dir :dirs) {
                int dx = p[0]+dir[0];
                int dy = p[1]+dir[1];
                if(dx>=0&& dx<m && dy>=0 && dy<n && grid[dx][dy]=='1') {
                    grid[dx][dy]='0'; // 확인된 육지는 바다로 변경 => 한번 밟은 육지는 다시 안 밟는다.
                    queue.offer(new int[] {dx, dy}); // 포인트별로 상하좌우를 다 넣는다.
                }
            }
            //}
        }
    }

    private static void bfs(char[][] grid, int i, int j) {
        int n = grid.length; //4
        int m = grid[0].length; //5

        System.out.print("grid["+i+"]["+j+"] ");

        if (i<0 || j<0 || i>=n || j>=m || grid[i][j] != '1')
            return;

        grid[i][j] = 'x';

        bfs(grid, i, j-1);//좌
        bfs(grid, i,j+1);//우
        bfs(grid, i-1, j);//상
        bfs(grid, i+1, j);//하
    }


}
