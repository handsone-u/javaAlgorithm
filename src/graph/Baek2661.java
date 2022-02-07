package graph;

import java.util.Scanner;

public class Baek2661 {
    static int N;
    static char[] x = {'1', '2', '3'};
    static String ans;
    static boolean comp;

    private static void solution(int len, String tmp) {
        if(comp) return;
        if(len==N) {
            ans = tmp;
            comp = true;
            return;
        }
        for (int i = 0; i < 3; i++) {
            String newTmp = tmp + x[i];
            if(!isOk(newTmp)) continue;
            solution(len + 1, newTmp);
        }
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        N = s.nextInt();
        s.close();

        solution(0, "");
        System.out.println(ans);
    }

    private static boolean isOk(String str) {
        int len = str.length();
        if(len==1) return true;

        for (int i = 1; i*2 <= len; i++) {
            String p1 = str.substring(len - i);
            String p2 = str.substring(len - 2 * i, len - i);
            if(p1.equals(p2)) {
                return false;
            }
        }
        return true;
    }
}
