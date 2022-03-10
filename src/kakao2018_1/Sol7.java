package kakao2018_1;

public class Sol7 {
    public int solution(String[] lines) {
        int answer = 0;
        int len = lines.length;
        Node[] nodes = new Node[len];

        for (int i = 0; i < len; i++) {
            String[] tmp = lines[i].split(" ");
            String[] date = tmp[1].split(":");
            String duration = tmp[2].replace('s','\0');
            int h = 60 * 60 * 1000 * Integer.parseInt(date[0]);
            int m = 60 * 1000 * Integer.parseInt(date[1]);
            double e = Double.parseDouble(date[2]);
            double d = Double.parseDouble(duration);
            int end = (int) (h + m + 1000 * e);
            int start = (int) (1 + end - 1000 * d);
            System.out.printf("%d %d\n", start, end);

            nodes[i] = new Node(start, end);
        }

        for (int i = 0; i < len; i++) {
            int count = 1;
            for (int j = i+1; j < len; j++) {
                if(nodes[i].end+1000>nodes[j].start)
                    count++;
            }

            answer = Integer.max(answer, count);
        }

        return answer;
    }

    static class Node{
        int start;
        int end;

        public Node(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }
}
