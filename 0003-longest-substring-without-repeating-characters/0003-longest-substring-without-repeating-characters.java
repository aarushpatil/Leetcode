class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        int l = 0;
        int r = 0;
        int max = 0;

        while(r < s.length()) {
            if(!map.containsKey(s.charAt(r))) { //if map doesnt have char then add to map
                map.put(s.charAt(r), r);
                r++;
            }
            else { //map contains char
                l = map.get(s.charAt(r)) + 1;
                map.clear();
                r = l;
            }
            
            if(r-l > max){ //update max
                max = r-l;
            }
        }
        return max;
    }
}