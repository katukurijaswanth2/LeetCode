class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> Pascal = new ArrayList<>();
        List<Integer> tem = new ArrayList<>();
        tem.add(1);
        Pascal.add(tem);
        for(int i=1 ; i< numRows; i++){
            List<Integer> ans = new ArrayList<>();
            ans.add(1);
        for(int j=1; j<i; j++){

           int value= Pascal.get(i-1).get(j-1)+ Pascal.get(i-1).get(j);
           ans.add(value);
                }
            ans.add(1);
            Pascal.add(ans);
        }
        return Pascal;
        
    }
}