package kakao2022;

public class Sol6 {
    public int solution(int[][] board, int[][] skill) {
        int answer = 0, n = board.length, m = board[0].length;

        for (int[] i : skill) {
            int type = i[0];
            int r1 = i[1], c1 = i[2], r2 = i[3], c2 = i[4], degree = i[5];
            if(type==1) degree = -degree;
            for (int j = r1; j <= r2; j++) {
                for (int k = c1; k <= c2; k++)
                    board[j][k] += degree;
            }
        }


        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                System.out.print(board[i][j]+" ");
                if(board[i][j]>0) answer++;
            }
            System.out.println();
        }
        return answer;
    }
}
