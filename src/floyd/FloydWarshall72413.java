package floyd;

import java.util.ArrayList;
import java.util.Arrays;

public class FloydWarshall72413 {
    static ArrayList<Node>[] v;
    static int[][] dp;
    static final int INF = 20000000;

    public int solution(int n, int s, int a, int b, int[][] fares) {
        int len = fares.length;

        v = new ArrayList[n + 1];
        dp = new int[n + 1][n + 1];

        for (int i = 0; i < n + 1; i++) {
            Arrays.fill(dp[i], INF);
            dp[i][i] = 0;
            v[i] = new ArrayList<>();
        }

        for (int i = 0; i < len; i++) {
            v[fares[i][0]].add(new Node(fares[i][1], fares[i][2]));
            v[fares[i][1]].add(new Node(fares[i][0], fares[i][2]));
            dp[fares[i][0]][fares[i][1]] = fares[i][2];
            dp[fares[i][1]][fares[i][0]] = fares[i][2];
        }

        for (int k = 1; k <= n; k++) {
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n ; j++) {
                   if(dp[i][k]==INF||dp[k][j]==INF) continue;
                    dp[i][j] = Integer.min(dp[i][j], dp[i][k] + dp[k][j]);
                }
            }
        }

//        printResult(n);

        return Integer.min(dp[s][a] + dp[s][b], search(s, a, b, n));
    }

    private void printResult(int n) {
        // 프롤이드-와샬 결과 확인용
        // 시간초과 유발
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.printf("%d ", dp[i + 1][j + 1]);
            }
            System.out.println();
        }
    }

    private int search(int s, int a, int b, int n) {
        int result = INF;
        for (int k = 1; k <= n; k++) {
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++) {
                    if(dp[s][k]==INF||dp[k][a]==INF||dp[k][b]==INF) continue;
                    result = Integer.min(result, dp[s][k] + dp[k][a] + dp[k][b]);
                }
            }
        }
        return result;
    }

    static class Node{
        private int target;
        private int weight;

        public Node(int target, int weight) {
            this.target = target;
            this.weight = weight;
        }

        public int getWeight() {
            return weight;
        }

        public int getTarget() {
            return target;
        }
    }
}
