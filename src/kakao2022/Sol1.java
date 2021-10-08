package kakao2022;

import java.util.*;

public class Sol1 {
    public int[] solution(String[] id_list, String[] report, int k) {
        int rLen = report.length;
        int idLen = id_list.length;
        int[] answer = new int[idLen];
        HashMap<String, Set<String>> block = new HashMap<>();
        HashMap<String, Set<String>> reporter = new HashMap<>();

        for (int i = 0; i < rLen; i++) {
            String[] cmd = report[i].split(" ");

            Set<String> b = block.getOrDefault(cmd[1], new HashSet<>());
            b.add(cmd[0]);
            block.put(cmd[1] ,b);

            Set<String> r = reporter.getOrDefault(cmd[0], new HashSet<>());
            r.add(cmd[1]);
            reporter.put(cmd[0], r);
        }

        for (int i = 0; i < idLen; i++) {
            int cnt = 0;
            Set<String> now = reporter.getOrDefault(id_list[i], new HashSet<>());
            for (String rs : now) if (block.get(rs).size() >= k) cnt++;
            answer[i] = cnt;
        }

        return answer;
    }
}
