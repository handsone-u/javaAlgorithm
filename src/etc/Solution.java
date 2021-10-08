package etc;

public class Solution {
    public long solution(int price, int money, int count) {
        long answer = -1, multi = (count * (count + 1)) / 2;

        return ((answer= (multi * price) - money) > 0) ? answer : 0;
    }
}
