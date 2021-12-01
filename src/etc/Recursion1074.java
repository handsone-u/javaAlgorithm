package etc;

import java.io.*;
import java.util.Arrays;

public class Recursion1074 {
    static int ans,r,c;

    static boolean dfs(int x, int y, int len, int cnt) {
        if (len == 1) {
            if (x == r && y == c) {
                ans = cnt;
                return true;
            }
            else return false;
        }

        int left = len / 2;
        int block = left * left;

        if (isInBlock(x, y, left)) {
            return dfs(x, y, left, cnt);
        } else if (isInBlock(x, y + left, left)) {
            return dfs(x, y + left, left, cnt + block);
        } else if (isInBlock(x + left, y, left)) {
            return dfs(x + left, y, left, cnt + block * 2);
        } else {
            return dfs(x + left, y + left, left, cnt + block * 3);
        }
    }

    static boolean isInBlock(int x, int y, int len) {
        return r >= x && r < x + len && c >= y && c < y + len;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        int[] tmp = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        reader.close();

        int len = 1 << tmp[0];
        r = tmp[1];
        c = tmp[2];

        dfs(0, 0, len, 0);

        writer.write(String.valueOf(ans));
        writer.flush();
        writer.close();
    }
}
