
class Solution {
    public int myAtoi(String s) {

        // Remove whitespace from front and end
        s = s.trim();

        if (s.isEmpty()) {
            return 0;
        }

        // Convert string into character array
        char[] arr = s.toCharArray();

        // StringBuilder to store digits
        StringBuilder result = new StringBuilder();

        int sign = 1;
        int i = 0;

        // Check for positive or negative sign
        if (arr[0] == '-') {
            sign = -1;
            i = 1;
        } else if (arr[0] == '+') {
            i = 1;
        }

        // Add consecutive digits to StringBuilder
        for (; i < arr.length; i++) {

            if (Character.isDigit(arr[i])) {
                result.append(arr[i]);
            } else {
                break;
            }
        }

        // If no digits are found
        if (result.length() == 0) {
            return 0;
        }

        // Convert StringBuilder into integer manually
        long num = 0;

        for (int j = 0; j < result.length(); j++) {

            int digit = result.charAt(j) - '0';

            num = num * 10 + digit;

            // Check integer limits
            if (sign == 1 && num > Integer.MAX_VALUE) {
                return Integer.MAX_VALUE;
            }

            if (sign == -1 && num > Integer.MAX_VALUE) {
                return Integer.MIN_VALUE;
            }
        }

        return (int)(num * sign);
    }
}
