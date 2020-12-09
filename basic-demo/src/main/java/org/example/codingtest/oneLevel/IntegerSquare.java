package org.example.codingtest.oneLevel;

public class IntegerSquare {
    public static void main(String[] args) {
        int n = 3;
        long solution = solution(n);
        System.out.println(solution);
    }

    public static long solution(long n) {
        double sqrt = Math.sqrt(n);
        String s = String.valueOf(sqrt);
        String[] split = s.split("\\.");

        int[] arr = {10};


        //
        if (!(split[1].length()>1) && Integer.parseInt(split[1])==0)
            return (long) Math.pow(Double.parseDouble(split[0])+1,2);
        return -1;
    }
}
