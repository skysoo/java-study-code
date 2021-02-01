package org.example.codingtest.a_real_test;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class DemoTest {
    private static final DemoTest o = new DemoTest();
    public static void main(String[] args) {
        int[][] v = {{1,4},{3,4},{3,10}};
        int[] solution = o.solution(v);
        System.out.println(solution[0] + " / " +solution[1]);
    }

    public int[] solution(int[][] v) {
        int[] answer = new int[v[0].length];
        Map<Integer,Integer> sMap = new HashMap<>();
        Map<Integer,Integer> eMap = new HashMap<>();
        for (int i = 0; i < v.length; i++) {
            if (sMap.containsKey(v[i][0])){
                Integer integer = sMap.get(v[i][0]);
                integer += 1;
                sMap.put(v[i][0],integer);
            } else {
                sMap.put(v[i][0],1);
            }

            if (eMap.containsKey(v[i][1])){
                Integer integer = eMap.get(v[i][1]);
                integer += 1;
                eMap.put(v[i][1],integer);
            } else {
                eMap.put(v[i][1],1);
            }
        }

        Iterator<Map.Entry<Integer, Integer>> sItr = sMap.entrySet().iterator();
        Iterator<Map.Entry<Integer, Integer>> eItr = eMap.entrySet().iterator();
        while (sItr.hasNext()){
            Map.Entry<Integer, Integer> next = sItr.next();
            if (next.getValue()<2)
                answer[0] = next.getKey();
        }

        while (eItr.hasNext()){
            Map.Entry<Integer, Integer> next = eItr.next();
            if (next.getValue()<2){
                answer[1] = next.getKey();
            }
        }
        return answer;
    }

}
