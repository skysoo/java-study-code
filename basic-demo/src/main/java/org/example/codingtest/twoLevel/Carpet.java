package org.example.codingtest.twoLevel;

import java.util.ArrayList;
import java.util.List;

public class Carpet {
    public static void main(String[] args) {
        int brown = 24;
        int yellow = 24;
        int[] solution = solution(brown, yellow);
        System.out.println(solution[0]+", "+solution[1]);
    }

    // 1. 가로 >= 세로
    // 2. 갈색은 노란색을 둘러쌓야한다.
    public static int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        int sum = brown + yellow;
        List<Integer> list = new ArrayList<>();

        for (int i = 1; i <= sum; i++) {
            if (sum%i==0) list.add(i);
        }

        for (int i = 0; i < list.size(); i++) {
            if (list.get(list.size() -1 -i) <= list.get(i)){
                // brown , yellow 갯수로 파악
                int x = list.get(i);
                int y = list.get(list.size()-1 -i);
                if ((x-2)*(y-2)==yellow){
                    answer[0] = list.get(i); //가로 8
                    answer[1] = list.get(list.size() -1 -i); //세로 6
                    break;
                }
            }
        }
        return answer;
    }
}
