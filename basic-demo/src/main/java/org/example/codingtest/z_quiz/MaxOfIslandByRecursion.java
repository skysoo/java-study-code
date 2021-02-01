package org.example.codingtest.z_quiz;

/**
 * 1은 육지, 0은 바다
 *
 * 가장 큰 육지의 크기를 구하라.
 **/
public class MaxOfIslandByRecursion {
    static int cnt =0;
    static int max = 0;

    public static void main(String[] args) {
        char[][] grid = {{'1','1','0','1','1'},
                         {'0','1','1','0','0'},
                         {'0','0','0','0','0'},
                         {'1','1','0','1','1'},
                         {'1','0','1','1','1'},
                         {'1','0','1','1','1'}};

        int totalCnt = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j]=='1'){
                    recursion(grid, i,j);
                    cnt=0;
                    totalCnt++;
                }
            }
        }

        System.out.println("max : "+max);
        System.out.println("total : "+totalCnt);
    }

    static void recursion(char[][] grid, int i, int j){
        int n = grid.length;
        int m = grid[0].length;

        if (i<0 || j<0 || i>=n || j>=m || grid[i][j] != '1')
            return;

        System.out.println("grid["+i+"]["+j+"]");

        grid[i][j] ='x';
        cnt+=1;

        recursion(grid,i+1,j);
        recursion(grid, i-1,j);
        recursion(grid,i,j+1);
        recursion(grid,i,j-1);

        max = Math.max(max,cnt);
    }
}
