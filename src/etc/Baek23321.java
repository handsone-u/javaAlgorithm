package etc;

import java.io.*;

public class Baek23321 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] arr = new String[5];
        char[][] ans;

        for (int i = 0; i < 5; i++) arr[i] = reader.readLine();
        int length = arr[0].length();
        ans = new char[5][length];
        for (int i = 0; i < 5; i++) ans[i] = arr[i].toCharArray();
        for (int i = 0; i < length; i++) {
            if(ans[0][i]=='.'&&ans[1][i]=='.') continue;
            else if (ans[0][i] == '.') {
                ans[0][i] = 'o';
                ans[1][i] = 'w';
                ans[2][i] = 'l';
                ans[3][i] = 'n';
                ans[4][i] = '.';
            } else {
                ans[0][i] = '.';
                ans[1][i] = 'o';
                ans[2][i] = 'm';
                ans[3][i] = 'l';
                ans[4][i] = 'n';
            }
        }
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < length; j++) writer.write(ans[i][j]);
            writer.write('\n');
        }

        writer.flush();
        writer.close();
    }
}
