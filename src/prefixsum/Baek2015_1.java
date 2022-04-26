package prefixsum;

import java.io.*;
import java.util.Arrays;
import java.util.HashMap;

public class Baek2015_1 {
    static int n,k,ans;
    static int[] arr;
    static int[] sum;

    static void solution() {
        HashMap<Integer, Integer> sumKey = new HashMap<>();
        sum = new int[n + 1];
        for (int i = 0; i < n; i++) {
            sum[i + 1] = sum[i] + arr[i];
            if(sum[i+1]==k) ans++;

            ans += sumKey.getOrDefault(sum[i + 1] - k, 0);
            sumKey.put(sum[i + 1], sumKey.getOrDefault(sum[i + 1], 0) + 1);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        reading(reader);

        solution();

        writer.write(String.valueOf(ans));
        writer.flush();
        writer.close();
    }

    static void reading(BufferedReader reader) throws IOException {
        String[] str = reader.readLine().split(" ");
        n = Integer.parseInt(str[0]);
        k = Integer.parseInt(str[1]);
        arr = Arrays.stream(reader.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        reader.close();
    }
}
