class Solution {
    public int numRescueBoats(int[] people, int limit) {
        int count=0;
        Arrays.sort(people);
       int left= 0;
       int right = people.length-1;
   
       while(left<=right){
            int check = people[left]+people[right];
        if(check<=limit){
            left++;

        }
        right--;
        count++;
       }
        return count;
    }
}

