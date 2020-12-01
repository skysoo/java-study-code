package org.example.codingtest.oneLevel;

public class FindPrimeNumbers {
    public static void main(String[] args) {
        int n = 10;
        int solution = solution(n);
        System.out.println(solution);
    }

    public static int solution(int n) {
        int answer = 0;
        boolean[] value = new boolean[n+1];

        for (int i=2;i<=n;i++){
            value[i] = true;
        }
        int root = (int) Math.sqrt(n); //제곱근

        // 범위 내의 모든 수
        for (int i=2;i<=root;i++){
            // 소수 일 때
           if (value[i]){
               // 소수를 제외한 배수는 모두 소수가 아니다
               for (int j=i;i*j<=n;j++){
                   value[i*j] = false;
               }
           }
        }

        for (int i=2;i<=n;i++){
            if (value[i]) answer++;
        }

        return answer;
    }
}
