package org.example.codingtest.z_quiz.array_string;

import java.util.HashMap;
import java.util.Map;

/**
 * input 으로 int[] nums 와 target 이  들어온다.
 * nums 내의 값 두 개를 합산하여 target 을 도출해야 한다.
 * output 은 두 개의 int 값을 도출한다.
 **/
public class TwoSum {
    private static final TwoSum o = new TwoSum();
    public static void main(String[] args) {
        int[] nums = {2,8,10,21};
        int target = 10;
        int[] solution = o.solutionByMap(nums, target);
        System.out.println(solution[0] +" "+ solution[1]);
    }

    /**
     * 1. for 문을 돌면서 만들 수 있는 2자리 수를 모두 만든다.
     * 2. 하나의 값이 10을 넘으면 계산할 필요가 없다. return
     * 3. 두 수의 합이 10을 넘으면 output 을 도출한다.
     **/
    int[] solution(int[] nums, int target){
        int[] output = {};
        // 1. for 문을 돌면서 만들 수 있는 2자리 수를 모두 만든다.
        for (int i = 0; i < nums.length-1; i++) {
            // 2. 하나의 값이 10을 넘으면 계산할 필요가 없다. return
            if (nums[i]>=target) continue;
            for (int j = i+1; j < nums.length; j++) {
                int sum = nums[i] + nums[j];
                if (sum==target){
                    output = new int[]{i+1,j+1};
                    break;
                }
            }
        }

        return output;
    }

    /**
     * 1. Map 에는 key = target - nums[i] / value = i (index) 값을 담는다.
     **/
    int[] solutionByMap(int[] nums, int target){
        int[] output = new int[nums.length];
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int key = target - nums[i];
            if (key<=0) continue;

            if (map.containsKey(nums[i])){
                output[0] = map.get(nums[i]) + 1;
                output[1] = i + 1;
            } else {
                map.put(key, i); // map 에 들어가는 key 값은 target 이 되기 위해 필요한 값 (8)
                                 // map 에 들어가는 value 값은 해당 index 값 (0) 이고,
                                 // nums 배열 중에 map 의 key 값이 있다면 꺼낸다.
                                 // map 의 value 값과 nums 배열의 index 값이 정답이다.
            }
        }
        return output;
    }
}
