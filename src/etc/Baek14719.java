package etc;

import java.io.*;

public class Baek14719 {
    static int h, w;
    static int[] box;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] s = reader.readLine().split(" ");
        h = Integer.parseInt(s[0]);
        w = Integer.parseInt(s[1]);
        box = new int[w + 1];

        String[] s1 = reader.readLine().split(" ");
        reader.close();
        for (int i = 0; i < w; i++) box[i] = Integer.parseInt(s1[i]);

        int ans = 0;
        for (int i = 1; i < w-1; i++) ans += minInMiddle(i);

        writer.write(Integer.toString(ans));
        writer.flush();
        writer.close();
    }

    private static int minInMiddle(int index) {
        int height = box[index];
        int lHeight = height, rHeight = height;

        for (int i = index+1; i < w; i++) if (rHeight < box[i]) rHeight = box[i];
        for (int i = index-1; i >= 0; i--) if (lHeight < box[i]) lHeight = box[i];

        int min = Integer.min(lHeight, rHeight);

        return min - height;
    }
}
