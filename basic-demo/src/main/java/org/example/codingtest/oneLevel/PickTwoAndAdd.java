package org.example.codingtest.oneLevel;

import java.util.*;

/**
 * 정수 배열 numbers가 주어집니다. numbers에서 서로 다른 인덱스에 있는 두 개의 수를 뽑아 더해서 만들 수 있는 모든 수를
 * 배열에 오름차순으로 담아 return 하도록 solution 함수를 완성해주세요.
 **/
public class PickTwoAndAdd {
    public static void main(String[] args) {
        int[] numbers = {2,1,3,4,1};
//        int[] numbers = {5, 0, 2, 7};

        solution(numbers);
    }
    /**
     * 1. numbers 배열 정렬
     * 2. 각 순차적으로 더하기
     * 3. 더한 값이 numbers 배열에 존재하면 pass, 없으면 넣기
     **/
    public static int[] solution(int[] numbers) {
        int[] answer = {};
        int cnt = 0;
        List<Integer> list = new ArrayList<>();

        for (int before=0;before<numbers.length;before++){
            for (int after=before+1;after<numbers.length;after++){
                int addValue = numbers[before] + numbers[after];

                if (!list.contains(addValue))
                    list.add(addValue);
            }
        }

        list.sort(Comparator.naturalOrder());

        answer = new int[list.size()];
        for (int value : list){
            answer[cnt] = value;
            cnt++;
        }

        return answer;
    }

    public static int[] otherSolution(int[] numbers){
        Set<Integer> set = new HashSet<>();

        for (int before : numbers){
            for (int after=before+1;after<numbers.length;after++){
                set.add(numbers[before] + numbers[after]);
            }
        }

        return set.stream().sorted().mapToInt(Integer::intValue).toArray();
    }
}
