package org.example.codingtest.oneLevel;

import java.util.Stack;

/**
 * 인형이 담긴 2차원 배열 board와 인형을 집기 위해 크레인을 작동시킨 위치가 담긴 배열 moves가 매개변수로 주어질 때, 집어 올린 인형은 바구니에 쌓이게 되고 인형은 순서대로 쌓이게 됩니다.
 * 이 때, 바구니에 똑같은 인형이 연속해서 담기면 똑같은 인형 두개는 터트려져 사라집니다.
 * 그럼 크레인을 모두 작동시킨 후 터트려져 사라진 인형의 개수를 return 하도록 solution 함수를 완성해주세요.
 **/
public class LevelOneCrain {
    public static void main(String[] args) {

        int[][] board = {{0, 0, 0, 0, 0},
                {0, 0, 1, 0, 3},
                {0, 2, 5, 0, 1},
                {4, 2, 4, 4, 2},
                {3, 5, 1, 3, 1}};

        int[] moves = {1, 5, 3, 5, 1, 2, 1, 4};
        solution1(board, moves);
    }

    public static int solution1(int[][] board, int[] moves) {
        int answer = 0;
        Stack<Integer> stack = new Stack();

        for (int i = 0; i < moves.length; i++) {
            for (int size = 0; size < board.length; size++) {
                int value = board[size][moves[i] - 1];
                if (value != 0) {
                    board[size][moves[i] - 1] = 0;

                    if (!stack.empty() && value==stack.peek()) {
                        stack.pop();
                        answer++;
                    } else {
                        stack.push(value);
                    }
                    break;

                }
            }
        }
        answer = answer * 2;
        System.out.println(answer);
        return answer;
    }
}
