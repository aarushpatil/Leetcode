class Solution {
    public String addBinary(String a, String b) {

        boolean carry = false;
        int index = Math.max(a.length(), b.length());
        int aInd = a.length()-1;
        int bInd = b.length()-1;

        StringBuilder str = new StringBuilder();

        while(index > 0)
        {

            //set char values
            int aChar = 0;
            int bChar = 0;

            if(aInd >= 0)//exists
            {
                aChar = a.charAt(aInd) - 48;
            }
            if(bInd >= 0)//exists
            {
                bChar = b.charAt(bInd) - 48;
            }
            
            int c = (carry) ? 1 : 0;
            // carry = false; 
            if(aChar + bChar + c > 1)
            {
                carry = true;
            }
            else
            {
                carry = false;
            }

            if((aChar + bChar + c) % 2 == 0)
            {
                // str = "0" + str;
                str.insert(0, '0');
            }
            else
            {
                // str = "1" + str;
                str.insert(0, '1');
            }


            index--;
            aInd--;
            bInd--;
        }

       //  1010
       //  1011
       // 10101

       if(carry)
       {
        str.insert(0, '1');
       }

        return str.toString();


        /*

        boolean carry = false;
        while( there exists a char to the left for at least one of the strings at index)
        {
            aChar = 0
            bChar = 0

            set a char and b char to their value at index
            int num = aChar + bChar + carry

            if num > 1
                carry = true

            if num % 2 == 0
                currIndVal = 0
            else
                currIndVal = 1
        }

        if carry is true add a 1 at the beginning

        return str
        */
    }
}