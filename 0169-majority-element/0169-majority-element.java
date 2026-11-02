import java.util.Arrays;
// So what I’m doing is, I take an array like 2,2,1,1,1,2,2 and first I sort it. Then I put i at the first element and j at the next element. Now I check if both are equal. If they are, I keep moving j forward until I find a different element, and while doing that I keep increasing the count.

// If this count becomes more than n/2 (where n is the length of the array), then I just return arr[i]. If not, I move i to the position of j, where I found a different value. Then again I move j forward until I find another different element, increasing the count along the way. And if the count becomes more than n/2, I return arr[i]
class Solution {
    public int majorityElement(int[] nums) {
        Arrays.sort(nums);
        
        int i = 0;
        int n = nums.length;
        
        while (i < n) {
            int count = 1;
            int j = i + 1;
            
            while (j < n && nums[j] == nums[i]) {
                count++;
                j++;
            }
            
            if (count > n / 2) {
                return nums[i];
            }
            
            i = j;
        }
        
        return -1; // fallback (though problem guarantees answer)
    }
}
