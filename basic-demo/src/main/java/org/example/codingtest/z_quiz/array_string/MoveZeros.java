package org.example.codingtest.z_quiz.array_string;

/**
 * input 배열의 상대적인 순서는 모두 유지하되, 0을 모두 맨 뒤로 보내라.
 **/
public class MoveZeros {
    private static final MoveZeros o = new MoveZeros();
    public static void main(String[] args) {
        char[] input = {'0','3','2','0','8','5'};
        char[] solution = o.solution(input);
        for (int i = 0; i < solution.length; i++) {
            System.out.println(solution[i]);
        }
    }

    /**
     * 1. input 을 for 문을 돌자.
     * 2. 0 이 아닌 경우를 관리하는 카운트 cnt , 0 인 경우를 관리하는 카운트 rCnt 를 만든다.
     * 3. 0 이 아닌 경우 output 에  앞쪽에서부터 해당 값을 담는다.
     * 4. 0 인 경우 output 의 뒷쪽에서부터 0을 담는다.
     **/
    private char[] solution(char[] input) {
        char[] output = new char[input.length];

        int cnt = 0;
        int rCnt = input.length-1;

        for (int i = 0; i < input.length; i++) {
            if (input[i]!='0'){
                output[cnt++] = input[i];
            } else {
                output[rCnt--] = input[i];
            }
        }

        return output;
    }


}
