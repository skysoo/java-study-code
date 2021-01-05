package org.example.codingtest.twoLevel;

import java.util.Stack;

public class SkillTree {
    public static void main(String[] args) {
        String skill = "CBD";
        String[] skill_trees = {"BACDE", "CBADF", "AECB", "BDA"};
        int solution = solution(skill, skill_trees);
        System.out.println(solution);
    }

    /**
     * 가능한 스킬트리 개수를 return 하는 solution 함수를 작성해주세요.
     **/
    public static int solution(String skill, String[] skill_trees) {
        int answer = 0;
        Stack<String> s = new Stack<>();
        String[] split = skill.split("");
        for (int i = split.length - 1; i >= 0; i--) {
            s.push(split[i]);
        }

        Stack<String> copy = null;
        for (String st : skill_trees) {
            boolean flag = true;
            copy = (Stack<String>) s.clone();
            String[] sp = st.split("");

            for (int i = 0; i < sp.length; i++) {
                if (skill.contains(sp[i])){
                    if (copy.peek().equals(sp[i])) copy.pop();
                    else {
                        flag = false;
                        break;
                    }
                }
            }
            if (flag) answer++;
        }

        return answer;
    }

}
