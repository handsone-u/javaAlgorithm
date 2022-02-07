package graph;

import java.util.Scanner;

public class Baek1062 {
    static int N, K;
    static String[] words;
    static int ans = 0;
    static boolean[] check = new boolean[26];

    private static void solution() {
        if(K<5)
            return;
        check['a' - 'a'] = check['c' - 'a'] = check['t' - 'a'] = check['i' - 'a'] = check['n' - 'a'] = true;
        
        comb(0, 5);
    }

    private static void comb(int from, int count) {
        if (count == K) {
            int tmp = 0;
            for (int i = 0; i < N; i++) {
                if(isReadable(words[i])) tmp++;
            }
            if(tmp>ans)
                ans = tmp;
            return;
        }
        for (int i = from; i < 26; i++) {
            if(check[i]) continue;
            check[i] = true;
            comb(i + 1, count + 1);
            check[i] = false;
        }
    }

    private static boolean isReadable(String word) {
        char[] chars = word.toCharArray();
        for (char aChar : chars) {
            if(!check[aChar-'a']) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        N = s.nextInt();
        K = s.nextInt();
        words = new String[N];
        for (int i = 0; i < N; i++)
            words[i] = s.next();
        s.close();

        solution();

        System.out.println(ans);
    }
}
