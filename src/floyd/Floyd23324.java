package floyd;

import java.io.*;
import java.util.Arrays;

/**
 *
 */
public class Floyd23324 {

    static long n,m, K, ans;
    static int[][] d;
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] s = reader.readLine().split(" ");
        n = Long.parseLong(s[0]);
        m = Long.parseLong(s[1]);
        K = Long.parseLong(s[2]);
        d = new int[(int) n + 1][(int) n + 1];
        for (int i = 1; i < n + 1; i++) Arrays.fill(d[i], (int)n + 1);

        for (int i = 0; i < m; i++) {
            s = reader.readLine().split(" ");
            int u = Integer.parseInt(s[0]);
            int v = Integer.parseInt(s[1]);
            if(i+1== K) d[u][v] = d[v][u] = 1;
            else d[u][v] = d[v][u] = 0;
        }
        reader.close();

        for (int j = 1; j <= n; j++) {
            for (int i = 1; i <=n; i++) {
                for (int k = 1; k <=n; k++) {
                    d[i][k] = Integer.min(d[i][k], d[i][j] + d[j][k]);
                }
            }
        }

        for (int i = 1; i <= n; i++) {
            for (int j = i+1; j <= n; j++) ans += d[i][j];
        }

        writer.write(Long.toString(ans));
        writer.flush();
        writer.close();
    }
}
