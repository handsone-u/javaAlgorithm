package kakao2018_1;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class Sol3 {
    List<String> list = new LinkedList<>();
    Set<String> set = new HashSet<>();

    private void reload(String city) {
        list.remove(city);
        list.add(0, city);
    }

    private void replace(int size, String city) {
        String least = list.get(size - 1);
        set.remove(least);
        list.remove(size - 1);

        list.add(0, city);
        set.add(city);
    }

    public int solution(int cacheSize, String[] cities) {
        int answer = 0;
        int size = 0;
        int len = cities.length;

        if(cacheSize==0) return 5 * len;

        for (int i = 0; i < len; i++) {
            String city = cities[i].toLowerCase();

            if (set.contains(city)) {
                answer += 1;
                reload(city);
            } else {
                if (size < cacheSize) {
                    list.add(0, city);
                    set.add(city);
                    size++;
                } else {
                    replace(size, city);
                }
                answer += 5;
            }
        }

        return answer;
    }
}
