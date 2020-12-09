package org.example.codingtest.twoLevel;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

public class Printer {
    public static void main(String[] args) {
        int[] priorites = {2, 1, 3, 2};
//        int[] priorites = {1,1,9,1,1,1};
        int location = 0;
        int solution = otherSolution(priorites, location);
        System.out.println(solution);
    }


    /**
     * 큐 - 선입선출
     * 스택 - 선입후출
     **/
    public static int solution(int[] priorities, int location) {
        int length = priorities.length;
        int printCnt = 0;
        while (true) {
            // 큐에 담아놓긴 해라.
            Queue<Integer> queue = new LinkedBlockingQueue<>();
            for (int i = 0; i < length; i++) {
                queue.add(priorities[i]);
            }

            // 현재 배열값 비교해서
            int max = priorities[0];
            for (int i = 0; i < length; i++) {
                max = Math.max(max, priorities[i]);
            }

            // 출력 대기보다 큰 값이 있다. - 맨뒤로
            if (priorities[0] != max) {
                // 현재 위치가 출력 위치라면
                Integer poll = queue.poll();
                queue.add(poll);
                if(location==0){
                    location += length-1;
                } else {
                    location--;
                }
                priorities = queue.stream().mapToInt(Integer::intValue).toArray();
            } else {
                // 출력 대기가 가장 큰 값이다.
                if (location != 0) {
                    Integer print = queue.poll();
                    System.out.println("print : " + print);
                    length--;
                    location--;
                    priorities = queue.stream().mapToInt(Integer::intValue).toArray();
                    printCnt++;
                } else {
                    break;
                }
            }
        }
        return printCnt+1;
    }

    public static int otherSolution(int[] priorities, int location){
        int answer = 0;
        int l = location;

        Queue<Integer> que = new LinkedList<Integer>();
        for(int i : priorities){
            que.add(i);
        }

        // 우선 순위 정렬
        Arrays.sort(priorities);
        int size = priorities.length-1;

        while(!que.isEmpty()){
            // 큐 맨앞에꺼 꺼내서
            Integer i = que.poll();
            // 우선순위 가장 높다면 큐에서 꺼내고 다음 비교값은 그다음으로 큰값으로
            if(i == priorities[size - answer]){
                answer++;
                l--;
                if(l <0)
                    break;
            // 우선순위가 가장 높지 않다면
            }else{
                que.add(i);
                l--;
                // 우선 순위가 가장 높지 않은데 출력 순위 였을 때 위치 조정
                if(l<0)
                    l=que.size()-1;
            }
        }

        return answer;
    }
}
