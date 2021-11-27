package etc;

import java.io.*;

public class Baek2630 {
    static int k, w, b;
    static boolean[][] white;
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        readAndClose(reader);

        getPaper(0, 0, k);

        writeAndClose(writer);
    }

    public static void getPaper(int x, int y, int len) {
        boolean united = isUnited(x, y, len);
        if (united) {
            if(white[x][y]) w++;
            else b++;
            return;
        }

        int half = len / 2;
        getPaper(x, y, half);
        getPaper(x + half, y, half);
        getPaper(x, y + half, half);
        getPaper(x + half, y + half, half);
    }

    public static boolean isUnited(int x, int y, int len) {
        boolean color = white[x][y];
        for (int i = x; i < x+len; i++) {
            for (int j = y; j < y + len; j++) {
                if(color!=white[i][j]) return false;
            }
        }
        return true;
    }

    private static void writeAndClose(BufferedWriter writer) throws IOException {
        writer.write(String.valueOf(w));
        writer.write("\n");
        writer.write(String.valueOf(b));
        writer.flush();
        writer.close();
    }

    private static void readAndClose(BufferedReader reader) throws IOException {
        k = Integer.parseInt(reader.readLine());
        white = new boolean[k][k];
        for (int i = 0; i < k; i++) {
            String[] line = reader.readLine().split(" ");
            for (int j = 0; j < k; j++) {
                white[i][j] = line[j].equals("0");
            }
        }
        reader.close();
    }
}
