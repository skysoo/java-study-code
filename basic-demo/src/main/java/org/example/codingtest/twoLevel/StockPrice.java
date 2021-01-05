package org.example.codingtest.twoLevel;

import java.util.Arrays;

/**
 * 초 단위로 기록된 주식가격이 담긴 배열 prices가 매개변수로 주어질 때,
 * 가격이 떨어지지 않은 기간은 몇 초인지를 return 하도록 solution 함수를 완성하세요.
 **/
public class StockPrice {
    public static void main(String[] args) {
        int[] prices = {1, 2, 3, 2, 3};
        //              4, 3, 2, 1, 0
        int[] solution = solution(prices);
        Arrays.stream(solution).forEach(System.out::println);
    }

    public static int[] solution(int[] prices) {
        int[] answer = new int[prices.length];
        for (int i=0;i<prices.length;i++){
            int cnt = 0;
            for (int j=i+1;j<prices.length;j++){
                cnt++;
                if (prices[i]>prices[j]){
                    break;
                }
            }
            answer[i] = cnt;
        }

        return answer;
    }

    // 스택으로 풀면?
    public static int[] otherSolution(int[] prices) {
        int[] answer = new int[prices.length];
        
        return answer;
    }
}
