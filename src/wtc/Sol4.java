package wtc;

import java.util.ArrayList;
import java.util.Comparator;

public class Sol4 {
    public int[] solution(String s) {
        int[] answer = {};
        char[] arr = s.toCharArray();
        int len = s.length();
        ArrayList<Integer> ans = new ArrayList<>();

        for (int i = 0; i < len;) {
            int count = 0;
            char current = arr[i];
            int j = i + 1;
            while (j < len) {
                if(arr[j]!=current) break;
                j++;
            }
            count = j - i;
            i = j;
            ans.add(count);
        }

        if (ans.size()!=1&&arr[0] == arr[len - 1]) {
            int count = ans.get(0) + ans.get(ans.size() - 1);
            ans.remove(ans.size() - 1);
            ans.remove(0);
            ans.add(count);
        }
        answer = ans.stream().sorted(Comparator.naturalOrder())
                .mapToInt(i -> i)
                .toArray();

        return answer;
    }
}
