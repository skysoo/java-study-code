package org.example.codingtest.twoLevel;

public class Country124 {
    public static void main(String[] args) {
        int n = 6;
        String solution = solution(n);
        System.out.println(solution);
    }

    public static String solution(int n) {
        int m = n / 3;
        int na = n % 3;
        StringBuilder sb = new StringBuilder();
        sb.append(na);

        while(m!=0){
            if (na==0) m = m-1;
            if (m==0) break;

            na = m % 3;
            m = m / 3;
            sb.append(na);
        }
        return sb.reverse().toString().replaceAll("0","4");
    }
}
