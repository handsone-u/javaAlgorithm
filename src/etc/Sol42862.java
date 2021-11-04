package etc;

import java.util.Arrays;
import java.util.HashSet;

/**
 * Greedy
 * 4, [3, 1], [2, 4]->4
 */
public class Sol42862 {
    public int solution(int n, int[] lost, int[] reserve) {
        Arrays.sort(lost);
        Arrays.sort(reserve);

        HashSet<Integer> hasReserve = new HashSet<>();

        int answer = 0, lLen = lost.length, rLen = reserve.length;
        answer = n - lLen;
        boolean[] got = new boolean[n + 1];
        for (int i : reserve)
            got[i] = true;
        for (int i : lost)
            if (got[i]) {
                hasReserve.add(i);
                answer++;
                got[i] = false;
            }

        for (int i = 0; i < lLen; i++) {
            int lostIndex = lost[i];
            if(hasReserve.contains(lostIndex)) continue;

            if(lostIndex>1&&got[lostIndex-1]){
                got[lostIndex - 1] = false;
                answer++;
            } else if(lostIndex<n&&got[lostIndex+1]){
                got[lostIndex + 1] = false;
                answer++;
            }
        }

        return answer;
    }
}
