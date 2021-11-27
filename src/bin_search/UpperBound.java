package bin_search;

import java.util.ArrayList;

public class UpperBound {
    ArrayList<Integer> lis = new ArrayList<>();

    int upperBound(int value) {
        int left = 0;
        int right = lis.size() - 1;

        return binSearch(left, right, value);
    }

    int binSearch(int left, int right, int value) {
        while (left < right) {
            int mid = (left + right) / 2;

            if(lis.get(mid) <= value)
                left = mid + 1;
            else
                right = mid;
        }

        return left;
    }
}
