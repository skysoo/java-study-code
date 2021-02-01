package org.example.codingtest.twoLevel;

public class StringCompression {
    public static void main(String[] args) {
        String s = "abcabcdede";
        int solution = solution(s);
        System.out.println(solution);
    }

    /**
     * 가장 짧은 문자열의 길이를 리턴해라. - 길이가 핵심
     * 1. 압축할 수 있는 단위는 1~전체 길이의 절반까지
     * 2. 단위별로 순서대로 길이 리턴
     * 3. 전체 작업 완료 후 최소값을 리턴해라
     **/
    public static int solution(String s) {
        int answer = 100;
        int length = s.length();

        for (int unit = 1; unit <= length; unit++) {
            String before = "";
            int sum = 1;
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j <= length - unit; j += unit) {
                int end = j + unit;
                String cur = s.substring(j, end);

                // 이전 문자열과 같다면
                if (cur.equals(before)) {
                    sum++;
                    if (end == length) {
                        sb.append(sum).append(before);
                        answer = Math.min(answer, sb.toString().length());
                        System.out.println(sb.toString() + ":" + sb.toString().length());
                    }
                    // 이전 문자열과 다르다면
                } else {
                    // 맨 첫 문자열이라면
                    if (j == 0) {
                        System.out.println("묶음 단위 : " + unit + ", 첫 문자열!!");
                        // 첫 문자열이 아니라면
                    } else {
                        if (sum != 1) {
                            sb.append(sum).append(before); // 더이상 같지 않기 때문에 현재까지의 sum 으로 압축
                            sum = 1;
                        } else {
                            sb.append(before);
                        }

                        if (end == length) {
                            sb.append(cur);
                            answer = Math.min(answer, sb.toString().length());
                            System.out.println(sb.toString() + ":" + sb.toString().length());
                        } else if (end > length-unit){
                            sb.append(cur).append(s.substring(end));
                            answer = Math.min(answer, sb.toString().length());
                            System.out.println(sb.toString() + ":" + sb.toString().length());
                        }
                    }
                    before = cur;
                }
            }
        }
        return answer;
    }
}
