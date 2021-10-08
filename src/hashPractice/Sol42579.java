package hashPractice;

import java.util.*;

public class Sol42579 {
    public int[] solution(String[] genres, int[] plays) {
        ArrayList<Integer> answer = new ArrayList<>();
        final int len = plays.length;
        HashMap<String, ArrayList<Integer>> mapIndex = new HashMap<>();
        HashMap<String, Integer> mapTime = new HashMap<>();

        for (int i = 0; i < len; i++) {
            ArrayList<Integer> tmp = mapIndex.getOrDefault(genres[i], new ArrayList<>());
            tmp.add(i);
            mapIndex.put(genres[i], tmp);
            mapTime.put(genres[i], mapTime.getOrDefault(genres[i], 0) + plays[i]);
        }
        ArrayList<String> keys = new ArrayList<>(mapTime.keySet());
        keys.sort((k1, k2)-> mapTime.get(k2) - mapTime.get(k1));
        for (String key : keys) {
            ArrayList<Integer> selectGenre = mapIndex.get(key);
            selectGenre.stream()
                    .sorted((i1, i2) -> plays[i2]-plays[i1])
                    .limit(2)
                    .forEach(answer::add);
        }

        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
}
