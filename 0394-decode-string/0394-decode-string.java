class Solution {
    public String decodeString(String s) {
        String ret = method(s, 1);
        // System.gc();
        return ret;
    }
    
    int i = 0;
    String method(String s, int mult)
    {
        StringBuilder gigaSB = new StringBuilder();
        while(i < s.length())
        {
            
            char curr = s.charAt(i);
            int currAscii = curr;
            // System.out.println(i);
            if((((int)s.charAt(i)) >= 48 && ((int)s.charAt(i)) <= 57)) //its a number
            {
                //loop forward till the end of the number
                StringBuilder sb = new StringBuilder();
                while(i < s.length() && s.charAt(i) != '[')
                {
                    sb.append(s.charAt(i));
                    i++;
                }
                i++; //move i past '['
                int theMult = Integer.parseInt(sb.toString());
                // System.out.println("recurse!");
                
                gigaSB.append(method(s, theMult));
            }

            else if(']' == curr)
            {
                // System.out.println(mult);
                StringBuilder sb = new StringBuilder();
                for(int k = 0; k < mult; k++)
                {
                    sb.append(gigaSB.toString());
                }
                // System.out.println(resolvedString);
                return sb.toString();
            }

            else
            {
                gigaSB.append(curr);
            }
            i++;
        }
        return gigaSB.toString();
    }
}