package combination;

/**
 * Permutation
 * https://programmers.co.kr/learn/courses/30/lessons/1835
 */
public class Sol1835 {
    char[] arr = {'A', 'C', 'F', 'J', 'M', 'N', 'R', 'T'};
    char[] result;
    boolean[] v;
    int num;
    String[] d;
    int answer;

    public int solution(int n, String[] data) {
        v = new boolean[8];
        result = new char[8];
        answer = 0;

        num = n;
        d = data;

        permutation(0);

        return answer;
    }

    private boolean isOk() {
        // 각각의 조건 검증
        for (int i = 0; i < num; i++) {
            char[] condition = d[i].toCharArray();
            char x = condition[0];
            char y = condition[2];
            char op = condition[3];
            int gap = Character.getNumericValue(condition[4]);

            // 각자 위치 조회
            int indexX = 0, indexY = 0;
            for (int j = 0; j < 8; j++) {
                if(result[j]==x) indexX = j;
                if(result[j]==y) indexY = j;
            }
            int realGap = Math.abs(indexX - indexY) - 1;

            // op
            if (op == '=') {
                if(realGap!=0) return false;
            } else if (op == '>') {
                if(realGap<=gap) return false;
            } else{
                if(realGap>=gap) return false;
            }
        }
        return true;
    }

    private void permutation(int cnt) {
        if (cnt >= 8) {
            if(isOk()) answer++;
            return;
        }
        for (int i = 0; i < 8; i++) {
            // 이미 골라진 것
            if(v[i]) continue;
            v[i] = true;
            result[cnt] = arr[i];
            permutation(cnt + 1);
            v[i] = false;
        }
    }
}
