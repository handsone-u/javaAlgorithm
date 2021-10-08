package etc;

import java.util.*;

public class Sol86048 {
    public int[] solution(int[] enter, int[] leave) {
        int length = enter.length;
        int[] answer = new int[length];
        boolean[][] met = new boolean[length + 1][length + 1];
        List<Integer> list = new ArrayList<>(length);
        int k = 0;

        for (int i = 0; i < length; i++) {
            int toLeave = leave[i];
            if(list.contains(toLeave)) {
                list.remove((Integer)(toLeave));
                continue;
            }
            while (k<length) {
                boolean pass = enter[k]==toLeave;
                for (Integer j : list) met[j][enter[k]] = met[enter[k]][j] = true;
                list.add(enter[k]);
                k++;
                if(pass) break;
            }
            if(list.isEmpty()) continue;

            list.remove(list.size() - 1);
        }
        for (int i = 0; i < length; i++) {
            for (boolean b : met[i+1]) if (b) answer[i]++;
        }
        return answer;
    }
}
