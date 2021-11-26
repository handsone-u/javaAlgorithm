package dataStructure;

import java.io.*;
import java.util.ArrayList;

/**
 * Hanoi Tower
 * 문제해결을 위해 문제를 작은 단위로 나눠서 해결한다.
 */
public class Recursion {
    static int k;
    static ArrayList<String> ans;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        k = Integer.parseInt(reader.readLine());
        ans = new ArrayList<>();

        moveTower(k, 1, 3, 2);
        writer.write(String.valueOf(ans.size()) + "\n");
        for (String str : ans) {
            writer.write(str);
        }

        writer.flush();
        writer.close();
    }

    private static void moveTower(int currentK, int from, int to, int through) {
        // 가장 아래를 제외한 나머지 탑을 경유지(through)로 보냄
        if(currentK>1) {
            moveTower(currentK - 1, from, through, to);
        }

        // 현재 탑의 가장 아래를 목표지(to)로 보냄
        ans.add(from + " " + to + "\n");

        // 경유지로 보냈던 나머지 부분을 목표지로 보냄
        if (currentK > 1) {
            moveTower(currentK - 1, through, to, from);
        }
    }
}
