package org.example.codingtest.oneLevel;

import java.util.regex.Pattern;

public class HandlingStrings {
    public static void main(String[] args) {
        String s = "0-.z3";
        boolean b = otherSolution(s);
        System.out.println(b);
    }

    public static boolean solution(String s) {
        if (s.length()==4 || s.length()==6){
            Pattern pattern = Pattern.compile("^([0-9]){1,8}");
            return pattern.matcher(s).matches();
        }
        return false;
    }

    public static boolean otherSolution(String s){
        if (s.length()==4 || s.length()==6){
            for (int i=0;i<s.length();i++){
                if ('0'<=s.charAt(i) && s.charAt(i)<='9')
                    return true;
            }
        }
        return false;
    }
}
