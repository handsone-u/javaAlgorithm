package bin_search;

import java.io.*;
import java.util.Arrays;

public class Baek2805 {
    static long n, m, h;
    static long[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] nm = reader.readLine().split(" ");
        String[] trees = reader.readLine().split(" ");
        reader.close();
        n = Long.parseLong(nm[0]);
        m = Long.parseLong(nm[1]);
        arr = new long[(int) n];

        for (int i = 0; i < n; i++) arr[i] = Long.parseLong(trees[i]);
        Arrays.sort(arr);

        long min = 0, max = arr[(int) (n - 1)];
        while (min <= max) {
            long
        }


        writer.write(Long.toString(h));
        writer.flush();
        writer.close();
    }
}
