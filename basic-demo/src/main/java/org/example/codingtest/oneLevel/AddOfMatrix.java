package org.example.codingtest.oneLevel;

/**
 * 행렬의 덧셈은 행과 열의 크기가 같은 두 행렬의 같은 행, 같은 열의 값을 서로 더한 결과가 됩니다.
 * 2개의 행렬 arr1과 arr2를 입력받아, 행렬 덧셈의 결과를 반환하는 함수, solution을 완성해주세요.
 **/
public class AddOfMatrix {
    public static void main(String[] args) {
        int[][] arr1 = {{1,2},
                        {2,3}};

        int[][] arr2 = {{3,4},
                        {5,6}};

        int[][] arr3 = {{1,2}};

        int[][] arr4 = {{3,4}};

        solution(arr1, arr2);
//        solution(arr3, arr4);
    }

    public static int[][] solution(int[][] arr1, int[][] arr2) {
        int x = arr1.length;
        int y =arr1[0].length;

        int[][] answer = new int[x][y];

        for (int a=0;a<x;a++){
            for (int b=0;b<y;b++){
                answer[a][b] = arr1[a][b] + arr2[a][b];
                System.out.println("answer["+a+"]["+b+"]="+ answer[a][b]);
            }
        }

        return answer;
    }
}
