package org.example.codingtest.twoLevel;

import java.util.LinkedList;
import java.util.List;

/**
 * 초당 최대 처리량 : 임의 시간부터 1초간 처리하는 요청의 최대 개수를 의미한다. - 응답 완료 여부에 관계 없이
 * 입력 값으로는
 *      S : 응답 완료 시간
 *      T : 처리 시간
 **/
public class TrafficKakao {
    private static final TrafficKakao o = new TrafficKakao();
    public static void main(String[] args) {
        String[] lines = {"2016-09-15 20:59:57.421 0.351s",
                "2016-09-15 20:59:58.233 1.181s",
                "2016-09-15 20:59:58.299 0.8s",
                "2016-09-15 20:59:58.688 1.041s",
                "2016-09-15 20:59:59.591 1.412s",
                "2016-09-15 21:00:00.464 1.466s",
                "2016-09-15 21:00:00.741 1.581s",
                "2016-09-15 21:00:00.748 2.31s",
                "2016-09-15 21:00:00.966 0.381s",
                "2016-09-15 21:00:02.066 2.62s"};
        int solution = o.solution(lines);
        System.out.println(solution);
    }

    private class Process {
        float start;
        float end;
        float total;

        public Process(float start, float end, float total) {
            this.start = start;
            this.end = end;
            this.total = total;
        }
    }

    public int solution(String[] lines) {
        int answer = 0;
        List<Process> list = new LinkedList<>();
        for (String line : lines) {
            String s = line.replace("s", "");
            String[] date = s.split(" ");
            String[] time = date[1].split(":");
            float totalTime = Float.parseFloat(date[2]);
            float endTime = (Float.parseFloat(time[0]) * 3600) +(Float.parseFloat(time[1]) * 60) +Float.parseFloat(time[2]);
            float startTime = endTime - totalTime + 0.001f;

            list.add(new Process(startTime, endTime, totalTime));
        }

        for(int i=0; i < list.size();i++){
            Process cur = list.get(i);

            float range = cur.end + 0.999f; // 끝 시간을 기준으로 + 1초
            int cnt = 0;
            for (int j = i; j < list.size(); j++) {
                Process next = list.get(j);
                if (range >= next.start)
                    cnt++;
            }
            answer = Math.max(cnt, answer);
        }

        return answer;
    }
}
