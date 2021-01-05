package org.example.codingtest.twoLevel;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 0 또는 양의 정수가 담긴 배열 numbers가 매개변수로 주어질 때,
 * 순서를 재배치하여 만들 수 있는 가장 큰 수를 문자열로 바꾸어 return 하도록 solution 함수를 작성해주세요.
 **/
public class MaximumNum {
    public static void main(String[] args) {
        int[] numbers = {3, 30, 34, 5, 9};
        String solution = otherSolution(numbers);
        System.out.println(solution);
    }
    // 6, 10, 2
    // 6, 1, 2

    /**
     * 1. 맨앞자리가 큰수가 앞으로
     * 2. 10으로 나누어지는 수는 맨 뒤로
     **/

    public static String solution(int[] numbers) {
        String answer = "";

        String[] arr = new String[numbers.length];
        for (int i = 0; i < numbers.length; i++) {
            arr[i] = (String.valueOf(numbers[i]));
        }

        Arrays.sort(arr, (s1, s2) -> (s2+s1).compareTo(s1+s2));

        if (arr[0].equals("0")) return "0";

        for (int i = 0; i < arr.length; i++) {
            answer+=arr[i];
        }
        return answer;
    }

    public static String otherSolution(int[] numbers){
        List<Integer> list = new ArrayList<>();
        for (int number : numbers) {
            list.add(number);
        }

        list.sort((a, b) -> {
            String as = String.valueOf(a);
            String bs = String.valueOf(b);
            return Integer.compare(Integer.parseInt(bs + as), Integer.parseInt(as + bs));
        });

        StringBuilder sb = new StringBuilder();
        for (Integer num : list) {
            sb.append(num);
        }
        if (Integer.parseInt(sb.toString())==0) return "0";
        return sb.toString();
    }
}
