package prefixsum;

import java.io.*;
import java.util.Arrays;

public class Baek11441 {
    static int n,m;
    static int[] arr,dp;

    private static void prefixSum() {
        for (int i = 1; i <= n ; i++) {
            dp[i] = dp[i - 1] + arr[i - 1];
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        n = Integer.parseInt(reader.readLine());
        arr = Arrays.stream(reader.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        dp = new int[n + 1];

        prefixSum();

        m = Integer.parseInt(reader.readLine());
        for (int i = 0; i < m; i++) {
            int[] tmp = Arrays.stream(reader.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();

            int result = dp[tmp[1]] - dp[tmp[0] - 1];

            writer.write(Integer.toString(result));
            writer.write('\n');
        }
        writer.flush();
        writer.close();
    }
}
