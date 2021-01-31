package org.example.codingtest.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Test2 {
    private static final Test2 o = new Test2();

    public static void main(String[] args) {
        String[] card = {"ABACDEFG", "NOPQRSTU", "HIJKLKMM"};
        String[] word = {"GPQM", "GPMZ", "EFU", "MMNA"};
        String[] solution = o.solution(card, word);
        Arrays.stream(solution).forEach(System.out::println);
    }

    public String[] solution(String[] card, String[] word) {
        String[] answer = {};
        List<String> list = new ArrayList<>();
        int m = card.length;
        int n = card[0].length();
        boolean[][] isVisited = new boolean[m][n];

        char[][] splitByCard = new char [m][n];
        for (int i = 0; i < card.length; i++) {
            for (int j = 0; j < card[i].length(); j++) {
                char c = card[i].charAt(j);
                splitByCard[i][j] = c;
            }
        }

        for (int i = 0; i < word.length; i++) {
            if (!isValid(card, word[i])){
                continue;
            }
            isVisited = new boolean[3][8];
            if(isChecked(splitByCard, word[i], isVisited)){
                list.add(word[i]);
            }
        }
        if (list.size()==0)
            return new String[]{"-1"};

        answer = new String[list.size()];
        for (int i = 0; i < list.size(); i++) {
            answer[i] = list.get(i);
        }

        return answer;
    }

    private boolean isChecked(char[][] splitByCard, String s, boolean[][] isVisited) {
        int cnt =0;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            for (int j = 0; j < splitByCard.length; j++) {
                for (int k = 0; k < splitByCard[j].length; k++) {
                    if (!isVisited[j][k] && c == splitByCard[j][k]){
                        isVisited[j][k] = true;
                        cnt++;
                        break;
                    }
                }
            }
        }

        if (cnt==s.length()){
            //모두 찾아다는 뜻 (중복 포함)
            for (int i = 0; i < isVisited.length; i++) {
                boolean isFlag = false;
                for (int j = 0; j < isVisited[0].length; j++) {
                    if (isVisited[i][j]) isFlag = true;
                }
                if (!isFlag) return false;
            }
        } else {
            return false;
        }

        return true;
    }


    // 전체 카드에 지정 문자가 하나라도 없는지 점검
    boolean isValid(String[] card, String word){
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            boolean isFlag = false;
            for (int j = 0; j < card.length; j++) {
                if (card[j].contains(String.valueOf(c)))
                    isFlag = true;
            }
            if (!isFlag) return false;
        }
        return true;
    }
}
