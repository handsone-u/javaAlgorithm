package etc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.Stream;

public class Sol87377 {
    public String[] solution(int[][] line) {
        String[] answer = {};
        int len = line.length;
        ArrayList<Point> points = new ArrayList<>();
        long minX, minY, maxX, maxY;

        for (int i = 0; i < len-1; i++) {
            int[] now = line[i];
            for (int j = i + 1; j < len; j++) {
                int[] next = line[j];
                if(getParallel(now, next)==0) continue;
                double x = getX(now, next);
                double y = getY(now, next);
                if((long)x == x&&(long)y == y)
                    points.add(new Point((long)x, (long)y));
            }
        }
        Point[] pX = points.stream().sorted(Comparator.comparing(Point::getX)).toArray(Point[]::new);
        Point[] pY = points.stream().sorted(Comparator.comparing(Point::getY).thenComparing(Point::getX)).toArray(Point[]::new);
        minX = pX[0].x;
        maxX = pX[points.size() - 1].x;
        minY = pY[0].y;
        maxY = pY[points.size() - 1].y;
        pY = points.stream().distinct().toArray(Point[]::new);

        long rowLen = maxY - minY + 1;
        long colLen = maxX - minX + 1;
        answer = new String[(int) rowLen];
        String[] ans = new String[(int) rowLen];

        for (int i = 0; i < rowLen; i++) {
            StringBuilder str = new StringBuilder();
            for (int j = 0; j < colLen; j++) str.append(".");
            answer[i] = str.toString();
        }

        for (Point point : pY) {
            int i = (int) (point.y - minY);
            int j = (int) (point.x - minX);
            char[] chars = answer[i].toCharArray();
            chars[j] = '*';
            answer[i] = String.valueOf(chars);
        }

        for (int i = 0; i < rowLen; i++) ans[i] = answer[(int) (rowLen - 1 - i)];

        return ans;
    }

    public long getParallel(int[] now, int[] next) {
        return (long)now[0] * (long)next[1] - (long)now[1] * (long)next[0];
    }

    public double getX(int[] now, int[] next) {
        double tmpX = (double) ((long)now[1] * (long)next[2] - (long)now[2] * (long)next[1]) / getParallel(now, next);
        return tmpX;
    }

    public double getY(int[] now, int[] next) {
        double tmpY = (double) ((long)now[2] * (long)next[0] - (long)now[0] * (long)next[2]) / getParallel(now, next);
        return tmpY;
    }

    static class Point{
        public long x, y;

        public long getX() {
            return x;
        }

        public long getY() {
            return y;
        }

        public Point(long x, long y) {
            this.x = x;
            this.y = y;
        }
    }
}
