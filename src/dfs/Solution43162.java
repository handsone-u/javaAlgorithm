package dfs;

public class Solution43162 {
    private void dfs(int n, int[][] pcs, boolean[] visit, int c) {
        visit[c] = true;
        for (int i = 0; i < n; i++) {
            if(visit[i]) continue;
            if(pcs[c][i]==0) continue;
            dfs(n, pcs, visit, i);
        }
    }

    public int solution(int n, int[][] computers) {
        int ans = 0;
        boolean[] visit = new boolean[n];

        for (int i = 0; i < n; i++) {
            if(visit[i]) continue;
            ans++;
            dfs(n, computers, visit, i);
        }

        return ans;
    }
}
