package org.example.codingtest.test;

public class Test1 {
    private static final Test1 o = new Test1();
    public static void main(String[] args) {
        int[][] location = {{0,3},{1,1},{1,5},{2,2},{3,3},{4,0}};

        int[] s = {1,4};
        int[] e = {4,1};
        int solution = o.solution(location, s, e);
        System.out.println(solution);
    }

    public int solution(int[][] location, int[] s, int[] e) {
        int answer = 0;

        for (int i = 0; i < location.length; i++) {
            int px = location[i][0];
            int py = location[i][1];
            if (valid(px,py,s,e)){
                answer++;
            }
        }

        return answer;
    }

    boolean valid(int px, int py,int[] s, int[] e){
        int sx = Math.min(s[0],e[0]);
        int sy = Math.min(s[1],e[1]);
        int ex = Math.max(s[0],e[0]);
        int ey = Math.max(s[1],e[1]);

        if (sx<=px && px<=ex && sy <= py && py <= ey){
            System.out.println("px : " +px + " py: "+py);
            return true;
        }
        return false;
    }
}
