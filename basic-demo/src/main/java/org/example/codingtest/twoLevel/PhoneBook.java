package org.example.codingtest.twoLevel;

import java.util.Arrays;

public class PhoneBook {
    public static void main(String[] args) {
//        String[] phone_book = {"123","456","789"};
        String[] phone_book = {"12","1235","567","123","88"};
        boolean solution = solution(phone_book);
        System.out.println(solution);
    }

    public static boolean otherSolution(String[] phone_book) {
        boolean answer = true;
        return answer;
    }

    // 효율성에서 탈락
    public static boolean solution(String[] phone_book) {
        Arrays.sort(phone_book);
        for (int i = 0; i < phone_book.length -1; i++) {
            if(phone_book[i+1].startsWith(phone_book[i])){
                return false;
            }
        }
        return true;
    }
}
