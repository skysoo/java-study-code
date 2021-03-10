package org.example.codingtest.z_quiz.array_string;

import java.util.Stack;

/**
 * input 배열에 +1 한 값을 배열로 넘겨라.
 * <p>
 * 1. input 배열을 숫자로 변경
 * 2. +1 수행
 * 3. 나온 값을 다시 배열로 변경
 **/
public class PlusOne {
    private static PlusOne o = new PlusOne();

    public static void main(String[] args) {
        int[] input = {2, 8, 9};
        int[] solution = o.solutionByEnhanced(input);
        for (int i = 0; i < solution.length; i++) {
            System.out.println(solution[i]);
        }
    }

    public int[] solution(int[] input) {
        int[] output = null;
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < input.length; i++) {
            sb.append(input[i]);
        }
        int original = Integer.parseInt(sb.toString());

        int result = original + 1;

        String s = String.valueOf(result);
        output = new int[s.length()];
        for (int i = 0; i < s.length(); i++) {
            int c = Integer.parseInt(String.valueOf(s.charAt(i)));
            output[i] = c;
        }

        return output;
    }

    public int[] solutionByEnhanced(int[] input) {
        int[] output = null;
        Stack<Integer> stack = new Stack<>();

        int carry = 0;
        int last = input.length - 1;

        for (int i = input.length - 1; i >= 0; i--) {
            int j = input[i]+carry;
            carry = 0;

            // 마지막 인덱스 +1
            if (last==i) j+=1;

            // 더한 값이 10이면 1은 carry 로 넘기고 현재 값은 0
            if (j==10){
                carry = 1;
                stack.push(0);
            } else {
                stack.push(j);
            }

            if (i==0 && carry != 0)  stack.push(carry);
        }
        int cnt =0;
        output = new int[stack.size()];
        while (!stack.isEmpty()){
            output[cnt++] = stack.pop();
        }
        return output;
    }
}
