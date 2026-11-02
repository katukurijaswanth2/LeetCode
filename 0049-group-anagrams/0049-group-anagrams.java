import java.util.*;

class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {

      Map<String , List<String>> map = new HashMap<>();
      for(String s: strs){
        char[] str = s.toCharArray();
        Arrays.sort(str);
        String key = new String (str);
        if(!map.containsKey(key)){
            map.put(key, new ArrayList<>());

        }
        map.get(key).add(s);
        
      }
      return new ArrayList<>(map.values());}
          


}