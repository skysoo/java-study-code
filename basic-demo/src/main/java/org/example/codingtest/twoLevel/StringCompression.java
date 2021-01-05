package org.example.codingtest.twoLevel;

import com.google.common.collect.Lists;

import java.util.List;

public class StringCompression {
    public static void main(String[] args) {
        String s = "aabbaccc";
        int solution = solution(s);
        System.out.println(solution);
    }

    public static int solution(String s) {
        String result = null;
        int length = s.length();
        List<String> list = Lists.newArrayList();



        for (int i = length / 2; i > 0; i--) {
            StringBuilder sb = new StringBuilder();
            int sum = 1;
            String before = "";
            for (int j = 0; j < length; j += i) {
                int end = j + i;
                if (end>length) end = length;
                String sub = s.substring(j,end);

                // 문자열 시작이 아니라면
                if (!before.equals("")) {
                    // 자른 문자열과 이전 문자열이 같다면
                    if (sub.equals(before)) {
                        sum++;
                        sb.append(sum + sub);
                        // 마지막 문자열이라면 종료
                        if (end == length) {
                            result = sb.toString();
                            break;
                        }
//                        else {
//                            before = "";
//                            sum = 1;
//                        }
                    } else {
                        if (end == length) break;
                        sb.append(before);
                        before = sub;
                    }
                } else {
                    before = sub;
                }
            }
        }

        System.out.println(result);
        return result.length();
    }
}
