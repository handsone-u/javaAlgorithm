package prefixsum;

import java.io.*;
import java.util.*;

public class Baek2015 {
    static int n, k;
    static long ans;
    static int[] arr, preSum;
    static Map<Integer, Long> map = new HashMap<>();

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        reading(reader);

        for (int i = 1; i <=n; i++) {
            preSum[i] = preSum[i - 1] + arr[i - 1];
            if(preSum[i]==k) ans++;

            ans += map.getOrDefault(preSum[i] - k, 0L);
            map.put(preSum[i], map.getOrDefault(preSum[i], 0L) + 1);
        }

        writer.write(Long.toString(ans));
        writer.flush();
        writer.close();
    }

    private static void reading(BufferedReader reader) throws IOException {
        int[] tmp;
        tmp = Arrays.stream(reader.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        n = tmp[0];
        k = tmp[1];

        preSum = new int[n + 1];
        arr = Arrays.stream(reader.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
    }
}
