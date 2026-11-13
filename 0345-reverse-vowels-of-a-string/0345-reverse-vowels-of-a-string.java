class Solution {
    public String reverseVowels(String s) {
    
        Set<Character> vowels = new HashSet<>(Arrays.asList('a','e','i','o','u','A','E','I','O','U'));
        int left=0;
        int right=s.length()-1;
        char[] arr=s.toCharArray();

   while(left<right){
    while((left<right)&& !vowels.contains(arr[left])){
        left++;
    }
    while((left<right)&& !vowels.contains(arr[right])){
        right--;
    }
    char temp= arr[left];
    arr[left]=arr[right];
    arr[right]=temp;
    left++;
    right--;

   }
return new String(arr);
    }
}