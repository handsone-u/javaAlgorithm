package etc;

public class Sol87946 {
    int answer;
    boolean[] v;
    public int solution(int k, int[][] dungeons) {
        int len = dungeons.length;
        answer = 0;
        v = new boolean[len];

        dfs(k, 0, len, dungeons);

        return answer;
    }

    private void dfs(int k, int cnt, int len, int[][] d) {
        if (cnt >= len) {
            answer = cnt;
            return;
        }
        for (int i = 0; i < len; i++) {
            if (v[i]) continue;
            if(k<d[i][0]) continue;
            v[i] = true;
            dfs(k - d[i][1], cnt + 1, len, d);
            v[i] = false;
        }
        if(answer<cnt)
            answer = cnt;
    }
}
