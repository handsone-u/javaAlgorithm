package etc;

public class Sol84512 {
    boolean flag = false;
    char[] a = {'A', 'E', 'I', 'O', 'U'};
    int answer = 0;

    void dfs(String w, String t) {
        if(flag||w.length()>5) return;
        answer++;
        if(w.equals(t)) {
            flag = true;
            return;
        }
        for (int i = 0; i < 5; i++) dfs(w + a[i], t);
    }

    public int solution(String word) {
        for (int i = 0; i < 5; i++) dfs(String.valueOf(a[i]), word);
        return answer;
    }
}
