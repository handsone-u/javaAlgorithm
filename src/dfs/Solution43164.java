package dfs;

import java.util.*;
import java.util.stream.Collectors;

public class Solution43164 {
    private int size;
    private boolean solved = false;
    private boolean[] v;
    private ArrayList<String> ans;
    private Stack<String> stack = new Stack<>();

    void dfs(String[][] t, int n, String togo) {
        stack.push(togo);
        if(n==size){
            ans = new ArrayList<>(stack);
            solved = true;
            return;
        } else if(solved||n>size) return;

        for (int i = 0; i < size; i++) {
            if(!t[i][0].equals(togo)||v[i]) continue;
            v[i] = true;
            dfs(t, n+1, t[i][1]);
            v[i] = false;
        }
        stack.pop();
    }

    public String[] solution(String[][] tickets) {
        tickets = Arrays.stream(tickets).sorted((s1, s2) -> s1[1].compareTo(s2[1]))
                .toArray(String[][]::new);
        size = tickets.length;
        v = new boolean[size];
        dfs(tickets, 0, "ICN");

        return ans.stream().toArray(String[]::new);
    }
}
