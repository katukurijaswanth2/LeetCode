import java.util.Arrays;

class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {

        int n = nums1.length;
        int m = nums2.length;

        int[] merged = new int[n + m];

        // Copy nums1
        for (int i = 0; i < n; i++) {
            merged[i] = nums1[i];
        }

        // Copy nums2
        for (int i = 0; i < m; i++) {
            merged[n + i] = nums2[i];
        }

        Arrays.sort(merged);

        int len = merged.length;

        // Odd length
        if (len % 2 != 0) {
            return merged[len / 2];
        }

        // Even length
        int mid1 = merged[len / 2 - 1];
        int mid2 = merged[len / 2];

        return (mid1 + mid2) / 2.0;
    }
}