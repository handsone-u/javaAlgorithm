package dfs;

public class Solution43165 {
    static int cnt = 0;

    void dfs(int[] arr, int pos, int value, int target) {
        if (pos >= arr.length) {
            if(value == target) cnt++;
            return;
        }
        int next = pos + 1;
        dfs(arr, next, value + arr[pos], target);
        dfs(arr, next, value - arr[pos], target);
    }

    public int solution(int[] numbers, int target) {
        dfs(numbers, 0, 0,target);
        return cnt;
    }
}
