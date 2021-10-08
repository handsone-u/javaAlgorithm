package heap;

import java.util.*;

public class Sol85002 {
    public int[] solution(int[] weights, String[] head2head) {
        int len = weights.length;
        List<Player> players = new ArrayList<>();
        for (int i = 0; i < len; i++) {
            double rate = 0;
            int round = 0, win = 0, winHeavier = 0;
            char[] r = head2head[i].toCharArray();
            for (int j = 0; j < len; j++) {
                if(r[j]=='N') continue;
                else if(r[j]=='W'){
                    if(weights[i]>weights[j]) winHeavier++;
                    win++;
                }
                round++;
            }
            if(round!=0) rate = win / (round*1.0d);
            players.add(new Player(rate, winHeavier, weights[i], i + 1));
        }
        players.sort((o1, o2) -> {
            if(o1.rate < o2.rate) return 1;
            else if(o1.rate == o2.rate) {
                if(o1.heavier < o2.heavier) return 1;
                else if(o1.heavier == o2.heavier) {
                    if(o1.weight < o2.weight) return 1;
                    else if(o1.weight == o2.weight) return o1.num - o2.num;
                    else return -1;
                }
                else return -1;
            }
            else return -1;
        });

        int[] ans = new int[len];
        for (int i = 0; i < len; i++) ans[i] = players.get(i).num;
        return ans;
    }

    static class Player{
        double rate;
        int heavier;
        int weight;
        int num;

        public Player(double rate, int heavier, int weight, int num) {
            this.rate = rate;
            this.heavier = heavier;
            this.weight = weight;
            this.num = num;
        }
    }
}
