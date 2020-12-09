package org.example.codingtest.oneLevel;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class MinNumRemove {
    public static void main(String[] args) {
        int[] arr = {4,3,2,1};
        int[] solution = solution(arr);
        Arrays.stream(solution).forEach(System.out::println);
    }

    public static int[] solution(int[] arr) {
        int[] answer = new int[arr.length];
        if(arr.length==1){
            answer[0] = -1;
            return answer;
        }

        List<Integer> list = Arrays.stream(arr).boxed().collect(Collectors.toList());
        int min = Arrays.stream(arr).min().getAsInt();

        list.removeIf(i->i==min);
        return list.stream().mapToInt(Integer::intValue).toArray();
    }
}
