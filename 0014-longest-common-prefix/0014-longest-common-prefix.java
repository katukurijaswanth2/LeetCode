
class Solution {
    public String longestCommonPrefix(String[] strs) {

        StringBuilder sc = new StringBuilder();

        if (strs.length == 0) {
            return "";
        }

        Set<Character> li = new HashSet<>();

        for (int j = 0; j < strs[0].length(); j++) {

            for (int i = 0; i < strs.length; i++) {

                if (j >= strs[i].length()) {
                    return sc.toString();
                }

                li.add(strs[i].charAt(j));
            }

            if (li.size() == 1) {
                sc.append(strs[0].charAt(j));
            } else {
                break;
            }

            li.clear();
        }

        return sc.toString();
    }
}
