class Solution {
    public String reverseVowels(String s) {

        char[] a = s.toCharArray();   // convert string to char array
        int i = 0;
        int j = a.length - 1;

        while (i < j) {

            // move i forward until vowel
            while (i < j && !isVowel(a[i])) {
                i++;
            }

            // move j backward until vowel
            while (i < j && !isVowel(a[j])) {
                j--;
            }

            // swap vowels
            char temp = a[i];
            a[i] = a[j];
            a[j] = temp;

            i++;
            j--;
        }

        return new String(a);   // convert back to string
    }

    // helper function
    private boolean isVowel(char c) {
        return c=='a'||c=='e'||c=='i'||c=='o'||c=='u'||
               c=='A'||c=='E'||c=='I'||c=='O'||c=='U';
    }
}