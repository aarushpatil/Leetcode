class Solution {
    public boolean isSubsequence(String s, String t) {
        if(s.length() == 0)
        {
            return true;
        }

        int p = 0;

        for(int i = 0; i < t.length(); i++)
        {
            if(s.charAt(p) == t.charAt(i))
            {
                if(p == s.length() - 1)
                {
                    return true;
                }
                p++;
                // System.out.println(p +", " + i);
            }
        }
        
        return false;
    }
}