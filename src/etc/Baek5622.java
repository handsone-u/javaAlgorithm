package etc;

import java.io.*;

public class Baek5622 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        int ans = 0;
        String line = reader.readLine();
        char[] arr = line.toCharArray();
        reader.close();

        for (char c : arr) {
            ans += getValue(c) + 1;
        }

        writer.write(String.valueOf(ans));
        writer.flush();
        writer.close();
    }

    private static int getValue(char c) {
        if(c>='A'&&c<='C') return 2;
        else if(c>='D'&&c<='F') return 3;
        else if(c>='G'&&c<='I') return 4;
        else if(c>='J'&&c<='L') return 5;
        else if(c>='M'&&c<='O') return 6;
        else if(c>='P'&&c<='S') return 7;
        else if(c>='T'&&c<='V') return 8;
        else return 9;
    }

}
