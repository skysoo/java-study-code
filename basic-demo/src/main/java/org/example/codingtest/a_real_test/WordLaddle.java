package org.example.codingtest.a_real_test;

import java.util.*;
import java.util.stream.Collectors;

public class WordLaddle {
    private static final WordLaddle o = new WordLaddle();
    public static void main(String[] args) {
        String begin="hit";
        String target="cog";
        String[] words = {"hot", "dot", "dog", "lot", "log", "cog"};
        int solution = o.solution(begin, target, words);

        System.out.println("solution : "+solution);
    }

    /*
     * 1. begin을 큐에 담는다.
     * 2. begin을 잘라서 a-z까지 한글자씩 치환한다.
     */
    public int solution(String begin, String target, String[] words) {
        List<String> wordList = Arrays.stream(words).collect(Collectors.toList());
        boolean[] visited = new boolean[words.length];
        if (!wordList.contains(target))
            return 0;
        return bfs(begin, target, wordList, 0,visited);
    }

    // 현재 단어와 다음 단어 비교 후 하나만 변경 하는 경우만 리턴
    // lot
    // dog¡
    // log
    private boolean check(String word, String cur) {
        int count = 0;
        for (int i = 0; i < word.length(); i++) {
            if (word.charAt(i) != cur.charAt(i)) {
                count++;
            }
            if (count > 1) {
                return false;
            }
        }
        return true;
    }

    private int bfs(String begin, String target, List<String> words, int answer, boolean[] visited){
        Queue<String> queue = new LinkedList<>();
        queue.offer(begin);

        while (!queue.isEmpty()){
            String poll = queue.poll();

            if (poll.equals(target))
                return answer;

            for (int i = 0; i < poll.length(); i++) {
                char[] chars = poll.toCharArray();
                char origin = chars[i];
                for (char j='a';j<='z';j++){
                    chars[i] = j;
                    String s = new String(chars);// a-z 치환 문자

                    for (int k = 0; k < words.size(); k++) {
                        if (words.get(k).equals(s) && !visited[k] && check(s,words.get(k))){
                            System.out.println(words.get(k));
                            visited[k] = true;
                            queue.offer(words.get(k));
                            answer+=1;
                            break;
                        }
                    }
                    if (queue.size()==1) break;
                }
                if (queue.size()==1) break;
                chars[i] = origin;
            }
        }
        return 0;
    }

}
