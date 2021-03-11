package org.example.codingtest.z_quiz.array_string;

import org.apache.commons.collections.map.MultiValueMap;

import java.util.*;
import java.util.stream.Collectors;

/**
 * input 으로 주어지는 문자열들 중에서 순서와 상관없이 각 문자열을 조합하는 문자가 같은 것끼리 그룹화 해라.
 * ex) eat 와 tea 는 같은 그룹
 *
 **/
public class GroupAnagrams {
    private static GroupAnagrams o = new GroupAnagrams();
    public static void main(String[] args) {
        String[] input = {"eat","tea","tan","ate","nat","bat"};
        String[][] solution = o.solution(input);

        for (int i = 0; i < solution.length; i++) {
            for (int j = 0; j < solution[i].length; j++) {
                System.out.println(solution[i][j]);
            }
            System.out.println("================");
        }
    }

    /**
     * 각 문자열을 입력받으면 정렬 (Key 사용)
     * 그 다음 문자열 입력 받아서 비교
     * 같으면 Value 로 put
     * 다르면 새로운 Key 로 사용
     *
     **/
    public String[][] solution(String[] input){
        MultiValueMap map = new MultiValueMap();

        for (String s : input) {
            String sortedStr = sorted(s);
            map.put(sortedStr,s);
        }

        // TODO: 2021-03-11 map 에서 데이터 꺼내기
        Set<String> set = map.keySet();
        List<String[]> output = new ArrayList<>();
        for (String key : set) {
            List<String> list = (List<String>) map.get(key);
            String[] strings = new String[list.size()];
            for (int i = 0; i < list.size(); i++) {
                strings[i] = list.get(i);
            }
            output.add(strings);
        }

        String[][] result = new String[output.size()][];
        for (int i = 0; i < output.size(); i++) {
            result[i] = output.get(i);
        }

        return result;
    }

    public String sorted(String s){
        String[] sorted = new String[s.length()];
        for (int i = 0; i < s.length(); i++) {
            String s1 = String.valueOf(s.charAt(i));
            sorted[i] = s1;
        }
        return Arrays.stream(sorted).sorted().collect(Collectors.joining(""));
    }

}
