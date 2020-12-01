package org.example.codingtest.oneLevel;

// 윤년 문제
public class LeapYear {
    public static void main(String[] args) {
        int a= 5;
        int b= 24;
        solution(a,b);
    }
    public static String solution(int a, int b){
        String[] week = {"FRI","SAT","SUN","MON","TUE","WED","THU"};
        int[] endDay = {31,29,31,30,31,30,31,31,30,31,30,31};

        int value = 0;
        for(int i=0;i<a-1;i++){
            value += endDay[i];
        }
        value = (value + b - 1) % 7;
        return week[value];
    }

}
