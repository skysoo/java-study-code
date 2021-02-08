package org.example.codingtest.z_quiz.array_string;

import java.util.*;

public class MergeInterval {
    private static final MergeInterval o = new MergeInterval();
    public static void main(String[] args) {
        int[][] input ={{1,3},{2,6},{8,10},{15,18}};
        int[][] solution = o.solution(input);
        for (int i = 0; i < solution.length; i++) {
            System.out.println(solution[i][0] + "/ " + solution[i][1]);

        }
    }

    int[][] solution(int[][] input){
        int[][] output = {};
        List<int[]> list = new LinkedList<>();
        int[] beforeEnd = input[0];
        for (int i = 1; i < input.length; i++) {
            int[] afterStart = input[i];
            if (beforeEnd[1]>=afterStart[0]){
                beforeEnd[1] = Math.max(beforeEnd[1],afterStart[1]);
            } else {
                list.add(beforeEnd);
                beforeEnd = afterStart;
                if (i==input.length-1){
                    list.add(beforeEnd);
                }
            }

        }
        output = new int[list.size()][2];
        for (int i = 0; i < list.size(); i++) {
            output[i] = list.get(i);
        }
        return output;
    }
    /**
     * 문제) 2차원 배열이 주어지고 각 배열은 시간 텀을 나타낸다.
     *      중복되는 텀을 가지는 배열은 합쳐라.
     *
     * 1. start로 정렬한다.
     * 2. 첫번째 배열의 end 시간보다 두번째 배열의 start 시간이 빠르면 merge 해라.
     **/
    int[][] solutionByQueue(int[][] input){
        int[][] output = new int[input.length][input[0].length];
        // 1. start로 정렬한다.
        Arrays.sort(input, Comparator.comparingInt(c -> c[0]));

        Stack<Integer> stack = new Stack<>();
        int cnt = 0;
        // 2. 첫번째 배열의 end 시간보다 두번째 배열의 start 시간이 빠르면 merge 해라.
        for (int i = 0; i < input.length-1; i++) {
            while (!stack.isEmpty()){
                if (input[stack.peek()][1] >= input[i][0]){
                    Integer pop = stack.pop();
                    output[pop][0] = input[pop][0];
                    stack.push(i);
                    i++;
//                    output[pop][1] = input[i][1];
                } else {
                    Integer pop = stack.pop();

                }
            }
            stack.push(i);
        }

        return output;
    }
}
