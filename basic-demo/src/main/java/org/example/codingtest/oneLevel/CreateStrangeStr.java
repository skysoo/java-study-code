package org.example.codingtest.oneLevel;

/**
 * 문자열 s는 한 개 이상의 단어로 구성되어 있습니다.
 * 각 단어는 하나 이상의 공백문자로 구분되어 있습니다. 각 단어의 짝수번째 알파벳은 대문자로,
 * 홀수번째 알파벳은 소문자로 바꾼 문자열을 리턴하는 함수, solution을 완성하세요.
 **/
public class CreateStrangeStr {
    public static void main(String[] args) {
        String s = "try hello world aaaa n AAAA bb d ddD z z z";
        solution(s);
    }

    public static String solution(String s){
        String answer = "";

        StringBuilder sb = new StringBuilder();
        String[] str = s.split("");
        int index = 0;

        for (int i=0;i< str.length;i++){
            if (str[i].equals(" ")){
                sb.append(" ");
                index = 0;
            }
            else {
                if (index%2==0)
                    sb.append(str[i].toUpperCase());
                if (index%2==1)
                    sb.append(str[i].toLowerCase());
                index++;
            }
        }

        answer = sb.toString();
        System.out.println(answer);
        return answer;
    }
}
