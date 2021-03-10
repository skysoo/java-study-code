package org.example.codingtest.z_quiz.array_string;

import com.google.common.collect.Lists;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * input 으로 txt 와 pat 문자열이 주어질 때, txt 문자열 내에 순서와 상관없이 pat 문자열이 포함되어 있는 인덱스의 위치를 리턴하라.
 *
 * EX)
 * txt = "BACDGABCDA"
 * pat = "ABCD"
 *
 * output = [0, 5, 6]
 **/
public class FindAllAnagrams {
    private static FindAllAnagrams o = new FindAllAnagrams();

    public static void main(String[] args) {
        String txt = "BACDGABCDA";
        String pat = "ABCD";

        int[] solution = o.solution(txt, pat);
        Arrays.stream(solution).forEach(System.out::println);
    }

    /**
     * 1. txt 를 pat 의 크기만큼 잘라서 정렬한 뒤
     * 2. pat 와 같은지 비교
     * 3. 같다면 output 에 담기
     **/
    public int[] solution(String txt, String pat){
        List<Integer> list = Lists.newArrayList();
        int length = pat.length();
        String patSorted = sorted(pat);
        for (int i = 0; i <= txt.length()-length; i++) {
            String substring = txt.substring(i, i + length);
            String sorted = sorted(substring);
            if (patSorted.equals(sorted)) list.add(i);
        }

        return list.stream().mapToInt(Integer::intValue).toArray();
    }

    public String sorted(String str){
        String[] strings = new String[str.length()];
        for (int i = 0; i < str.length(); i++) {
            strings[i] = String.valueOf(str.charAt(i));
        }
        return Arrays.stream(strings).sorted().collect(Collectors.joining(""));
    }
}
