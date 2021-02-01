package org.example.codingtest.z_quiz;


/**
 * 그리드 내에 조건에 부합하는 경우를 찾는다. 있다면 true, 하나라도 없으면 false
 * <p>
 * dfs 는 쭉 타고 나와야 되기 때문에 하나라도 걸리는게 있으면 빠져나와야 된다.
 * <p>
 * bfs 는 조건에 부합하는 것만 걸러내면 된다.
 **/
public class WordSearch {
    private static final WordSearch o = new WordSearch();

    public static void main(String[] args) {
        char[][] grid = {{'A', 'B', 'C', 'E'},
                {'S', 'F', 'C', 'S'},
                {'A', 'D', 'E', 'E'}};
        String word = "ABCCED";

        boolean solve = o.solve(grid, word);
        System.out.println("answer : " + solve);

    }

    private boolean solve(char[][] grid, String word) {
        if (grid == null || grid.length == 0 || grid[0].length == 0)
            return false;

        int m = grid.length; //3
        int n = grid[0].length; //4
        boolean[][] visited = new boolean[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (!visited[i][j]) { //false면 방문하지 않았다는 뜻
                    if (dfs(grid, word, i, j, visited, 0, m, n)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    private boolean dfs(char[][] grid, String word, int x, int y, boolean[][] visited, int start, int m, int n) {
        // 모두 통과
        if (start == word.length()) return true;
        // 제외 사항
        if (x < 0 || y < 0 || x >= m || y >= n) return false;
        // 이미 방문했던 경우 제외
        if (visited[x][y]) return false;
        // 대상이 아닐 경우 제외
        if (grid[x][y] != word.charAt(start)) return false;

        // 모두 통과했을 때
        visited[x][y] = true;
        System.out.println("grid[" + x + "][" + y + "]: " + grid[x][y]);

        for (int[] dir : dirs) {
            int dx = dir[0] + x;
            int dy = dir[1] + y;
            dfs(grid, word, dx, dy, visited, start + 1, m, n);
        }
        return true;
    }

}
