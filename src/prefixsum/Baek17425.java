package prefixsum;

import java.io.*;
import java.util.Arrays;

public class Baek17425 {
    static long[] dp = new long[1000001];
    static long[] sum = new long[1000001];

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        int t = Integer.parseInt(reader.readLine());
        sum[1] = dp[1] = 1;
        Arrays.fill(dp, 1);

        for (int i = 2; i <= 1000000; i++) {
            for (int j = 1; j * i <= 1000000; j++) {
                dp[i * j] += i;
            }
            sum[i] = sum[i - 1] + dp[i];
        }

        while (t-- > 0) {
            int n = Integer.parseInt(reader.readLine());
            writer.write(Long.toString(sum[n]));
            writer.write('\n');
        }
        reader.close();
        writer.flush();
        writer.close();
    }
}
