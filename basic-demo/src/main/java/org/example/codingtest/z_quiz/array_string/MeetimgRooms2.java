package org.example.codingtest.z_quiz.array_string;

import java.util.*;

public class MeetimgRooms2 {
    private static final MeetimgRooms2 o = new MeetimgRooms2();

    public static void main(String[] args) {
        int[][] input = {{0, 30}, {5, 10}, {15, 20}};
        int solution = o.solution(input);
        System.out.println(solution);
    }

    /**
     * 주어진 미팅 시간들을 확인해서 사용해야하는 최소한의 회의실 갯수를 도출해라.
     * <p>
     * 1. start 시간으로 데이터 정렬
     * 2. Min Heap 사용, PriorityQueue 에 start time 으로 오름차순 정렬
     * 3. Min Heap 의 가장 상단 데이터는 end time 이 가장 낮은 값이며,
     *    Min Heap 의 end time <= input[i][0] 의 start time 이라면 큐에서 제거하고
     * 4. Min Heap 에는 input[i] 가 들어간다.
     **/
    private int solution(int[][] input) {
        int max = 0;

        if (input ==null || input.length==0) return -1;

        Arrays.sort(input, Comparator.comparingInt(c -> c[0]));

        Queue<int[]> minHeap = new PriorityQueue<>(input.length, Comparator.comparingInt(c -> c[1]));

        for (int i = 0; i < input.length; i++) {
            while (!minHeap.isEmpty() && minHeap.peek()[1] <= input[i][0]){
                minHeap.poll();
            }
            minHeap.offer(input[i]);
            max = Math.max(max, minHeap.size());
        }

        return max;
    }
}
