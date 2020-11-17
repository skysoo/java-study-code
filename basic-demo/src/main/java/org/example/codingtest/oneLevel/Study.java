package org.example.codingtest.oneLevel;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

public class Study {
    public static void main(String[] args) {
        int[][] clustering = {{1,4,3,3,3},
                {2,3,2,1,4},
                {3,1,5,3,5},
                {4,4,3,5,4},
                {5,3,4,3,5},
                {6,3,4,1,3},
                {7,1,5,1,3},
                {8,4,5,1,1},
                {9,5,5,5,3},
                {10,5,5,3,3},
                {11,2,2,1,4},
                {12,5,1,4,2},
                {13,5,2,1,2},
                {14,5,2,3,3},
                {15,1,2,1,3},
                {16,4,4,5,4},
                {17,1,5,1,5},
                {18,3,5,1,2},
                {19,2,3,1,4},
                {20,5,2,3,4}
        };

        solution(clustering);
    }

    private static void solution(int[][] clustering) {
        Set<int[]> collect = Arrays.stream(clustering).collect(Collectors.toSet());
        int sum = 0;
        int before = 0;
        for (int[] score : collect){
            sum += score[1] + score[2] + score[3] + score[4];
            int max = Math.max(before, sum);
            before = max;
        }


        for (int i=0;i<clustering.length;i++){
            // 4인 1조로 총 5개조를 생성, 만들 수 있는 경우의 수 모두 생성

        }
    }
}
