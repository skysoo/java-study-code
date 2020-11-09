package org.example.codingtest.oneLevel;

import java.util.Arrays;
import java.util.Iterator;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * 점심시간에 도둑이 들어, 일부 학생이 체육복을 도난당했습니다. 다행히 여벌 체육복이 있는 학생이 이들에게 체육복을 빌려주려 합니다.
 * 학생들의 번호는 체격 순으로 매겨져 있어, 바로 앞번호의 학생이나 바로 뒷번호의 학생에게만 체육복을 빌려줄 수 있습니다.
 * <p>
 * 전체 학생의 수 n, 체육복을 도난당한 학생들의 번호가 담긴 배열 lost, 여벌의 체육복을 가져온 학생들의 번호가 담긴 배열 reserve가 매개변수로 주어질 때,
 * 체육수업을 들을 수 있는 학생의 최댓값을 return 하도록 solution 함수를 작성해주세요.
 **/
public class Greedy {
    public static void main(String[] args) {
        int n = 5;
//        int[] lost = {2,3};
//        int[] reserve = {3,4};
        int[] lost = {2, 4};
        int[] reserve = {3};

//        solution(n, lost, reserve);
        otherSoultion(n, lost, reserve);
    }

    public static int solution(int n, int[] lost, int[] reserve) {
        int answer = 0;
        Set<Integer> reserveList = Arrays.stream(reserve).boxed().collect(Collectors.toSet());
        Set<Integer> lostList = Arrays.stream(lost).boxed().collect(Collectors.toSet());



        // 잃어버린 사람과 여벌 옷 있는 사람이 같은 사람이라면 두 개의 리스트에서 모두 제외
        Iterator<Integer> itr = lostList.iterator();
        while (itr.hasNext()){
            Integer lostMan = itr.next();
            if (reserveList.contains(lostMan)){
                itr.remove();
                reserveList.remove(lostMan);
            }
        }

        // 잃어버린 사람 리스트에서 여벌 옷이 있는 사람(앞뒤번호) 제외
        Iterator<Integer> itr1 = lostList.iterator();
        while (itr1.hasNext()){
            Integer lostMan = itr1.next();

            int before = Math.max(lostMan - 1, 1);
            int after = Math.min(lostMan + 1, n);

            if (reserveList.contains(before)){
                itr1.remove();
                reserveList.remove(before);
//                reserveList.removeIf(r->r==before);
            } else if (reserveList.contains(after)){
                itr1.remove();
                reserveList.remove(after);
//                reserveList.removeIf(r->r==after);
            }
        }

        answer = n - lostList.size();
        System.out.println(answer);
        return answer;
    }


    public static int otherSoultion(int n, int[] lost, int[] reserve) {
        int[] people = new int[n];
        int answer = n;

        for (int l : lost)
            people[l-1]--;
        for (int r : reserve)
            people[r-1]++;

        for (int i = 0; i < people.length; i++) {
            // 체육복을 잃어버린 학생일 때
            if(people[i] == -1) {
                // 뒷번호 학생이 여벌 옷이 있을 때
                if(i-1>=0 && people[i-1] == 1) {
                    people[i]++;
                    people[i-1]--;
                // 앞번호 학생이 여벌 옷이 있을 때
                }else if(i+1< people.length && people[i+1] == 1) {
                    people[i]++;
                    people[i+1]--;
                // 앞 뒤 모두 여벌 옷이 없을 때
                }else
                    answer--;
            }
        }
        return answer;
    }
}
