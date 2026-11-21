import java.util.*;

public class Solution {
    public int totalFruit(int[] fruits) {
        Set<Integer> set = new HashSet<>();
        LinkedList<Integer> window = new LinkedList<>();
        int max = 0;

        for (int fruit : fruits) {
            window.add(fruit);
            set.add(fruit);

            // If more than 2 types, shrink from left
            while (set.size() > 2) {
                int removed = window.removeFirst();

                // If removed element no longer exists in window, remove from set
                if (!window.contains(removed)) {
                    set.remove(removed);
                }
            }

            max = Math.max(max, window.size());
        }

        return max;
    }
}