package etc;

import java.util.*;

public class MoveRotateBlock {
    private static int bSize;
    private static final int[] dx = {0, 1, 0, -1};
    private static final int[] dy = {1, 0, -1, 0};
    private static final int[] rdx = {-1, 1, 1, -1};
    private static final int[] rdy = {1, 1, -1, -1};
    private final Set<Point> v = new HashSet<>();
    private final Queue<Node> q = new LinkedList<>();

    public int solution(int[][] board) {
        int answer = 0;
        bSize = board.length;

        Point head = new Point(0, 0, 0);
        v.add(head);
        q.add(new Node(head, 0));

        while (!q.isEmpty()) {
            Node cNode = q.poll();
            Point cPoint = cNode.getPoint();

            int cCount = cNode.getCount();
            int counterDirection = (cPoint.direction + 2) % 4;
            Point counterPoint = new Point(cPoint.hx, cPoint.hy, counterDirection);

            if (cPoint.isOver()) {
                answer = cCount;
                break;
            }

            // MOVE
            for (int i = 0; i < 4; i++) {
                Point nPoint = cPoint.move(i);
                if(v.contains(nPoint)||!nPoint.isValid(board))
                    continue;

                v.add(nPoint);
                q.add(new Node(nPoint, cCount + 1));
            }

            // ROTATE(raw)
            for (int i = 1; i <= 3; i+=2) {
                int nDirection = (i + cPoint.direction) % 4;
                int diagonal = (i == 1) ? nDirection : cPoint.direction;

                Point nPoint = cPoint.rotate(nDirection);
                if(v.contains(nPoint)|| !nPoint.isValid(board))
                    continue;
                if(!nPoint.diagonalOk(board,diagonal))
                    continue;
                v.add(nPoint);
                q.add(new Node(nPoint, cCount + 1));
            }

            // ROTATE(counter)
            for (int i = 1; i <= 3; i+=2) {
                int nDirection = (i + counterPoint.direction) % 4;
                int diagonal = (i == 1) ? nDirection : counterPoint.direction;

                Point nPoint = counterPoint.rotate(nDirection);
                if(v.contains(nPoint)|| !nPoint.isValid(board))
                    continue;
                if(!nPoint.diagonalOk(board,diagonal))
                    continue;
                v.add(nPoint);
                q.add(new Node(nPoint, cCount + 1));
            }
        }

        return answer;
    }

    static class Point{
        private final int x;
        private final int y;
        private final int hx;
        private final int hy;
        private final int direction;

        public Point rotate(int newDirection) {
            return new Point(x, y, newDirection);
        }

        public Point move(int d) {
            return new Point(this.x + dx[d], this.y + dy[d], this.direction);
        }

        public boolean isOver() {
            return (x == bSize - 1 && y == bSize - 1) ||
                    (hx == bSize - 1 && hy == bSize - 1);
        }

        public boolean diagonalOk(int[][] board, int diagonal) {
            System.out.println((x + rdx[diagonal]) + " " + (y + rdy[diagonal]));
            return inbound(x + rdx[diagonal], y + rdy[diagonal]) &&
                    (board[x + rdx[diagonal]][y + rdy[diagonal]] == 0);
        }

        public boolean isValid(int[][] board) {
            return inbound() && isOk(board);
        }

        public boolean isOk(int[][] board) {
            return board[x][y] == 0 && board[hx][hy] == 0;
        }

        public boolean inbound() {
            return inbound(x, y) && inbound(hx, hy);
        }

        private boolean inbound(int x, int y) {
            return x >= 0 && y >= 0 && x < bSize && y < bSize;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Point point = (Point) o;
            return x == point.x && y == point.y && direction == point.direction;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y, direction);
        }

        @Override
        public String toString() {
            return "Point{" +
                    "x=" + x +
                    ", y=" + y +
                    ", hx=" + hx +
                    ", hy=" + hy +
                    ", direction=" + direction +
                    '}';
        }

        public Point(int x, int y, int direction) {
            this.x = x;
            this.y = y;
            this.direction = direction;
            this.hx = x + dx[direction];
            this.hy = y + dy[direction];
        }
        public int getX() {
            return x;
        }
        public int getY() {
            return y;
        }
        public int getDirection() {
            return direction;
        }
    }

    static class Node{
        private final Point point;
        private final int count;

        public Node(Point point, int count) {
            this.point = point;
            this.count = count;
        }

        public Point getPoint() {
            return point;
        }

        public int getCount() {
            return count;
        }
    }
}
