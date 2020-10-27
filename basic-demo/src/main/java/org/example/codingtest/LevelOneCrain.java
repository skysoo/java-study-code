package org.example.codingtest;

import java.util.Stack;

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
        return answer;
    }
}
