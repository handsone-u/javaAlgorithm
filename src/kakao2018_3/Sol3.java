package kakao2018_3;

import java.util.Arrays;

public class Sol3 {
    public String[] solution(String[] files) {
        File[] f = new File[files.length];
        int len = files.length;

        for (int i = 0; i < len; i++) f[i] = File.parseFile(files[i], i);

        return Arrays.stream(f)
                .sorted()
                .map(o -> files[o.index])
                .toArray(String[]::new);
    }

    static class File implements Comparable<File>{
        int index;
        String head;
        int num;

        public static File parseFile(String str, int index) {
            char[] arr = str.toCharArray();
            int start = 0, end = 0;
            for (int i = 0; i < arr.length; i++) {
                if (arr[i] >= '0' && arr[i] <= '9') {
                    start = i;
                    end = i + 1;
                    while (end < arr.length) {
                        if(arr[end]>='0'&&arr[end]<='9') end++;
                        else break;
                    }
                    break;
                }
            }
            String head = str.substring(0, start).toLowerCase();
            String num = str.substring(start, end);

            return new File(index, head, Integer.parseInt(num));
        }

        public File(int index, String head, int num) {
            this.index = index;
            this.head = head;
            this.num = num;
        }

        public int compareTo(File o) {
            int c1 = this.head.compareTo(o.head);
            if (c1 == 0) {
                int c2 = this.num - o.num;
                if (c2 == 0) {
                    return this.index - o.index;
                } else
                    return c2;
            } else
                return c1;
        }
    }
}
