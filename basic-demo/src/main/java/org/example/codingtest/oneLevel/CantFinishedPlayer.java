package org.example.codingtest.oneLevel;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class CantFinishedPlayer {
    public static void main(String[] args) {
//        String[] participant = {"leo", "kiki", "eden"};
//        String[] completion = {"eden", "kiki"};

        String[] participant = {"mislav", "stanko", "mislav", "ana"};
        String[] completion = {"stanko", "ana", "mislav"};

//        String[] participant = {"a", "a", "b", "c"};
//        String[] completion = {"a", "b", "c"};

        solution1(participant, completion);
    }

    public static String solution(String[] participant, String[] completion) {
        String answer = "";

        Arrays.sort(participant, Collections.reverseOrder());
        Arrays.sort(completion, Collections.reverseOrder());

        for (int i=0;i<participant.length;i++){
            System.out.println(i);
            if (i == participant.length-1){
                answer = participant[i];
                break;
            } else if (!participant[i].equals(completion[i])){
                System.out.println("participant["+i+"]="+participant[i]+" completion["+i+"]="+completion[i]);
                answer = participant[i];
                break;
            }
        }
        return answer;
    }

    /**
     * getOrDefault(K k, V v) - HashMap에서 Key 가 이미 있으면 get하고 없으면 default 값으로 넣는다.
     **/
    public static String solution1(String[] participant, String[] completion) {
        String answer = "";

        HashMap<String, Integer> hashMap = new HashMap<>();
        for (String p : participant)
            hashMap.put(p, hashMap.getOrDefault(p,0) + 1);

        for (String c : completion)
            hashMap.put(c, hashMap.get(c)-1);

        answer = hashMap.entrySet().stream()
                .filter(e -> e.getValue() != 0)
                .map(Map.Entry::getKey)
                .findFirst()
                .get();

        System.out.println(answer);

        return answer;
    }
}
