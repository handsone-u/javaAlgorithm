package kakao2018_1;

import java.util.Arrays;

public class Sol6 {
    char[][] arr;
    boolean[][] v;
    int[] dx = {0, 1, 0, -1};
    int[] dy = {1, 0, -1, 0};

    public int solution(int m, int n, String[] board) {
        int answer = 0;
        arr = new char[m][];
        v = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            arr[i] = board[i].toCharArray();
        }

        while (isDone(m, n)) {
            for (int i = 0; i < m; i++) {
                Arrays.fill(v[i], false);
            }

            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if(arr[i][j]=='0') continue;
                    if(!isOk(i,j,m,n,arr[i][j])) continue;
                    v[i][j] = v[i + 1][j] = v[i][j + 1] = v[i + 1][j + 1] = true;
                }
            }
            answer += dropItems(m, n);
            replace(m, n);
        }

        return answer;
    }

    void print(int m) {
        for (int i = 0; i < m; i++) {
            System.out.println(String.valueOf(arr[i]));
        }
    }

    private boolean isDone(int m, int n) {
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if(arr[i][j]=='0') continue;
                if(isOk(i,j,m,n,arr[i][j])) return true;
            }
        }
        return false;
    }

    private void replace(int m, int n) {
        for (int i = m - 1; i > 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                if(arr[i][j]!='0') continue;
                for (int k = i - 1; k >= 0; k--) {
                    if(arr[k][j]=='0') continue;
                    arr[i][j] = arr[k][j];
                    arr[k][j] = '0';
                    break;
                }
            }
        }
    }

    private int dropItems(int m, int n) {
        int result = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if(!v[i][j]) continue;
                result++;
                arr[i][j] = '0';
            }
        }
        return result;
    }

    private boolean isOut(int x, int y,int m,int n) {
        return x < 0 || x >= m || y < 0 || y >= n;
    }

    private boolean isOk(int x, int y,int m,int n,char f) {
        if(isOut(x+1,y+1,m,n)) return false;
        return f == arr[x][y + 1]
                && f == arr[x + 1][y]
                && f == arr[x + 1][y + 1];
    }
}
