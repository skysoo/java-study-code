package org.example.codingtest.oneLevel;

import java.util.Arrays;

/**
 * 물품을 구매해 줄 때는 각 부서가 신청한 금액만큼을 모두 지원해 줘야 합니다.
 * 예를 들어 1,000원을 신청한 부서에는 정확히 1,000원을 지원해야 하며, 1,000원보다 적은 금액을 지원해 줄 수는 없습니다.
 * <p>
 * 부서별로 신청한 금액이 들어있는 배열 d와 예산 budget이 매개변수로 주어질 때,
 * 최대 몇 개의 부서에 물품을 지원할 수 있는지 return 하도록 solution 함수를 완성해주세요.
 **/
public class Budget {
    public static void main(String[] args) {
        int[] d = {1, 2, 3, 4, 5};
        int budget = 9;

        solution(d, budget);
    }

    public static int solution(int[] d, int budget) {
        int answer = 0;
        int sum = 0;

        Arrays.sort(d);

        for (int num : d){
            sum += num;
            if (sum<=budget){
                answer++;
            } else {
                break;
            }
        }

        System.out.println(answer);
        return answer;
    }
}
