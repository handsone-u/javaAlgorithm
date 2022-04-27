package kakao2022;

import java.util.Arrays;

public class Solution4_1 {
    int[] answer = new int[11];
    int maxPoint = 0;

    boolean isOk(int[] ryan) {
        for (int i = 10; i >= 0; i--) {
            if(ryan[i]==0&&answer[i]==0)
                continue;
            return ryan[i] > answer[i];
        }
        return true;
    }

    void calculate(int[] ryan, int[] app) {
        int rPoint = 0;
        int aPoint = 0;
        for (int i = 0; i < 11; i++) {
            if(ryan[i]==0&&app[i]==0) continue;
            if(ryan[i]>app[i]) rPoint += 10 - i;
            else aPoint += 10 - i;
        }
        int diff = rPoint - aPoint;
        if (diff >= maxPoint) {
            if(diff==maxPoint&&!isOk(ryan)) return;
            answer = Arrays.copyOf(ryan, 11);
            maxPoint = diff;
        }
    }

    void dfs(int r, int pos, int[] ryan, int[] app) {
        if (r == 0 || pos == 11) {
            ryan[10] += r;
            calculate(ryan, app);
            ryan[10] -= r;
            return;
        }
        if (r > app[pos]) {
            ryan[pos] = app[pos] + 1;
            dfs(r - ryan[pos], pos + 1, ryan, app);
            ryan[pos] = 0;
        }
        dfs(r, pos + 1, ryan, app);
    }

    public int[] solution(int n, int[] info) {
        int[] ryan = new int[11];

        dfs(n, 0, ryan, info);

        if(maxPoint==0)
            return new int[]{-1};
        else
            return answer;
    }
}
