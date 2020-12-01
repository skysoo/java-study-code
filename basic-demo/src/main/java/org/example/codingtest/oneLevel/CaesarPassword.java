package org.example.codingtest.oneLevel;

public class CaesarPassword {
    public static void main(String[] args) {
        String s = "a b c d e f g h i J k l m n o p q r s t u v w x y z";
        int n = 1;
        String solution = solution(s, n);
        System.out.println(solution);
    }

    /**
     * A - 65
     * Z - 90
     * <p>
     * a - 97
     * z - 122
     **/
    public static String solution(String s, int n) {
        String answer = "";
        char start;
        char c;
        for (int i = 0; i < s.length(); i++) {
            c = s.charAt(i);
            if (c != ' '){
                start = Character.isLowerCase(c) ? 'a' : 'A';
                c = (char) (start + (c + n - start)%26);
            }
            answer+=c;
        }
        return answer;
    }
}
