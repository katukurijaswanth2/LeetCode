class Solution {
    // public void realR(int[] nums) {
    //     int temp = nums[0];
    //     for (int i = 1; i < nums.length; i++) {
    //         nums[i - 1] = nums[i];
    //     }
    //     nums[nums.length - 1] = temp;
    // }
    // public void rotate(int[] nums, int k) {
    //     k = k % nums.length;
    //         k=nums.length-k;
    //     for(int i=1; i<=k;i++){
    //         realR(nums);
    //     }
    // }
 public void rotate(int[] nums, int k){
  
    int ln= nums.length;
      k=k%ln;
    int[] temp= new int[ln];
    for(int i=0; i<ln;i++){
        temp[(i+k)%ln]= nums[i];
    }
    for(int i=0;i<ln;i++){
        nums[i]=temp[i];
    }
 }

}