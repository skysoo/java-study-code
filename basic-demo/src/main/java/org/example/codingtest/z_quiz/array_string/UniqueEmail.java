package org.example.codingtest.z_quiz.array_string;

import com.google.common.collect.Maps;

import java.util.Map;

/**
 * 1. @ 앞 검증 - .은 없애고 + 뒤로는 무시 => value
 * 2. @ 뒤 검증 - 같은가 다른가 => key
 * 3. @ 뒤가 같으면 @ 앞이 같아도 다른 이메일로 읽는다.
 **/
public class UniqueEmail {
    private static UniqueEmail o = new UniqueEmail();
    public static void main(String[] args) {
        String[] emails = {"test.email+james@coding.com",
                "test.e.mail+toto.jane@coding.com",
                "test.email+tom@cod.ing.com"};
        int solution = o.solution(emails);
        System.out.println(solution);
    }

    public int solution(String[] emails){
        Map<String,String> map = Maps.newHashMap();

        for (String email : emails) {
            String key = email.split("@")[1];
            String value = email.split("@")[0];
            // @ 앞 검증 - . 없애고 + 뒤 문자 무시
            String replace = value.replace(".", "");
            String substring = replace.substring(0, replace.indexOf("+"));

            map.put(key, substring);
        }

        return map.size();
    }
}
