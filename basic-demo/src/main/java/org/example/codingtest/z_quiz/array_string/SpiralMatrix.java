package org.example.codingtest.z_quiz.array_string;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * input 으로 2차원 배열을 받고 나선형으로 배열을 모두 읽어 들인다.
 *
 * 1.
 **/
public class SpiralMatrix {
    private static SpiralMatrix o = new SpiralMatrix();
    public static void main(String[] args) {
        int[][] array = {{1,2,3,4,5},
                         {6,7,8,9,10},
                         {11,12,13,14,15},
                         {16,17,18,19,20},
                         {21,22,23,24,25}};
        int[] solution = o.solution(array);
        String collect = Arrays.stream(solution).boxed().map(String::valueOf).collect(Collectors.joining(","));
        System.out.println(collect);
    }

    public int[] solution(int[][] array){
        List<Integer> list = new ArrayList<>();
        int rowStart = 0;
        int rowEnd = array.length -1;
        int colStart = 0;
        int colEnd = array[0].length -1;

        while (rowStart<=rowEnd && colStart<=colEnd){
            // right
            for (int i = colStart; i <= colEnd; i++) {
                list.add(array[rowStart][i]);
            }
            rowStart++;

            // down
            for (int i = rowStart; i <= rowEnd; i++) {
                list.add(array[i][colEnd]);
            }
            colEnd--;

            // left
            if (rowStart<=rowEnd)
                for (int i = colEnd; i >= colStart ; i--) {
                    list.add(array[rowEnd][i]);
                }
                rowEnd--;

            // up
            if (colStart<=colEnd)
                for (int i = rowEnd; i >= rowStart ; i--) {
                    list.add(array[i][colStart]);
                }
                colStart++;
        }

        return list.stream().mapToInt(Integer::intValue).toArray();
    }
}
