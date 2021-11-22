package wtc;

public class Sol5 {
    boolean[][] v;
    public int[][] solution(int rows, int columns) {
        int[][] answer = new int[rows][columns];
        v = new boolean[rows][columns];
        int todo = rows * columns;
        int prev = 1;
        Point now = new Point(1, 1);
        color(now, answer, 1);
        v[0][0] = true;
        todo--;

        while (todo > 0) {
            // 4
            if (prev % 2 == 0) {
                move4(now, rows, columns);
            } else { // 5
                move5(now, rows, columns);
            }

            if(answer[now.x-1][now.y-1]==0) {
                v[now.x - 1][now.y - 1] = true;
                todo--;
            } else if (v[now.x - 1][now.y - 1]) {
                if(answer[now.x-1][now.y-1]%2==(prev+1)%2)
                    break;
            }
            color(now, answer, ++prev);
        }

        return answer;
    }

    private void color(Point now,int[][] ans ,int val) {
        ans[now.x - 1][now.y - 1] = val;
    }

    private void move4(Point now, int r, int c) {
        now.x++;
        if(now.x>r) now.x = 1;
    }

    private void move5(Point now, int r, int c) {
        now.y++;
        if(now.y>c) now.y = 1;
    }

    static class Point{
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
