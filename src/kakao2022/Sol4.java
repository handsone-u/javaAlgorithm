package kakao2022;

import java.util.Arrays;

public class Sol4 {
    int aMin, bMax;
    public int[] solution(int n, int[] info) {
        int[] answer = {};
        for (int i = 0; i < 11; i++) aMin += (10 - i) * info[i];
        if (aMin >= n * 10) {
            answer = new int[1];
            answer[0] = -1;
            return answer;
        }

        return answer;
    }
}
