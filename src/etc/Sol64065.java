package etc;

import java.util.*;

public class Sol64065 {
    public int[] solution(String str) {
        int[] answer;
        ArrayList<int[]> arr = new ArrayList<>();
        HashSet<Integer> map = new HashSet<>();
        String[] split = str.split("\\},\\{");

        for (String s : split) {
            s = s.replace("{", "");
            s = s.replace("}", "");

            String[] line = s.split(",");
            int[] tmp = Arrays.stream(line)
                    .mapToInt(Integer::parseInt)
                    .toArray();

            arr.add(tmp);
        }
        Collections.sort(arr, Comparator.comparing(i -> i.length));

        int size = arr.size();
        answer = new int[size];

        for (int i = 0; i < size; i++) {
            int[] tmp = arr.get(i);
            for (int j = 0; j < tmp.length; j++) {
                if(map.contains(tmp[j])) continue;
                else{
                    map.add(tmp[j]);
                    answer[i] = tmp[j];
                }
            }
        }

        return answer;
    }
}
