package etc;

public class Sol67256 {
    int[][] ui = {
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9},
            {100, 0, 100}
    }; // 4*3

    public String solution(int[] numbers, String hand) {
        StringBuilder tmp = new StringBuilder();
        int len = numbers.length;

        Pair left = new Pair(3, 0);
        Pair right = new Pair(3, 2);

        for (int i = 0; i < len; i++) {
            int number = numbers[i];
            Pair target = getPoint(number);
            if (number == 1 || number == 4 || number == 7) {
                tmp.append("L");
                left.setPosition(target);
            }
            else if(number==3||number==6||number==9) {
                tmp.append("R");
                right.setPosition(target);
            }
            else{
                int leftDistance = getDistance(left, number);
                int rightDistance = getDistance(right, number);
                if (leftDistance == rightDistance) {
                    if (hand.equals("left")) {
                        tmp.append("L");
                        left.setPosition(target);
                    } else {
                        tmp.append("R");
                        right.setPosition(target);
                    }
                } else if (leftDistance < rightDistance) {
                    tmp.append("L");
                    left.setPosition(target);
                } else {
                    tmp.append("R");
                    right.setPosition(target);
                }
            }
        }

        return tmp.toString();
    }

    private Pair getPoint(int to) {
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 3; j++)
                if (ui[i][j] == to) return new Pair(i, j);
        }
        return null;
    }

    private int getDistance(Pair now, int to){
        Pair target = getPoint(to);
        int result = Math.abs(now.x - target.x) + Math.abs(now.y - target.y);
        return result;
    }

    static class Pair{
        public int x;
        public int y;

        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public void setPosition(Pair t) {
            this.x = t.x;
            this.y = t.y;
        }
    }
}
