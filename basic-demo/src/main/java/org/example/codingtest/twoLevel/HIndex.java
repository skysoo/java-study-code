package org.example.codingtest.twoLevel;

import java.util.*;

public class HIndex {
    public static void main(String[] args) {
        int[] citations = {4, 0, 6, 1, 5,7};
        int solution = solution(citations);
        System.out.println(solution);
    }
    public static int solution(int[] citations) {
        int answer = 0;
        int h = 0;
        int k = 0;
        // 0 1 3 5 6
        Arrays.sort(citations);

        for (int i = 0; i < citations.length; i++) {
            h = citations[i];
            k =  citations.length - i;

            if (k <= h) {
                answer = k;
                break;
            }
        }
        return answer;
    }
}
