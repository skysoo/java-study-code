package org.example.codingtest.twoLevel;

public class TargetNumber {
    public static void main(String[] args) {
        int[] numbers = {1, 1, 1, 1, 1};
        int target = 3;
        int solution = solution(numbers, target);
        System.out.println(solution);
    }

    private static int answer = 0;

    public static int solution(int[] numbers, int target) {
        dfs(target, numbers, 0);
        return answer;

    }

    private static void dfs(int target, int[] numbers, int depth) {
        System.out.println("depth : "+ depth);
        if (depth == numbers.length){
            int sum = 0;
            for (int i = 0; i < numbers.length; i++) {
                sum += numbers[i];
            }
            if (sum==target)
                answer++;
        } else {
            dfs(target, numbers, depth+1);
            numbers[depth] *= -1;
            dfs(target, numbers, depth+1);
            System.out.println("===========");
        }
    }

}
