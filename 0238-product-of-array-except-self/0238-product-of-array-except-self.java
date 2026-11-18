class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] ans = new int[nums.length];
       for(int i =0; i<nums.length; i++){
        ans[i]=1;
       }
        int prefix =1;
        int sufix=1;
        for (int i = 1; i < nums.length; i++) {
            ans[i]=ans[i-1]*nums[i-1];
            prefix= ans[i];

        }
        for(int i= nums.length-2; i>=0; i--){
            sufix= sufix*nums[i+1];
           ans[i]=sufix*ans[i];
        }
return ans; 
    }
}