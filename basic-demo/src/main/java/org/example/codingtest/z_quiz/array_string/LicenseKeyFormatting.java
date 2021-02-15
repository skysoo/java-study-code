package org.example.codingtest.z_quiz.array_string;


/**
 * 1. String + 연산  -> new String 하여 새로운 객체를 생성
 * 2. concat 연산 -> new String 하여 새로운 객체를 생성
 * 3. StringBuilder 연산 -> 비동기 싱글스레드 환경
 * 4. StringBuffer 연산 -> 동기 멀티스레드 환경
 **/
public class LicenseKeyFormatting {
    private static final LicenseKeyFormatting o = new LicenseKeyFormatting();
    public static void main(String[] args) {
        String str = "8F3Z-2e-9-w-2e-9-w12";
        int k = 4;
        String solution = o.solution(str, k);
        System.out.println(solution);
    }

    /**
     * 1. -를 모두 없애라
     * 2. 소문자를 대문자로 모두 바꿔라.
     * 3. 뒤에서부터 k 번째마다 -를 넣어라.
     **/
    private String solution(String str, int k){
        // 1. -를 모두 없애라
        String s = str.replace("-", "");
        // 2. 소문자를 대문자로 모두 바꿔라.
        String s1 = s.toUpperCase();

        StringBuilder sb = new StringBuilder();
        int length = s1.toCharArray().length;
        for (int i = 0; i < length; i++) {
            sb.append(s1.charAt(i));
        }

        // 3. 뒤에서부터 k 번째마다 -를 넣어라.
        for (int i=k;i<length;i += k){
            sb.insert(length - i,'-');
        }

        return sb.toString();
    }
}
