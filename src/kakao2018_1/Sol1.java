package kakao2018_1;

public class Sol1 {
    private String bitWise(int n1, int n2, int n) {
        int result = n1 | n2;
        String str = String.format("%16s", Integer.toBinaryString(result));
        str = str.substring(16 - n);
        str = str.replaceAll("1", "#");
        str = str.replaceAll("0", " ");

        return str;
    }

    public String[] solution(int n, int[] arr1, int[] arr2) {
        String[] answer = new String[n];

        for (int i = 0; i < n; i++) {
            answer[i] = bitWise(arr1[i], arr2[i], n);
        }

        return answer;
    }
}
