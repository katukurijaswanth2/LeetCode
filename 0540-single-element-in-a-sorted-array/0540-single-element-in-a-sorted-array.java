
class Solution {
    public int singleNonDuplicate(int[] nums) {

        int start = 0;
        int end = nums.length - 1;
        int n = nums.length;

        // If there is only one element, it is obviously
        // the element that appears only once.
        if (n == 1) return nums[0];

        while (start <= end) {

            // Find the middle index of the current search space.
            int mid = start + (end - start) / 2;

            // ------------------------------------------------
            // STEP 1: CHECK WHETHER MID ITSELF IS THE ANSWER
            // ------------------------------------------------

            // If mid is at index 0, there is no left neighbour.
            // So we only need to check its right neighbour.
            if (mid == 0 && nums[mid] != nums[mid + 1])
                return nums[mid];

            // If mid is at the last index, there is no right neighbour.
            // So we only need to check its left neighbour.
            if (mid == n - 1 && nums[mid] != nums[mid - 1])
                return nums[mid];

            // If the middle element is different from both neighbours,
            // it means this element does not have a duplicate.
            // Hence, we found our single element.
            if (nums[mid] != nums[mid - 1] &&
                nums[mid] != nums[mid + 1]) {
                return nums[mid];
            }

            // ------------------------------------------------
            // STEP 2: UNDERSTAND HOW PAIRS ARE DIVIDED AROUND MID
            // ------------------------------------------------

            // Every element appears twice except one element.
            //
            // Before the single element:
            // Pairs occupy (even index, odd index).
            //
            // Example:
            // Index:  0  1  2  3  4  5
            // Value:  1  1  2  2  3  3
            //
            // After the single element:
            // Pairs shift and occupy (odd index, even index).
            //
            // This change in pairing is what helps us
            // identify which half contains the single element.

            // CASE 1: MID IS EVEN
            if (mid % 2 == 0) {

                // Suppose mid = 4.
                //
                // Normally, an even index should be the FIRST
                // occurrence of a pair.
                //
                // Example:
                // Index:  0  1  2  3  4  5
                // Value:  1  1  2  2  3  3
                //                         ^
                //                        mid
                //
                // But if nums[mid] == nums[mid-1],
                // it means the pair starts at the previous odd index.
                //
                // This indicates that the pairing pattern has shifted.
                // Therefore, the single element is somewhere on the LEFT.
                if (nums[mid] == nums[mid - 1]) {
                    end = mid - 1;
                }

                // If mid does NOT match its previous element,
                // the normal pairing pattern is still maintained
                // on the left side.
                //
                // Therefore, the single element must be on the RIGHT.
                else {
                    start = mid + 1;
                }
            }

            // CASE 2: MID IS ODD
            else {

                // Suppose mid = 3.
                //
                // Normally, an odd index should be the SECOND
                // occurrence of a pair.
                //
                // If nums[mid] == nums[mid-1],
                // the pair is in its expected position.
                //
                // This means the pairing pattern is correct up to mid.
                // Therefore, the single element is on the RIGHT.
                if (nums[mid] == nums[mid - 1]) {
                    start = mid + 1;
                }

                // If mid does NOT match its previous element,
                // the expected pairing pattern has been disturbed.
                //
                // Therefore, the single element is on the LEFT.
                else {
                    end = mid - 1;
                }
            }
        }

        // This statement is reached only if no answer is found.
        // For a valid input, the single element will always be found.
        return -1;
    }
}
