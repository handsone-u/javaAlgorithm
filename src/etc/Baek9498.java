package etc;

import java.io.*;

public class Baek9498 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(reader.readLine());
        reader.close();
        int mod = n / 10;
        char ans;

        if (mod >= 9) {
            ans = 'A';
        } else if (mod >= 8) {
            ans = 'B';
        } else if (mod >= 7) {
            ans = 'C';
        } else if (mod >= 6) {
            ans = 'D';
        } else {
            ans = 'F';
        }

        writer.write(ans);
        writer.flush();
        writer.close();
    }
}
