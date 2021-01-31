package org.example.codingtest.test;

public class Test3 {
    private static final Test3 o = new Test3();
    public static void main(String[] args) {
        int[] value = {10, 1, 10, 1, 1, 4, 3, 10};
        int k =6;
        int solution = o.solution(value, k);
        System.out.println(solution);
    }

    public int solution(int[] estimates, int k) {
        int answer = 0;

        for (int i = 0; i <= estimates.length-k; i++) {
            int sum = 0;
            for (int j = i; j < k+i; j++) {
                sum+=estimates[j];
            }
            answer = Math.max(answer,sum);
        }

        return answer;
    }
}
