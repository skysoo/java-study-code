package org.example.codingtest.twoLevel;

import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;

public class FindPrimeNumber {

    public static void main(String[] args) {
        String numbers = "011";
        int solution = solution(numbers);
        System.out.println(solution);
    }

    static Set<Integer> set = new LinkedHashSet<>();

    public static int solution(String numbers) {
        int answer = 0;
        int[] arr = new int[numbers.length()];
        int[] output = new int[numbers.length()];
        boolean[] visited = new boolean[numbers.length()];

        for (int i = 0; i < numbers.length(); i++) {
            arr[i] = Integer.parseInt(String.valueOf(numbers.charAt(i)));
        }

        // 순열 - nCr (n중에 r개 조합 추출)
        for (int r = 1; r <= numbers.length(); r++) {
            perm(arr, output, visited, 0, numbers.length(), r);
            System.out.println("==================================");
        }

        // 소수이면 카운팅
        Iterator<Integer> itr = set.iterator();
        while (itr.hasNext()){
            Integer next = itr.next();
            if (isPrime(next))
                answer++;
        }

        return answer;
    }

    /**
     * arr - 원본 순열 구할 배열
     * output - depth 별 순열 결과값
     * visited - 조합 사용 여부
     * depth - 순열 조합을 구하려는 깊이
     * n - 길이
     * r - 순열 크기
     **/
    static void perm(int[] arr, int[] output, boolean[] visited, int depth, int n, int r) {
        // 출력 시점
        if (depth == r) {
            StringBuilder s = new StringBuilder();
            for (int i = 0; i < r; i++) {
                s.append(output[i]);
            }
            set.add(Integer.parseInt(s.toString()));
            return;
        }

        // 방문 여부 파악해서 재귀돌리기
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                visited[i] = true;
                output[depth] = arr[i];
                perm(arr, output, visited, depth + 1, n, r);
                visited[i] = false;
            }
        }
    }

    public static boolean isPrime(int num) {
        if(num <= 1) return false;

        for(int i=2; i<=Math.sqrt(num); i++) {
            if(num % i == 0) return false;
        }
        return true;
    }
}
