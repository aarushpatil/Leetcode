class Solution {
    public int lengthOfLongestSubstring(String s) {
        int l = 0;
        int r = 0;
        int max = 0;
        HashSet<Character> visited = new HashSet<>();
        int size = 0;


        while(r < s.length())
        {
            if(visited.add(s.charAt(r))) //doesn't have duplicate
            {
                size++;
                r++;
                max = Math.max(max, size);

            }
            else //duplicate found.
            {
                visited.remove(s.charAt(l));
                size--;
                l++;
            }
        }
        return max;
    }
}