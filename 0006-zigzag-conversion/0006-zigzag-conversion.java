class Solution {
    public String convert(String s, int numRows) {

        if (numRows == 1 || numRows >= s.length()) {
            return s;
        }

        StringBuilder[] rows = new StringBuilder[numRows];

        for (int i = 0; i < numRows; i++) {
            rows[i] = new StringBuilder();
        }

        int i = 0;

        while (i < s.length()) {

            // Move from top to bottom
            for (int j = 0; j < numRows && i < s.length(); j++) {
                rows[j].append(s.charAt(i));
                i++;
            }

            // Move diagonally from bottom to top
            int mid = numRows - 2;

            while (mid > 0 && i < s.length()) {
                rows[mid].append(s.charAt(i));
                i++;
                mid--;
            }
        }

        // Combine all rows
        StringBuilder result = new StringBuilder();

        for (int j = 0; j < numRows; j++) {
            result.append(rows[j]);
        }

        return result.toString();
    }
}