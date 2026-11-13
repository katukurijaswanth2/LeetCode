class Solution {
    public int trailingZeroes(int n) {
//         int count = 0;
//         int fact=1;
// while(n!=0){
// fact= n*fact;
// n--;
    
// }
// String result = Integer.toString(fact);
// for(int i= result.length()-1; i>=0; i--){
//     if(result.charAt(i)=='0'){
//         count++;


//     }
//     else{
//         break;
//     }
// } return count;
       

       int powOf5=5;
       int result=0;
       while(n>=powOf5){
        result=result+(n/powOf5);
        powOf5=powOf5*5;
       }
       return result;
    }
}