package kakao2018_1;

import java.util.*;

public class Sol5 {
    Map<String, Integer> m1 = new HashMap<>();
    Map<String, Integer> m2 = new HashMap<>();

    public int solution(String str1, String str2) {
        int answer = 0;
        int len1 = str1.length();
        int len2 = str2.length();
        char[] arr1 = str1.toCharArray();
        char[] arr2 = str2.toCharArray();

        int common = 0;
        int union = 0;

        for (int i = 0; i < len1-1; i++) {
            if(!isAlpha(arr1[i])||!isAlpha(arr1[i+1])) continue;
            String tmp = toLower(arr1[i], arr1[i + 1]);
            m1.put(tmp, m1.getOrDefault(tmp, 0) + 1);
            union++;
        }

        for (int i = 0; i < len2-1; i++) {
            if(!isAlpha(arr2[i])||!isAlpha(arr2[i+1])) continue;
            String tmp = toLower(arr2[i], arr2[i + 1]);
            m2.put(tmp, m2.getOrDefault(tmp, 0) + 1);
            union++;
        }


        for (String k : m1.keySet()) {
            Integer value1 = m1.get(k);
            Integer value2 = m2.get(k);
            if(value2==null) {
                System.out.println("k = " + k);
                continue;
            }

            if(value1>=value2)
                common += value2;
            else
                common += value1;
        }
        union -= common;
        System.out.printf("%d %d\n", common, union);

        return (int) ((union == 0 ? 1 : (double) common / union) * 65536);
    }

    String toLower(char a, char b) {
        int n = 'a' - 'A';
        if(a>='A'&&a<='Z') a += n;
        if(b>='A'&&b<='Z') b += n;

        StringBuilder sb = new StringBuilder();
        sb.append(a);
        sb.append(b);

        return sb.toString();
    }

    boolean isAlpha(char a) {
        if(a>='a'&&a<='z') return true;
        return a >= 'A' && a <= 'Z';
    }
}
