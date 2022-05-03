package prefixsum;

import java.io.*;

public class Baek2118 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        int ans = 0;
        int n = Integer.parseInt(reader.readLine());
        int[] sum = new int[n + 1];
        for (int i = 0; i < n; i++) {
            sum[i + 1] = sum[i] + Integer.parseInt(reader.readLine());
        }

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j <= n; j++) {
                int clock = sum[j] - sum[i];
                int counter = sum[n] - clock;
                int temp = Integer.min(clock, counter);
                if(ans<temp) ans = temp;
            }
        }

        reader.close();
        writer.write(Integer.toString(ans));
        writer.flush();
        writer.close();
    }
}
