package prefixsum;

import java.io.*;
import java.util.Arrays;

public class Baek11660 {
    static int n, m;
    static int[][] dp = new int[1026][1026];

    private static int getAns(int x1, int y1, int x2, int y2) {
        return dp[x2][y2] - dp[x2][y1 - 1] - dp[x1 - 1][y2] + dp[x1 - 1][y1 - 1];
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        int[] tmp = Arrays.stream(reader.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        n = tmp[0];
        m = tmp[1];

        for (int i = 1; i <= n; i++) {
            tmp = Arrays.stream(reader.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            for (int j = 1; j <= n; j++) {
                dp[i][j] = dp[i][j - 1] + tmp[j - 1];
            }
            if (i != 0) {
                for (int j = 1; j <= n; j++) {
                    dp[i][j] += dp[i - 1][j];
                }
            }
        }

        for (int i = 0; i < m; i++) {
            tmp = Arrays.stream(reader.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();

            writer.write(Integer.toString(getAns(tmp[0], tmp[1], tmp[2], tmp[3])));
            writer.write('\n');
        }

        reader.close();
        writer.flush();
        writer.close();
    }
}
