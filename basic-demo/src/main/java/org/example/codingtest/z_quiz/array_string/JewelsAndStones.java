package org.example.codingtest.z_quiz.array_string;

import java.util.HashSet;
import java.util.Set;

/**
 * input 으로 쥬얼리와 스톤 목록이 주어진다.
 * output 은 스톤에 쥬얼리가 몇 개 포함되어 있는지를 찾아서 리턴한다.
 *
 * 핵심은 대,소문자를 구분하는 것이다.
 * 1. 쥬얼리를 set 에 담아서 중복을 제외하고 대소문자를 구별한 컬렉션을 만든다.
 * 2. 스톤 목록을 하나씩 빼서 set 에 들어있는지 파악하고 카운팅한 결과를 리턴한다.
 **/
public class JewelsAndStones {
    private static final JewelsAndStones o = new JewelsAndStones();
    public static void main(String[] args) {
        String j = "aA";
        String s = "aAAbbbb";

        o.solution(j,s);
    }

    private int solution(String j, String s){
        Set<Character> set = new HashSet<>();
        for (int i = 0; i < j.length(); i++) {
            set.add(j.charAt(i));
        }

        int cnt=0;
        for (char c : s.toCharArray()) {
            if (set.contains(c)){
                cnt++;
            }
        }
        return cnt;
    }
}
