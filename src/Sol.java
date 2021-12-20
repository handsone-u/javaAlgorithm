public class Sol {
    char[][] arr;

    boolean dfs(int x, int y, int cnt,int len) {
        if (x >= len)
            return true;

        if(arr[x][y]=='#')
            return dfs(x + 1, y, cnt, len);
        else if(arr[x][y]=='>'&&possible(x,y+1,len))
            return dfs(x, y + 1, cnt, len);
        else if(arr[x][y]=='<'&&possible(x,y-1,len))
            return dfs(x, y - 1, cnt, len);
        else if (cnt == 1) {
            return false;
        } else {
            return dfs((x + 1), y, cnt + 1, len);
        }
    }

    boolean possible(int x, int y, int len) {
        if(x<0||y<0||x>len||y>=len) return false;
        return true;
    }

    public int solution(String[] drum) {
        int answer = 0;

        arr = new char[drum.length][drum.length];

        for (int i = 0; i < drum.length; i++) {
            arr[i] = drum[i].toCharArray();
        }
        for (int i = 0; i < drum.length; i++) {
            if(dfs(0, i, 0, drum.length)) answer++;
        }

        return answer;
    }
}
