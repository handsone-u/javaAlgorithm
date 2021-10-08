package hashPractice;

import java.util.HashMap;

public class Sol42578 {
    public int solution(String[][] clothes) {
        int answer = 1, len = clothes.length;
        HashMap<String, Integer> map = new HashMap<>();
        for (String[] cs : clothes) map.put(cs[1], map.getOrDefault(cs[1], 0) + 1);
        for (Integer v : map.values()) answer *= v+1;

        return answer!=1? answer-1:1;
    }
}
