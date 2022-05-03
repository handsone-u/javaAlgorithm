package prefixsum;

import java.io.*;
import java.util.Arrays;

public class Baek10211 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        int t = Integer.parseInt(reader.readLine());
        while (t-- > 0) {
            int max = Integer.MIN_VALUE;
            int n = Integer.parseInt(reader.readLine());
            int[] sum = new int[n + 1];
            int[] arr = Arrays.stream(reader.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            for (int i = 0; i < n; i++) {
                sum[i + 1] = sum[i] + arr[i];
                for (int j = 0; j <= i; j++) {
                    int temp = sum[i + 1] - sum[j];
                    if(temp>max) max = temp;
                }
            }
            writer.write(Integer.toString(max));
            writer.write('\n');
        }
        writer.flush();
        writer.close();
    }
}
