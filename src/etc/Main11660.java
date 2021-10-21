package etc;

import java.io.*;
import java.util.Arrays;

/**
 * 11660
 * prefix-sum
 */
public class Main11660 {
    static BufferedReader br;
    static BufferedWriter bw;
    static int n, m;
    static int[][] sum = new int[1025][1025];

    public static void main(String[] args) throws IOException {
        init();
        int[] tmp = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        n = tmp[0];
        m = tmp[1];
        for (int i = 1; i <= n; i++) {
            tmp = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            for (int j = 1; j <= n; j++)
                sum[i][j] = tmp[j - 1] + sum[i][j - 1] + sum[i - 1][j] - sum[i - 1][j - 1];
        }
        for (int i = 0; i < m; i++) {
            tmp = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            int cnt = sum[tmp[2]][tmp[3]] - sum[tmp[2]][tmp[1]-1] - sum[tmp[0]-1][tmp[3]]+sum[tmp[0]-1][tmp[1]-1];
            bw.write(Integer.toString(cnt));
            bw.write("\n");
        }

        close();
    }


    private static void init() {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
    }

    private static void close() throws IOException {
        br.close();
        bw.flush();
        bw.close();
    }
}
