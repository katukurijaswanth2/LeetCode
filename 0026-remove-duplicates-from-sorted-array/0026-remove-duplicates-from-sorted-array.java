class Solution {
    public static int removeDuplicates(int[] nums) {
        int reg=0;
        for(int i=0;i<=nums.length-1;i++){
            if(nums[reg]!=nums[i]){
                nums[++reg]=nums[i];
            } }
            return reg+1;
        }
        public static void main(String[] args){
        int[] arr={0,0,1,1,1,2,2,3,3,4};
        int rr=removeDuplicates(arr);
        for(int i=0; i<=rr;i++){
            System.out.println(arr[i]);
        }
    } }
