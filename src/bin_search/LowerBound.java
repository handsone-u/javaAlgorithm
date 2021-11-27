package bin_search;

import java.util.ArrayList;

/**
 * Lower Bound.
 * C++의 Vector 의 lower_bound 와 유사한 기능
 */
public class LowerBound {
    ArrayList<Integer> lis = new ArrayList<>();

    int lowerBound(int value) {
        int left = 0;
        int right = lis.size() - 1;

        return binSearch(left, right, value);
    }

    int binSearch(int left, int right, int value) {
        while (left < right) {
            int mid = (left + right) / 2;

            if (lis.get(mid) >= value)
                right = mid;
            else
                left = mid + 1;
        }

        return right;
    }
}
