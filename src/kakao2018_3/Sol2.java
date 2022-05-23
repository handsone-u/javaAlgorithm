package kakao2018_3;

import java.util.*;

public class Sol2 {
    HashMap<String, Integer> map = new HashMap<>();
    ArrayList<Integer> result = new ArrayList<>();
    public int[] solution(String msg) {
        for (int i = 0; i < 26; i++) {
            char a = (char) ('A' + i);
            String key = String.valueOf(a);
            map.put(key, i + 1);
        }

        int len = msg.length();
        int i = 0;
        while (i < len) {
            int next = i + 1;
            for (int j = len; j > i; j--) {
                String tmp = msg.substring(i, j);
                if (map.containsKey(tmp)) {
                    result.add(map.get(tmp));
                    if(j+1<=len)
                        map.put(msg.substring(i, j + 1), map.size() + 1);
                    next = j;
                    break;
                }
            }
            i = next;
        }

        return result.stream()
                .mapToInt(o -> o)
                .toArray();
    }
}
