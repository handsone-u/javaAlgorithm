package kakao2022;

import java.util.HashMap;

public class Solution1_1 {
    HashMap<String, Integer> index = new HashMap<>();
    int[] reported;
    boolean[][] log;

    public int[] solution(String[] idList, String[] report, int k) {
        int n = idList.length;
        log = new boolean[n][n];
        reported = new int[n];
        int[] answer = new int[n];

        for (int i = 0; i < n; i++) {
            index.put(idList[i], i);
        }

        for (String s : report) {
            String[] reportArr = s.split(" ");
            Integer one = index.get(reportArr[0]);
            Integer two = index.get(reportArr[1]);
            if(log[one][two]) continue;
            log[one][two] = true;

            reported[two]++;
        }

        for (int i = 0; i < n; i++) {
            if(reported[i]<k) continue;
            for (int j = 0; j < n; j++) {
                if(!log[j][i]) continue;
                answer[j]++;
            }
        }

        return answer;
    }
}
