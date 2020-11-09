package org.example.codingtest.oneLevel;

/**
 * 자연수 n이 매개변수로 주어집니다. n을 3진법 상에서 앞뒤로 뒤집은 후,
 * 이를 다시 10진법으로 표현한 수를 return 하도록 solution 함수를 완성해주세요.
 *
 * 답을 도출하는 과정
 * 1. n(10진법) 입력
 * 2. n -> 3진법 변환
 * 3. 변환된 3진법 값을 앞뒤 반전
 * 4. 반전된 값을 10진법으로 표현
 *
 * ex)
 *  1. 45
 *  2. 1200
 *  3. 0021
 *  4. 7
 **/
public class TernaryFlip {
    public static void main(String[] args) {
        int n = 45;
        otherSolution(n);
    }

    public static int solution(int n) {
        StringBuilder builder = new StringBuilder();

        // 3진수 변환
        while (n >= 1)
        {
            builder.insert(0, n % 3);
            n /= 3;
        }
        System.out.println("3진수 : "+builder.toString());

        // 값 반전
        builder.reverse();
        System.out.println("reverse : "+builder.toString());

        int a = builder.length()-1;
        int sum = 0;

        // 10진수 변환
        for (int i=0;i< builder.length();i++){
            int before = Integer.parseInt(builder.substring(i, i + 1));

            sum += before * Math.pow(3,a);
            a--;
        }

        System.out.println("10진수 : "+sum);
        return sum;
    }

    public static int otherSolution(int n) {
        StringBuilder builder = new StringBuilder();

        // 3진수 변환
        builder.append(Integer.toString(n, 3));
        System.out.println("3진수 : "+builder.toString());

        // 값 반전
        builder.reverse();
        System.out.println("reverse : "+builder.toString());

        int sum = 0;

        for(int i=builder.length()-1;i>=0;i--){
            int before = Integer.parseInt(builder.substring(i, i+1));
            sum += before * Math.pow(3,(builder.length()-1)-i);
        }

        System.out.println("10진수 : "+sum);
        return sum;
    }
}
