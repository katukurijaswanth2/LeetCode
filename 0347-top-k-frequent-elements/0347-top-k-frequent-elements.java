import java.util.*;

class Solution {
    public int[] topKFrequent(int[] nums, int k) {

Map<Integer, Integer> map = new HashMap<>();
for( int n : nums){
    map.put( n, map.getOrDefault(n,0)+1);

}
List <Integer> li = new ArrayList<>(map.keySet());
li.sort((a,b)-> map.get(b)-map.get(a));
int [] result = new int[k];
for(int i =0; i<k; i++){
    result[i]=li.get(i);
}
return result; 
    }
}