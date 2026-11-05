class Solution {
    public List<String> fizzBuzz(int n) {
        List<String> li = new ArrayList<>();
        for(int i =1; i<=n; i++){
if(i%3==0 && i%5==0){
    li.add("FizzBuzz");
}
 else if (i%3==0){
   li.add("Fizz");

}
 else if(i%5==0){
 li.add("Buzz");
}
else{
    String s = ""+i;
    li.add(s);
    // String s = String.valueOf(i);          // preferred
// or
// String s = Integer.toString(i);
// or
// String s = "" + i;
// or
// String s = new StringBuilder().append(i).toString();
}

        }
        
        return li;
    }
}