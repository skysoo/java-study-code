package org.example.codingtest.z_quiz.array_string;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * 원점으로부터의 거리가 가장 짧은 point 를 구해라.
 **/
public class KClosest {
    private static final KClosest o = new KClosest();
    public static void main(String[] args) {
        int[][] points = {{1,3},{-2,2}};
        int k = 1;
        int[][] solution = o.solution(points, k);
        System.out.println("[0][0] = " + solution[0][0] + " [0][1] ="+ solution[0][1]);
    }

    /**
     * 1. 거리 구하는 공식은 x^2 + y^2
     * 2. 값을 priorityQueue 에 담아서 k번째 값을 꺼낸다.
     **/
    private int[][] solution(int[][] points, int k){
        int[][] output = {};
        int cnt = 0;
        // 1. 거리 구하는 공식은 x^2 + y^2
        Queue<int[]> queue = new PriorityQueue<>((c1,c2) -> {
            int r1 = (int) (Math.pow(c1[0], 2) + Math.pow(c1[1], 2));
            int r2 = (int) (Math.pow(c2[0], 2) + Math.pow(c2[1], 2));
            return r1 - r2;
        });

        for (int i = 0; i < points.length; i++) {
            queue.offer(points[i]);
        }

        // 2. 값을 priorityQueue 에 담아서 k번째 값을 꺼낸다.
        while (cnt < k){
            output = new int[][] {queue.poll()};
            cnt++;
        }

        return output;
    }
}
