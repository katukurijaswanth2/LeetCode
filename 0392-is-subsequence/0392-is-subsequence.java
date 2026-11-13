class Solution {
    public boolean isSubsequence(String s, String t) {
        int i = 0;
        int j = 0;
        int ln = s.length();

        while (i < s.length() && j < t.length()) {
            if (s.charAt(i) == t.charAt(j)) {
                i++;
                ln--;
            }
            j++; // ✅ always move j
        }

        return ln == 0;
    }
}