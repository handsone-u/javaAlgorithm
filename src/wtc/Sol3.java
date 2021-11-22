package wtc;

import java.util.HashMap;

public class Sol3 {
    public int solution(String[] ings, String[] menu, String[] sell) {
        HashMap<Character, Integer> rawCost = new HashMap<>();
        HashMap<String, Integer> menuCost = new HashMap<>();
        int answer = 0;

        for (String ing : ings) {
            String[] line = ing.split(" ");
            rawCost.put(line[0].toCharArray()[0], Integer.parseInt(line[1]));
        }
        for (String m : menu) {
            String[] line = m.split(" ");
            int cost = Integer.parseInt(line[2]);
            char[] chars = line[1].toCharArray();

            for (char c : chars) {
                cost -= rawCost.get(c);
            }
            menuCost.put(line[0], cost);
        }
        for (String sold : sell) {
            String[] s = sold.split(" ");
            String m = s[0];
            int count = Integer.parseInt(s[1]);

            answer += menuCost.get(m) * count;
        }

        return answer;
    }
}
