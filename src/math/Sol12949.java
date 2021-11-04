package math;

/**
 * Matrix operation
 */
public class Sol12949 {
    public int[][] solution(int[][] arr1, int[][] arr2) {
        int a = arr1.length, b = arr1[0].length, c = arr2[0].length;
        int[][] answer = new int[a][c];

        for (int i = 0; i < a; i++)
            for (int j = 0; j < c; j++)
                answer[i][j] = calculate(arr1[i], arr2, b, j);

        return answer;
    }

    private int calculate(int[] x, int[][] y, int b, int j) {
        int result = 0;
        for (int i = 0; i < b; i++)
            result += x[i] * y[i][j];

        return result;
    }
}
