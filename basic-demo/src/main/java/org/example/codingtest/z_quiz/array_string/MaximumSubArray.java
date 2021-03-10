package org.example.codingtest.z_quiz.array_string;

/**
 * 주어진 배열의 subArray 중에 sum 값이 가장 큰 값을 도출해라.
 **/
public class MaximumSubArray {
    private static MaximumSubArray o = new MaximumSubArray();
    public static void main(String[] args) {
        int[] nums = {-2,1,-3,4,-1,2,1,-5,4};
        int solution = o.solution(nums);
        System.out.println(solution);
    }

    public int solution(int[] nums){
        int sum = nums[0];
        int max = nums[0];

        for (int i = 1; i < nums.length; i++) {
            sum = Math.max(nums[i] + sum, nums[i]);
            max = Math.max(max, sum);
        }

        return max;
    }
}
