package etc;

public class Sol49993 {
    public int solution(String skill, String[] skill_trees) {
        int answer = 0;
        int skillLen = skill.length();

        for (String skill_tree : skill_trees) {
            if(isOk(skill, skill_tree)) {
                answer++;
            }
        }

        return answer;
    }

    private boolean isOk(String skill, String user) {
        char[] arr = skill.toCharArray();
        int length = arr.length;
        int[] turn = new int[length];
        int cnt = 0;
        boolean disconnected = false;

        for (int i = 0; i < length; i++) {
            int index = user.indexOf(arr[i]);
            if(disconnected&&index>=0) return false;
            turn[i] = index;
            if (index < 0)
                disconnected = true;
            else
                cnt++;
        }

        for (int i = 0; i+1 < cnt; i++) {
            if(turn[i]>turn[i+1]) return false;
        }

        return true;
    }
}
