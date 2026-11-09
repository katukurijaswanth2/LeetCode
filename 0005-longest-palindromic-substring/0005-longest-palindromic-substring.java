// import java.util.*;

// class Solution {
//     public String longestPalindrome(String s) {

//         List<String> list = new ArrayList<>();

//         // Generate all continuous substrings
//         for (int i = 0; i < s.length(); i++) {

//             for (int j = i + 1; j <= s.length(); j++) {

//                 String current = s.substring(i, j);

//                 list.add(current);
//             }
//         }

//         // Sort based on string length (descending order)
//         list.sort((a, b) -> b.length() - a.length());

//         // Find the first palindrome
//         for (String cur : list) {

//             if (isPalindrome(cur)) {
//                 return cur;
//             }
//         }

//         return "";
//     }

//     public boolean isPalindrome(String cur) {

//         int left = 0;
//         int right = cur.length() - 1;

//         while (left < right) {

//             if (cur.charAt(left) != cur.charAt(right)) {
//                 return false;
//             }

//             left++;
//             right--;
//         }

//         return true;
//     }
// }
class Solution {
    public String longestPalindrome(String s) {

        int n = s.length();

        boolean[][] dp = new boolean[n][n];

        int start = 0;
        int maxLen = 1;

        // Every single character is a palindrome
        for (int i = 0; i < n; i++) {
            dp[i][i] = true;
        }

        // Check substrings of increasing length
        for (int len = 2; len <= n; len++) {

            for (int i = 0; i <= n - len; i++) {

                int j = i + len - 1;

                if (s.charAt(i) == s.charAt(j)) {

                    if (len == 2 || dp[i + 1][j - 1]) {

                        dp[i][j] = true;

                        if (len > maxLen) {
                            maxLen = len;
                            start = i;
                        }
                    }
                }
            }
        }

        return s.substring(start, start + maxLen);
    }
}