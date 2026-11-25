
class Solution {
    public int splitArray(int[] nums, int k) {
        int ans = 0;
        int start = 0;
        int end = 0;

        for (int n : nums) {
            start = Math.max(start, n);
            end += n;
        }

        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (isValid(nums, mid, k)) {
                ans = mid;
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }

        return ans;
    }

    public boolean isValid(int[] nums, int val, int k) {
        int students = 1;
        int pages = 0;

        for (int i = 0; i < nums.length; i++) {
            if (pages + nums[i] <= val) {
                pages += nums[i];
            } else {
                students++;
                pages = nums[i];
            }
        }

        return students <= k;
    }
}
