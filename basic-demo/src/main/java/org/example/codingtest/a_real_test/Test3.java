package org.example.codingtest.a_real_test;

public class Test3 {
    private static final Test3 o = new Test3();
    public static void main(String[] args) {
        int[] value = {10, 1, 10, 1, 1, 4, 3, 10};
        int k =3;
        int solution = o.solution(value, k);
        System.out.println(solution);
    }

    /**
     *
     * 점화식 : dp[n] = max(0, dp[n-1]) + arr[n]
     *
     **/
    public int solutionByEnhanced(int[] estimates, int k){
        int answer = 0;
        int sum = 0;



        return answer;
    }

    /**
     * 1. for 문을 돌리면서 k 만큼 자르고 각 sum 을 구한다.
     * 2. sum 은 answer 에 담는다.
     * 3. 각 구간마다 sum 을 answer 과 비교 후 최대 값을 저장한다.
     **/
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
