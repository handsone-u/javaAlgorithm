package etc;

import java.io.*;

public class Baek23323 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        int t = Integer.parseInt(reader.readLine());
        while (t-->0) {
            String[] s = reader.readLine().split(" ");
            long n = Long.parseLong(s[0]);
            long m = Long.parseLong(s[1]);
            while (n > 0) {
                m += 1;
                n /= 2;
            }
            writer.write(Long.toString(m) + '\n');
        }

        writer.flush();
        writer.close();
    }
}
