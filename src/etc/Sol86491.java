package etc;

import java.util.*;

public class Sol86491 {
    public int solution(int[][] sizes) {
        int ans = 0, len = sizes.length;
        int x = 0, y = 0;
        for (int i = 0; i < len; i++) {
            if(sizes[i][0]<sizes[i][1]){
                int tmp = sizes[i][0];
                sizes[i][0] = sizes[i][1];
                sizes[i][1] = tmp;
            }
            if(x<sizes[i][0]) x = sizes[i][0];
            if(y<sizes[i][1]) y = sizes[i][1];
        }

        return x * y;
    }
}
