package etc;

import java.io.*;
import java.util.Arrays;

public class Baek2231 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        String line = reader.readLine();
        reader.close();

        int num = Integer.parseInt(line);
        int ans = 0, m = num;

        while (m > 0) {
            if(m+getSplit(m)==num)
                ans = m;
            m--;
        }

        writer.write(String.valueOf(ans));
        writer.flush();
        writer.close();

    }

    private static int getSplit(int m) {
        return Arrays.stream(String.valueOf(m).split(""))
                .mapToInt(Integer::parseInt)
                .sum();
    }
}
