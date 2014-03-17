package mySolutions;

/**
 * Created by Payson Wu on 16/03/14.
 *
 * Given a sorted array and a target value, return the index if the target is found. If not, return the index where it would be if it were inserted in order.

 You may assume no duplicates in the array.

 Here are few examples.
 [1,3,5,6], 5 → 2
 [1,3,5,6], 2 → 1
 [1,3,5,6], 7 → 4
 [1,3,5,6], 0 → 0
 */
public class SearchInsertPosition {
    public int searchInsert(int[] A, int target) {
        int head = 0, tail = A.length-1, mid;
        while (head <= tail) {
            mid = (head + tail)/2;
            if (target == A[mid]) {
                return mid;
            } else if (target < A[mid]) {
                tail = mid - 1;
            } else {
                head = mid + 1;
            }
        }
        return head;
    }
}
