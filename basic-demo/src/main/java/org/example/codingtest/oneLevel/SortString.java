package org.example.codingtest.oneLevel;


import java.util.*;
import java.util.stream.Collectors;

/**
 * 문자열로 구성된 리스트 strings와, 정수 n이 주어졌을 때, 각 문자열의 인덱스 n번째 글자를 기준으로 오름차순 정렬하려 합니다.
 * 예를 들어 strings가 ["sun", "bed", "car"]이고 n이 1이면 각 단어의 인덱스 1의 문자 "u", "e", "a"로 strings를 정렬합니다.
 **/
public class SortString {
    public static void main(String[] args) {
        String[] strings = {"sun","bed","car"};
//        String[] strings = {"abce", "abcd","cdx"};
        int n = 1;

        String[] solution = otherSolution(strings, n);
        Arrays.stream(solution).forEach(System.out::println);
    }

    public static String[] solution(String[] strings, int n) {
        String[] answer = new String[strings.length];
        Map<String, List<String>> multiMap = new HashMap<>();
        List<String> list = new ArrayList<>();
        for (String str : strings){
            String word = str.substring(n, n + 1);
            if (multiMap.containsKey(word)){
                list = multiMap.get(word);
                list.add(str);
            } else {
                list = new ArrayList<>();
                list.add(str);
            }
            multiMap.put(word, list);
        }

        List<String> collect = multiMap.keySet().stream().sorted().collect(Collectors.toList());
        int i=0;

        for (String key : collect){
            List<String> values = multiMap.get(key).stream().sorted().collect(Collectors.toList());
            for (String value : values) answer[i++] = value;
        }

        return answer;
    }

    public static String[] otherSolution(String[] strings, int n) {
        String[] answer = {};
        ArrayList<String> arr = new ArrayList<>();
        for (int i = 0; i < strings.length; i++) {
            arr.add("" + strings[i].charAt(n) + strings[i]);
        }
        Collections.sort(arr);
        answer = new String[arr.size()];
        for (int i = 0; i < arr.size(); i++) {
            answer[i] = arr.get(i).substring(1);
        }
        return answer;
    }
}
