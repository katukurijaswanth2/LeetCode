
import java.util.*;

class Solution {
    public String frequencySort(String s) {

        Map<Character, Integer> map = new HashMap<>();
        StringBuilder sb = new StringBuilder();

        // Step 1: Count character frequencies
        for (int i = 0; i < s.length(); i++) {
            map.put(s.charAt(i),
                    map.getOrDefault(s.charAt(i), 0) + 1);
        }

        // Step 2: Store characters in a list
        List<Character> list = new ArrayList<>(map.keySet());

        // Step 3: Sort by descending frequency
        list.sort((a, b) -> map.get(b) - map.get(a));

        // Step 4: Append each character based on frequency
        for (char ch : list) {
            int freq = map.get(ch);

            for (int i = 0; i < freq; i++) {
                sb.append(ch);
            }
        }

        // Step 5: Return result
        return sb.toString();
    }
}
