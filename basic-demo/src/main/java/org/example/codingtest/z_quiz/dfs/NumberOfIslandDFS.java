package org.example.codingtest.z_quiz.dfs;

/**
 * dfs 문제이다.
 * 육지와 바다가 주어진 배열에서 육지의 갯수를 구해라.
 * 1은 육지, 0은 바다
 *
 * 육지의 갯수이기 때문에 1의 갯수가 아니라 1덩어리의 갯수를 구해야 한다.
 *
 * 이중 for문으로 0을 만나는 순간 리턴하고 카운팅 해주는 것을 반복한다.
 **/
public class NumberOfIslandDFS {
    public static void main(String[] args) {
        int answer = 0;
        char[][] grid = {{'1','1','1','0','1'},
                         {'1','1','0','0','0'},
                         {'1','1','0','0','1'},
                         {'0','0','0','0','1'}};

        print(grid);

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                System.out.println(grid[i][j]);
                if((int) grid[i][j] =='1'){
                    answer++;
                    dfs(grid, i, j);
                    System.out.println("==========");
                }
            }
        }
        System.out.println("answer : "+answer);

    }

    static int cnt = 0;
    public static void dfs(char[][] grid, int i, int j){
        int m = grid.length;
        int n = grid[0].length;

        System.out.print("cnt : "+ cnt++ + " grid[" + i + "]["+j+"] ");

        if (i<0 || i>=m || j<0 || j>=n || grid[i][j] != '1')
            return;

        // 통과한 애들은 x로 값을 넣는다. -> 다시 체크할 필요가 없기 때문에
        grid[i][j] = 'x';

        dfs(grid, i-1, j); //상
        dfs(grid, i+1, j); //하
        dfs(grid, i, j-1); //좌
        dfs(grid, i, j+1); //우
    }

    public static void print(char[][] grid){
        for (int i = 0; i < grid.length; i++) {
            for (int i1 = 0; i1 < grid[0].length; i1++) {
                System.out.print(grid[i][i1] + " ");
            }
            System.out.println();
        }
        System.out.println("=======================");
    }
}
