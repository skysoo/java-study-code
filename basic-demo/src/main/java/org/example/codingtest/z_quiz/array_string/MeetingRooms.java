package org.example.codingtest.z_quiz.array_string;

import java.util.Arrays;
import java.util.Comparator;

public class MeetingRooms {
    public static void main(String[] args) {
//        int[][] input = {{0,30},{15,20},{5,10}};
        int[][] input = {{7,10},{2,4}};
        boolean solution = solution(input);
        System.out.println(solution);
    }

    /**
     * 1. start 시간 기준으로 정렬
     * 2. 현재 start 시간 < 이전 end 시간  = false
     **/
    private static boolean solution(int[][] input) {
        boolean answer = true;

        // start 시간으로 정렬
//        Arrays.sort(input, (c1,c2) -> c2[0] - c1[0]);
        Arrays.sort(input, Comparator.comparingInt(c -> c[0]));

        int beforeEnd = 0;

        for (int i = 0; i < input.length; i++) {
            int curStart = input[i][0];
            int curEnd = input[i][1];

            if (curStart < beforeEnd){
                System.out.println("초과");
                answer = false;
            }

            beforeEnd = curEnd;
        }

        return answer;
    }
}
