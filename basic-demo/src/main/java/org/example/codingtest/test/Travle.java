package org.example.codingtest.test;

// 쭉 훑고 지나가야한다면 dfs
public class Travle {
    private static final Travle o = new Travle();
    public static void main(String[] args) {
        String[][] tickets = {{"HND","IAD"},
                              {"ICN","JFK"},
                              {"JFK","HND"}};

        o.solve(tickets);
    }

    /*
     * 1. 0번째만 가져와서 ICN 가져와라.
     * 2. ICN이 여러개면 알파벳 순으로 정렬하라.
     */
    private void solve(String[][] tickets) {
        int m = tickets.length; //3
        int n = tickets[0].length; //2
        boolean[][] visited = new boolean[n][m];
        String[] first = null;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (tickets[i][0].equals("ICN")){
                    if (first==null) first = tickets[i];
                    else {
                        if (first[1].compareTo(tickets[i][0]) > 0)
                            first = tickets[i];
                    }
                }

            }
        }


    }





}
