
import java.util.Arrays;

class Solution {
    public String largestNumber(int[] nums) {

        String[] list = new String[nums.length];

        // Convert integers into strings
        for (int i = 0; i < nums.length; i++) {
            list[i] = String.valueOf(nums[i]);
        }

        // Custom sorting in descending order
        Arrays.sort(list, (a, b) -> 
            (b + a).compareTo(a + b)
        );

        // Handle the case [0, 0]
        if (list[0].equals("0")) {
            return "0";
        }

        StringBuilder s = new StringBuilder();

        for (int i = 0; i < list.length; i++) {
            s.append(list[i]);
        }

        return s.toString();
    }
}
