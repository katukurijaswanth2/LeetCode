

class Solution {
    public int singleNonDuplicate(int[] nums) {
        int start = 0;
        int end = nums.length - 1;
        int n = nums.length;

        if (n == 1) return nums[0];

        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (mid == 0 && nums[mid] != nums[mid + 1])
                return nums[mid];
                // up code for single element is in first position 

            if (mid == n - 1 && nums[mid] != nums[mid - 1])
                return nums[mid];
// up code  for single element is in last position
            if (nums[mid] != nums[mid - 1] &&
                nums[mid] != nums[mid + 1])
                return nums[mid];

            if (mid % 2 == 0) {
                if (nums[mid] == nums[mid - 1]) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            } else {
                if (nums[mid] == nums[mid - 1]) {
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }
            }
        }

        return -1;
    }
}
