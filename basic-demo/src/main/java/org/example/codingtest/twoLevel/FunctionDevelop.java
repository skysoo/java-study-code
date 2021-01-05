package org.example.codingtest.twoLevel;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class FunctionDevelop {
    public static void main(String[] args) {
        int[] progresses = {93, 30, 55};
        int[] speeds = {2, 30, 5};
        int[] solution = solution(progresses, speeds);
        Arrays.stream(solution).forEach(System.out::println);
    }

    public static int[] solution(int[] progresses, int[] speeds) {
        int first = 0;
        int cnt = 1;
        Queue<Integer> q = new LinkedList<>();
        Stack<Integer> s = new Stack<>();

        for (int i = 0; i < progresses.length; i++) {
            int day = (int) (Math.ceil((double) (100 - progresses[i]) / speeds[i]));
            q.add(day);
        }

        while (!q.isEmpty()){
            // 큐가 안비어있고 첫 큐라면
            if (q.size() == progresses.length) {
                first = q.poll();
                s.add(cnt++);
            // 뒤에가 더 크면 새로 추가
            } else if (first < q.peek()) {
                cnt = 1;
                first = q.poll();
                s.add(cnt++);
            // 뒤에가 더 작으면 앞에꺼 업
            } else if(first >= q.peek()){
                q.poll();
                s.add(s.pop()+1);
            }
        }
        return s.stream().mapToInt(Integer::intValue).toArray();
    }
}
