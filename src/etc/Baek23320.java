package etc;

import java.io.*;
import java.util.Arrays;

public class Baek23320 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(reader.readLine());
        int[] arr = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[] res = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int r1 = 0, r2 = 0;

        r1 = n * res[0] / 100;
        for (int i = 0; i < n; i++) if (arr[i] >= res[1]) r2++;

        writer.write(Integer.toString(r1) + " " + Integer.toString(r2));
        writer.flush();
        writer.close();
    }
}
