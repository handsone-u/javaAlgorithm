package kakao2022;

public class Solution6_1 {
    int n,m;
    int[][] prefixSum;
    public int solution(int[][] board, int[][] skill) {
        int answer = 0;
        n = board.length;
        m = board[0].length;
        prefixSum = new int[n + 1][m + 1];

        for (int[] s : skill) {
            int degree = s[0] == 1 ? -s[5] : s[5];
            int r1 = s[1];
            int c1 = s[2];
            int r2 = s[3];
            int c2 = s[4];
            prefixSum[r1][c1] += degree;
            prefixSum[r1][c2+1] += -degree;
            prefixSum[r2+1][c1] += -degree;
            prefixSum[r2+1][c2+1] += degree;
        }
        for (int i = 0; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                prefixSum[i][j] += prefixSum[i][j - 1];
            }
        }
        for (int i = 0; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                prefixSum[j][i] += prefixSum[j - 1][i];
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                board[i][j] += prefixSum[i][j];
                if(board[i][j]>=1) answer++;
            }
        }

        return answer;
    }
}
