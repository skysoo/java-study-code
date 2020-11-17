package org.example.codingtest.oneLevel;

import java.util.*;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

/**
 * 1. 다트 게임은 총 3번의 기회로 구성된다.
 * 2. 각 기회마다 얻을 수 있는 점수는 0점에서 10점까지이다.
 * 3. 점수와 함께 Single(S), Double(D), Triple(T) 영역이 존재하고 각 영역 당첨 시 점수에서 1제곱, 2제곱, 3제곱 (점수1 , 점수2 , 점수3 )으로 계산된다.
 * 4. 옵션으로 스타상(*) , 아차상(#)이 존재하며 스타상(*) 당첨 시 해당 점수와 바로 전에 얻은 점수를 각 2배로 만든다. 아차상(#) 당첨 시 해당 점수는 마이너스된다.
 * 5. 스타상(*)은 첫 번째 기회에서도 나올 수 있다. 이 경우 첫 번째 스타상(*)의 점수만 2배가 된다. (예제 4번 참고)
 * 6. 스타상(*)의 효과는 다른 스타상(*)의 효과와 중첩될 수 있다. 이 경우 중첩된 스타상(*) 점수는 4배가 된다. (예제 4번 참고)
 * 7. 스타상(*)의 효과는 아차상(#)의 효과와 중첩될 수 있다. 이 경우 중첩된 아차상(#)의 점수는 -2배가 된다. (예제 5번 참고)
 * 8. Single(S), Double(D), Triple(T)은 점수마다 하나씩 존재한다.
 * 9. 스타상(*), 아차상(#)은 점수마다 둘 중 하나만 존재할 수 있으며, 존재하지 않을 수도 있다.
 * <p>
 * 0~10의 정수와 문자 S, D, T, *, #로 구성된 문자열이 입력될 시 총점수를 반환하는 함수를 작성하라.
 **/
public class DartGame {
    public static void main(String[] args) {
//        String dartResult = "1S*2T*3S";
//        String dartResult = "1S*2T*3S";
        String dartResult = "1D2S#10S";
        int solution = otherSolution(dartResult);
        System.out.println(solution);
    }

    public static int otherSolution(String dartResult) {
        int answer = 0;
        int before = 0;
        int pow = 0;
        Stack<Integer> result = new Stack<>();
        for (int i = 0; i < dartResult.length(); i++) {
            String c = String.valueOf(dartResult.charAt(i));
            String c1 = String.valueOf(dartResult.charAt(i + 1<dartResult.length()?i+1:i));
            switch (c) {
                case "S":
                    before = result.pop();
                    pow = (int) Math.pow(before, 1);
                    result.push(pow);
                    break;
                case "D":
                    before = result.pop();
                    pow = (int) Math.pow(before, 2);
                    result.push(pow);
                    break;
                case "T":
                    before = result.pop();
                    pow = (int) Math.pow(before, 3);
                    result.push(pow);
                    break;
                case "*":
                    before = result.pop();
                    if (!result.empty()){
                        int before1 = result.pop();
                        result.push(before1*2);
                    }
                    before *= 2;
                    result.push(before);
                    break;
                case "#":
                    before = result.pop();
                    before *= -1;
                    result.push(before);
                    break;
                default:
                    if (Pattern.matches("[0-9]",c1)){
                        c += c1;
                        i++;
                    }
                    result.push(Integer.valueOf(c));
                    break;
            }
        }
        while (!result.isEmpty()){
            answer += result.pop();
        }
        return answer;
    }

    public static int solution(String dartResult) {
        String[] split = dartResult.split("");
        StringBuilder sb = new StringBuilder();
        Map<Integer, List<String>> map = new HashMap<>();
        int set = 1;
        // 3세트로 나누기, 보너스, 옵션 고려
        for (int i = 0; i < split.length; i++) {
            String s = split[i];
            String sa = split[i + 1 < split.length ? i + 1 : i];

            if (Pattern.matches("[0-9]", s))
                sb.append(s);
            else if (Pattern.matches("[A-Z]", s)) {
                sb.append(s);
                if (sa.equals("*") || sa.equals("#")) sb.append(sa);
                map.put(set++, Arrays.stream(sb.toString().split("")).collect(Collectors.toList()));
                sb = new StringBuilder();
            }
        }
        // 각 세트별 점수 계산
        for (Map.Entry<Integer, List<String>> mapEntry : map.entrySet()) {
            Integer key = mapEntry.getKey();
            List<String> value = mapEntry.getValue();
            int pow = 0;
            int score = Integer.parseInt(value.get(0));
            String bonus = value.get(1);
            int lastValue = value.size() - 1;

            if (Pattern.matches("[0-9]", bonus)) {
                score = Integer.parseInt(value.get(0) + value.get(1));
                bonus = value.get(2);
            }
            switch (bonus) {
                case "S":
                    pow = (int) Math.pow(score, 1);
                    break;
                case "D":
                    pow = (int) Math.pow(score, 2);
                    break;
                case "T":
                    pow = (int) Math.pow(score, 3);
                    break;
            }
            if (value.get(lastValue).equals("*")) {
                if (key != 1) {
                    List<String> before = map.get(key - 1); // 이전 값 두배
                    int bv = Integer.parseInt(before.get(before.size() - 1)) * 2;
                    before.set(before.size() - 1, String.valueOf(bv));
                }
                value.add(String.valueOf(pow * 2)); // 현재 값 두배
            } else if (value.get(lastValue).equals("#")) {
                value.add(String.valueOf(pow * -1)); // 현재 값 마이너스
            } else {
                value.add(String.valueOf(pow));
            }
        }
        // 점수 합산
        return map.values().stream().map(i -> i.get(i.size() - 1)).mapToInt(Integer::parseInt).sum();
    }
}
