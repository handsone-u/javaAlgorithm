package etc;

import java.io.*;
import java.util.Arrays;

public class Baek23322 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] s = reader.readLine().split(" ");
        int n = Integer.parseInt(s[0]);
        int k = Integer.parseInt(s[1]);

        int[] x = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        reader.close();

        int min = x[0];
        int total = 0, day = 0;
        for (int i = 1; i < x.length; i++) {
            int tmp = x[i] - x[0];
            if(tmp>0){
                total += tmp;
                day++;
            }
        }
        writer.write(Integer.toString(total) + " " + Integer.toString(day));

        writer.flush();
        writer.close();
    }
}
