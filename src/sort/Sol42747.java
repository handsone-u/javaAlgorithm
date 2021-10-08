package sort;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Sol42747 {
    public int solution(int[] citations) {
        int answer = 0, n = citations.length;
        List<Integer> list = Arrays.stream(citations).boxed()
                .sorted(Comparator.reverseOrder())
                .collect(Collectors.toList());
        int h = list.get(0);
        for (int i = h; i>=0; i--) {
            int tmp = i;
            long over = list.stream().filter(t -> t >= tmp).count();
            if(over>=i&&n-over<=i) return i;
        }
        return 1;
    }
}
