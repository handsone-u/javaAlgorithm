package string;

import java.util.ArrayList;
import java.util.HashMap;

public class Solution42888 {
    public String[] solution(String[] r) {
        HashMap<String, String> idNick = new HashMap<>();
        String[] macro = {"님이 들어왔습니다.", "님이 나갔습니다."};
        String[] act = {"Enter", "Leave", "Change"};
        ArrayList<Pair> pairs = new ArrayList<>();
        for (String s : r) {
            String[] com = s.split(" ");
            if (com[0].equals(act[2])) {
                idNick.put(com[1], com[2]);
            } else {
                if (com[0].equals(act[0])) {
                    idNick.put(com[1], com[2]);
                    pairs.add(new Pair(com[1], macro[0]));
                } else {
                    pairs.add(new Pair(com[1], macro[1]));
                }
            }
        }
        String[] ans = new String[pairs.size()];
        for (int i = 0; i < pairs.size(); i++) {
            Pair pair = pairs.get(i);
            ans[i] = idNick.get(pair.first) + pair.second;
        }
        return ans;
    }

    static class Pair {
        public String first;
        public String second;

        public Pair(String first, String second) {
            this.first = first;
            this.second = second;
        }
    }
}
