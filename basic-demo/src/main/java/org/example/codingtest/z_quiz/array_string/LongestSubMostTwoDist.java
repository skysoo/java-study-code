package org.example.codingtest.z_quiz.array_string;

import java.util.HashSet;
import java.util.Set;

/**
 * 주어진 문자열에서 두 개의 고유 문자로만 이루어진 가장 긴 문자열을 찾아라.
 *
 * 1. 순서대로 읽는다.
 * 2. set 에 문자열을 담고 3개 이상이 되면 break
 * 3. set 에 문자열이 2개까지는 계속 카운트를 해준다.
 * 4. Max 치를 반환한다.
 **/
public class LongestSubMostTwoDist {
    private static LongestSubMostTwoDist o = new LongestSubMostTwoDist();
    public static void main(String[] args) {
        String s = "cccbcccaabbb";
        int solution = o.solution(s);
        System.out.println(solution);
    }

    public int solution(String s){
        int max = 0;
        // 1. 순서대로 읽는다.
        for (int i = 0; i < s.length(); i++) {
            int cnt = 1;
            Set<String> set = new HashSet<>();
            String current = String.valueOf(s.charAt(i));
            set.add(current);

            for (int j = i+1; j < s.length(); j++) {
                String compare = String.valueOf(s.charAt(j));
                set.add(compare);

                // set 에 문자열을 담고 3개 이상이 되면 break
                if (set.size()>2){
                    break;
                } else {
                    cnt++;
                }
            }
            // 2개의 고유한 값을 가지고 만들어진 최대 문자열 길이를 리턴한다.
            max = Math.max(max, cnt);

        }
        return max;
    }
}
