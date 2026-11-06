class Solution {
    public boolean isPalindrome(int x) {
        int num= x;
        int product =0;
        while(num>0){
            int digit= num%10;
            product=product*10+digit;
            num=num/10;
        }
        if( product==x) {return true;}
        return false;

    }
}