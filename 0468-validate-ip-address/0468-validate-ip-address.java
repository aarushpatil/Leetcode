class Solution {
    public String validIPAddress(String queryIP) {

        if(isIPV4(queryIP))
        {
            return "IPv4";
        }

        if(isIPV6(queryIP))
        {
            return "IPv6";
        }
        return "Neither";
    }

    boolean isIPV4(String in)
    {
        
        // System.out.println("got here1");
        try
        {
            if(in.charAt(0) == '.' || in.charAt(in.length()-1) == '.')
            {
                return false;
            }
            String[] arr = in.split("\\.");
            if(arr.length != 4)
            {
                return false;
            }



            for(String s : arr)
            {
                //leading 0 check
                int preInt = s.length();

                int num = Integer.parseInt(s);
                // System.out.println("got here2");
                if(preInt != ("" + num).length()) //leading 0 check
                {
                    return false;
                }
                // System.out.println("got here3");
                if(num < 0 || num > 255)
                {
                    return false;
                }
                // System.out.println("got here4");
            }
            // System.out.println("got here5");
        }
        catch(Exception e)
        {
            return false;
        }
        return true;
    }

    boolean isIPV6(String in)
    {
        

        try
        {

            //convert string to lowercase
            in = in.toLowerCase();

            if(in.charAt(0) == ':' || in.charAt(in.length()-1) == ':')
            {
                return false;
            }

            String[] arr = in.split(":");
            if(arr.length != 8)
            {
                return false;
            }



            for(String s : arr)
            {
                if(s.length() > 4 || s.length() < 1)
                {
                    return false;
                }

                for(int i = 0; i < s.length(); i++)
                {
                    char c = s.charAt(i);
                    if(c < 48 || c > 57) //not a digit
                    {
                        if(c - 'a' < 0 || c - 'a' > 5) //inside a-f
                        {
                            return false;
                        }
                    }
                }
            }
        }
        catch(Exception e)
        {
            return false;
        }

        return true;
    }
}