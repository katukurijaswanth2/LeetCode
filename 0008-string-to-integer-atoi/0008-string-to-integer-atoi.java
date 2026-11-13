
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
            i++;
        } else if (arr[0] == '+') {
            i++;
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
        // Java automatically converts char values into their integer Unicode values when you perform arithmetic operations on them.
        // Character	Numeric value
        // '0'	            48
        // '1'          	49
        // '2'	            50
        // '5'	            53
        // '9'	            57

        // chars unicode of numbers starts at 48 so we resmoved that 48 here. 

        // 1 char -> 48+1 => 1 [char value is 49] so if we remove that 48 from the 49 we will get 1 here. 
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

        return (int) (num * sign);
    }
}
