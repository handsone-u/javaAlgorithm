package graph;

/**
 * DFS
 * https://programmers.co.kr/learn/courses/30/lessons/1829
 */
public class Sol1829 {
    int[] dx = {1, 0, -1, 0};
    int[] dy = {0, 1, 0, -1};
    int gm, gn;
    boolean[][] v;

    public int[] solution(int m, int n, int[][] picture) {
        int numberOfArea = 0;
        int maxSizeOfOneArea = 0;
        v = new boolean[m][n];
        gm = m;
        gn = n;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if(v[i][j]||picture[i][j]==0) continue;
                numberOfArea++;
                maxSizeOfOneArea = Integer.max(maxSizeOfOneArea, dfs(i, j, picture));
            }
        }

        int[] answer = new int[2];
        answer[0] = numberOfArea;
        answer[1] = maxSizeOfOneArea;
        return answer;
    }

    public int dfs(int x, int y, int[][] pic) {
        v[x][y] = true;
        int count = 1;
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if(isOut(nx, ny)||v[nx][ny]||pic[nx][ny]!=pic[x][y]||pic[nx][ny]==0) continue;
            count += dfs(nx, ny, pic);
        }

        return count;
    }

    private boolean isOut(int x,int y){
        if(x<0||y<0||x>=gm||y>=gn) return true;
        return false;
    }
}
