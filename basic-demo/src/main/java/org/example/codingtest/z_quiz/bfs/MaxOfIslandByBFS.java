package org.example.codingtest.z_quiz.bfs;

import java.util.LinkedList;
import java.util.Queue;

public class MaxOfIslandByBFS {
    static int max = 0;
    public static void main(String[] args) {
        char[][] island = {{'1','1','0','1','1'},
                           {'0','1','1','0','0'},
                           {'0','0','0','0','0'},
                           {'1','1','0','1','1'},
                           {'1','0','1','1','1'},
                           {'1','0','1','1','1'}};

        int cnt = 0;
        for (int i = 0; i < island.length; i++) {
            for (int j = 0; j < island[i].length; j++) {
                if (island[i][j]=='1'){
                    cnt++;
                    print(island);
                    bfs(island, i,j);
                }
            }
        }

        System.out.println("total cnt : "+cnt);
        System.out.println("max : "+ max);
    }

    /**
     * 큐를 이용한 BFS
     *
     * 확인된 육지는 0으로 변경
     **/
    static int[][] dirs = {{-1,0},{1,0},{0,-1},{0,1}}; // 상, 하, 좌, 우
    static void bfs(char[][] island, int x, int y){
        int cur = 1; // 이미 육지인 곳 부터 시작하므로 1부터 시작

        island[x][y] = '0';
        int n = island.length;
        int m = island[0].length;

        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{x,y}); // 현재 포인트를 큐에 담는다.

        while (!queue.isEmpty()){
            int[] poll = queue.poll();

            for (int[] dir : dirs) {
                int dx = poll[0] + dir[0];
                int dy = poll[1] + dir[1];

                if (dx>=0 && dy>=0 && dx<n && dy<m && island[dx][dy] == '1'){
                    queue.offer(new int[]{dx,dy});
                    island[dx][dy] = '0';
                    cur += 1;
                    max = Math.max(max, cur);
                }
            }
        }
    }

    public static void print(char[][] island){
        for (int i = 0; i < island.length; i++) {
            for (int i1 = 0; i1 < island[0].length; i1++) {
                System.out.print(island[i][i1] + " ");
            }
            System.out.println();
        }
        System.out.println("=======================");
    }
}
