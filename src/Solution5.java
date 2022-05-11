class Solution5 {
    public int[][] solution(int[][] rc, String[] operations) {
        int[][] answer = rc;
        brute(answer, operations);
        
        return answer;
    }

    void brute(int[][] result,String[] ops) {
        int n = result.length;
        int m = result[0].length;
        for (String op : ops) {
            if (op.equals("Rotate")) {
                int c1 = result[0][m - 1];
                int c2 = result[n - 1][m - 1];
                int c3 = result[n - 1][0];
                int c4 = result[0][0];

                for (int i = m - 1; i >= 1; i--) result[0][i] = result[0][i - 1];
                for (int i = n - 1; i >= 2; i--) result[i][m - 1] = result[i - 1][m - 1];
                result[1][m - 1] = c1;
                for (int i = 0; i <= m - 2; i++) result[n - 1][i] = result[n - 1][i + 1];
                result[n - 1][m - 2] = c2;
                for (int i = 0; i <= n - 2; i++) result[i][0] = result[i + 1][0];
                result[1][0] = c3;

            } else {
                int[] temp = result[n - 1];
                for (int i = n - 1; i > 0; i--) result[i] = result[i - 1];
                result[0] = temp;
            }
        }

    }
}