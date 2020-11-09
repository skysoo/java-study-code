package org.example.codingtest.oneLevel;

import java.util.Scanner;

/**
 * 이 문제에는 표준 입력으로 두 개의 정수 n과 m이 주어집니다.
 * 별(*) 문자를 이용해 가로의 길이가 n, 세로의 길이가 m인 직사각형 형태를 출력해보세요.
 **/
public class PrintOfRectangleStar {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();

        for (int x=0;x<b;x++){
            for (int y=0;y<a;y++){
                System.out.print("*");
            }
            System.out.print("\n");
        }

        System.out.println(a + b);
    }
}
