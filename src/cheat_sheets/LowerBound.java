package cheat_sheets;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Lower Bound.
 * C++의 Vector 의 lower_bound 와 유사한 기능
 */
public class LowerBound {
    ArrayList<Integer> lis = new ArrayList<>();

    int lowerBound(int value) {
        int index = Collections.binarySearch(lis, value);
        if(index>=0) return index;
        else return -index - 1;
    }
}
