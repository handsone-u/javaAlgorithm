package prefixsum;

import java.io.*;
import java.util.Arrays;
import java.util.HashMap;

public class Baek2143 {
    static long solution(int[] a, int[] b, int n, int m, int t) {
        HashMap<Integer, Long> map = new HashMap<>();
        long answer = 0;
        int[] aSum = new int[n + 1];
        int[] bSum = new int[m + 1];
        for (int i = 0; i < n; i++) aSum[i + 1] = aSum[i] + a[i];
        for (int i = 0; i < m; i++) bSum[i + 1] = bSum[i] + b[i];

        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < i; j++) {
                int key = aSum[i] - aSum[j];
                long value = map.getOrDefault(key, 0L);
                map.put(key, value + 1);
            }
        }
        for (int i = 1; i <= m; i++) {
            for (int j = 0; j < i; j++) {
                int key = bSum[i] - bSum[j];
                answer += map.getOrDefault(t - key, 0L);
            }
        }
        return answer;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        int t = Integer.parseInt(reader.readLine());
        int n = Integer.parseInt(reader.readLine());
        int[] aArr = Arrays.stream(reader.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        int m = Integer.parseInt(reader.readLine());
        int[] bArr = Arrays.stream(reader.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        long answer = solution(aArr, bArr, n, m, t);
        writer.write(Long.toString(answer));
        writer.write('\n');
        reader.close();
        writer.flush();
        writer.close();
    }
}
