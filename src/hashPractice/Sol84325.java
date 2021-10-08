package hashPractice;
import java.util.*;
import java.util.function.Supplier;
import java.util.stream.Collectors;

public class Sol84325 {
    public String solution(String[] table, String[] languages, int[] preference) {
        String answer = "";
        int tableLen = table.length, lanLen = languages.length;
        HashMap<String, Integer> points = new HashMap<>();
        HashMap<String, Integer> lanPrefer = new HashMap<>();
        for(int i=0; i<lanLen; i++) lanPrefer.put(languages[i], preference[i]);
        for (int i = 0; i < tableLen; i++) {
            String[] line = table[i].split(" ");
            int tot = 0;
            for (int j = 1; j < line.length; j++)
                tot += lanPrefer.getOrDefault(line[j], 0) * (6 - j);
            points.put(line[0], tot);
        }
        Set<Map.Entry<String, Integer>> entries = points.entrySet();
        answer = entries.stream()
                .sorted(Map.Entry.comparingByKey())
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .map(s -> s.getKey())
                .collect(Collectors.toCollection(ArrayList::new)).get(0);

        return answer;
    }
}
