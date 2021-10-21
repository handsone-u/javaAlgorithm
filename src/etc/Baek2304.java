package etc;

import java.io.*;
import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.Stream;

public class Baek2304 {
    static int n,ans;
    static Pos[] posT;


    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        n = Integer.parseInt(reader.readLine());
        posT = new Pos[n];
        for (int i = 0; i < n; i++) {
            String[] s = reader.readLine().split(" ");
            int x = Integer.parseInt(s[0]);
            int y = Integer.parseInt(s[1]);
            posT[i] = new Pos(x, y);
        }
        reader.close();

        Pos[] pos = Arrays.stream(posT).sorted(Comparator.comparing(p -> p.x))
                .toArray(Pos[]::new);

        int lPreX = pos[0].x, rPreX = pos[n - 1].x;
        int lPreY = pos[0].y, rPreY = pos[n - 1].y;
        for (int i = 1; i < n; i++) {
            boolean higher = pos[i].y >= lPreY;
            int gap = pos[i].x - lPreX;
            if(higher) {
                ans += gap * lPreY;
                lPreX = pos[i].x;
                lPreY = pos[i].y;
            }
        }
        for (int i = n-1; i >= 0; i--) {
            boolean higher = pos[i].y > rPreY;
            int gap = rPreX - pos[i].x;
            if (higher) {
                ans += gap * rPreY;
                rPreX = pos[i].x;
                rPreY = pos[i].y;
            }
        }
        ans += Arrays.stream(posT).max(Comparator.comparing(p -> p.y)).get().y;

        writer.write(Integer.toString(ans));
        writer.flush();
        writer.close();
    }

    static class Pos {
        public int x;
        public int y;

        public Pos(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
