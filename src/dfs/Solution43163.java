package dfs;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Solution43163 {

    private boolean diff(String s1, String s2, int len) {
        int cnt = 0;
        char[] c1 = s1.toCharArray();
        char[] c2 = s2.toCharArray();
        for (int i = 0; i < len; i++) if(c1[i]!=c2[i]) cnt++;
        return cnt == 1;
    }

    public int solution(String begin, String target, String[] words) {
        int answer = 0, cLen = begin.length(), wLen = words.length;
        boolean[] visit = new boolean[wLen];
        if (Arrays.stream(words).noneMatch(s -> s.equals(target))) return 0;
        Queue<String> q = new LinkedList<>();
        q.offer(begin);
        while (!q.isEmpty()) {
            int qSize = q.size();
            for (int i = 0; i < qSize; i++) {
                String now = q.poll();
                if(now.equals(target)) return answer;
                for (int j = 0; j < wLen; j++) {
                    if(visit[j]) continue;
                    String next = words[j];
                    if(diff(now, next, cLen)) {
                        q.offer(next);
                        visit[j] = true;
                    }
                }
            }
            answer++;
        }
        return 0;
    }
}
