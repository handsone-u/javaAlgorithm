import java.util.HashMap;

class Solution2 {
    
    public int solution(int[] queue1, int[] queue2) {
        int answer = -1;
        int len = queue1.length;
        long total = 0;

        HashMap<Long, Integer> q1Map = new HashMap<>();
        HashMap<Long, Integer> q2Map = new HashMap<>();
        long[] pSum1 = new long[len+1];
        long[] pSum2 = new long[len+1];
        for (int i = 0; i < len; i++) {
            pSum1[i + 1] = pSum1[i] + queue1[i];
            pSum2[i + 1] = pSum2[i] + queue2[i];
            total += queue1[i] + queue2[i];
        }
        long total1 = pSum1[len];
        long total2 = pSum2[len];
        
        for (int i = 0; i < len; i++) {
            long value = total1 - pSum1[i + 1];
            Integer index = q1Map.getOrDefault(value, i + 1);
            q1Map.put(value, index);

            value = total2 - pSum2[i + 1];
            index = q2Map.getOrDefault(value, i + 1);
            q2Map.put(value, index);
        }

        if(pSum1[len]==pSum2[len]) return 0;

        answer = solve(answer, len, total, pSum1, pSum2,queue1,queue2, q1Map, q2Map);
        answer = solve(answer, len, total, pSum2, pSum1,queue2,queue1, q2Map, q1Map);

        return answer;
    }

    private int solve(int answer, int len, long total, long[] pSum1, long[] pSum2, int[] q1, int[] q2, HashMap<Long, Integer> m1, HashMap<Long, Integer> m2) {
        for (int i = 0; i <= len; i++) {
            long part1 = pSum1[i];
            Integer value = m2.get(total / 2 - part1);
            if(value==null) continue;
            int count = i + value;
            if(answer==-1) answer = count;
            else if(answer>count) answer = count;
        }

        for (int i = 0; i < len; i++) {
            if (q2[i] == total / 2) {
                int count = i + 1 + i + len;
                if (answer == -1) answer = count;
                else if (answer > count) answer = count;
            }
        }
        return answer;
    }
}