package math;

import java.io.*;

public class Baek2163 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] s = reader.readLine().split(" ");
        reader.close();
        int n = Integer.parseInt(s[0]), m = Integer.parseInt(s[1]);

        int ans = 0;
        if(n==1) ans = m - 1;
        else if(m==1) ans = n - 1;
        else ans = n * m - 1;

        writer.write(Integer.toString(ans));
        writer.flush();
        writer.close();
    }
}
