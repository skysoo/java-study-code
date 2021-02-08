package org.example.codingtest.z_quiz.array_string;

import java.util.Stack;

/**
 * 현재 인덱스의 값보다 커지는 날이 언제인지를 리턴해라.
 **/
public class DailyTemperature {
    private static final DailyTemperature o = new DailyTemperature();
    public static void main(String[] args) {
        int[] nums = {73,74,75,71,69,72,76,73};
        // output = 1,1,4,2,1,1,0,0
        int[] solution = o.solutionByStack(nums);
        for (int i = 0; i < solution.length; i++) {
            System.out.println(solution[i]);
        }
    }

    /**
     * 1. 이중 for 문에서 nums 를 하나씩 꺼내면서 값 비교
     * 2. 작으면 +1 하고 output 에 넣고 종료
     * 3. 크면 cnt++ 올리고 종료
     * 4. 해당 index 가 배열 끝까지가도 자기보다 큰 애를 못만나면 output 은 0 이 된다.
     **/
    public int[] solution(int[] nums){
        int[] output = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            int cnt = 0;
            for (int j = i+1; j < nums.length; j++) {
                if (nums[i]<nums[j]){
                    cnt += 1;
                    output[i] = cnt;
                    break;
                } else {
                    cnt++;
                    if (j==nums.length-1)
                        output[i] = 0;
                }
            }
        }
        return output;
    }

    /**
     * 1. 스택을 활용한다.
     * 2. 스택에는 보류되는 값의 인덱스 넘을 넣는다.
     **/
    public int[] solutionByStack(int[] nums) {
        int[] output = new int[nums.length];
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < nums.length; i++) {
            while (!stack.isEmpty() && nums[stack.peek()] < nums[i]){
                int index = stack.pop();
                output[index] = i - index;
            }
            stack.push(i);
        }
        return output;
    }
}
