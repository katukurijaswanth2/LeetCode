class Solution {
    public int absDifference(int[] nums, int k) {
        int MaxSum = 0;
        int MinSum =0;
        Arrays.sort(nums);
        int count =k;
        for(int i=0; i<count; i++){
            MinSum=MinSum+nums[i];
            
        }
        count =0 ;
        for(int i=nums.length-1; count<k; i--){
            MaxSum=MaxSum+nums[i];
            count++;
           

        }
        return Math.abs(MaxSum - MinSum);
    }
}