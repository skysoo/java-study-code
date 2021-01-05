package org.example.codingtest.twoLevel;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

public class TruckPassingTheBridge {
    public static void main(String[] args) {
        int bridge_length = 2;
        int weight = 10;
        int[] truck_weights = {7,4,5,6};
//        int[] truck_weights = {10,10,10,10,10,10,10,10,10,10};
        int solution = otherSolution(bridge_length, weight, truck_weights);
        System.out.println(solution);
    }

    public static int otherSolution(int bridge_length, int weight, int[] truck_weights){
        int answer = 0;
        Queue<Integer> ing_q = new LinkedList<>();
        int sum_weigth = 0;
        for(int t : truck_weights){
            while (true){
                // 다리에 트럭 진입
                if (ing_q.isEmpty()){
                    ing_q.add(t);
                    sum_weigth += t;
                    answer++;
                    break;
                // 트럭이 다리 끝까지 갔다면
                } else if (ing_q.size() == bridge_length){
                    sum_weigth -= ing_q.poll();
                } else {
                    // 후속 트럭이 다리에 진입할 수 없다면
                    if (sum_weigth + t > weight){
                        answer++; // 먼저 진입한 트럭 한칸 앞으로
                        ing_q.add(0); // 트럭이 없으니 0으로 채움
                    } else {
                        ing_q.add(t);
                        sum_weigth += t;
                        answer++;
                        break;
                    }
                }
            }
        }
        return answer + bridge_length;
    }

    public static int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;
        int ori_weight = weight;
        Queue<Integer> start_q = new LinkedBlockingQueue<>();

        for (int tw : truck_weights)
            start_q.add(tw);

        while (!start_q.isEmpty()) {
            // 혼자 건너야하는 트럭
            Integer s = start_q.poll();
            answer += bridge_length;
            weight -= s;

            // 같이 건널 수 있는 트럭
            while (!start_q.isEmpty() && weight - start_q.peek() >= 0) {
                Integer b = start_q.poll();
                answer += 1;
                weight -= b;
            }

            weight = ori_weight;
        }
        return answer + 1;
    }
}
