package wtc;

import java.util.ArrayList;

public class Sol1 {
    public int[] solution(int[] arr) {
        int[] answer = new int[3];
        int[] count = new int[4];

        for (int i : arr)
            count[i]++;

        int max = getMax(count);
        for (int i = 0; i < 3; i++) {
            answer[i] = max - count[i + 1];
        }

        return answer;
    }

    private int getMax(int[] count) {
        int max = 0;
        for (int i = 1; i < 4; i++) {
            max = Integer.max(max, count[i]);
        }
        return max;
    }
}
