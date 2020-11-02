package org.example.codingtest.one;

import java.util.*;

public class FullSearch {
    public static void main(String[] args) {
//        int[] answers = {1,2,3,4,5};
        int[] answers = {1,3,2,4,2};
        solution(answers);
    }

    public static int[] solution(int[] answers) {
        int[] answer = {};

        int[] aAnswers = {1, 2, 3, 4, 5, 1, 2, 3, 4, 5};
        int[] bAnswers = {2, 1, 2, 3, 2, 4, 2, 5, 2, 1, 2, 3, 2, 4, 2, 5};
        int[] cAnswers = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5, 3, 3, 1, 1, 2, 2, 4, 4, 5, 5};

        Map<String, Integer> map = new HashMap<>();
        List<Integer> list = new ArrayList<>();

        for (int i=0;i<answers.length;i++) {
            int num = answers[i];
            if (aAnswers[i%5]==num)
                map.put("1", map.getOrDefault("1",0)+1);

            if (bAnswers[i%8]==num)
                map.put("2", map.getOrDefault("2",0)+1);

            if (cAnswers[i%10]==num)
                map.put("3", map.getOrDefault("3",0)+1);
        }

        // 최고 득점 추출
        int maxValue = map.entrySet().stream()
                .max(Map.Entry.comparingByValue())
                .map(Map.Entry::getValue)
                .get();

        // 최고 득점자 list에 담기
        map.forEach((key, value) -> {
            System.out.println("key : "+key + ", value : "+value);
            if (value==maxValue)
                list.add(Integer.valueOf(key));
        });

        // 최고 득점자 오름차순 정렬
        answer = list.stream().sorted().mapToInt(Integer::intValue).toArray();

        Arrays.stream(answer).forEach(System.out::println);

        return answer;
    }
}
