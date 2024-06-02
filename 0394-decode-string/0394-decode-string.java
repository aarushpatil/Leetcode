// class Solution {
//     public String decodeString(String s) {
        // int i = 0;
        // s = s + "!";
        // Stack<Integer> st = new Stack();
        // while('!' != s.charAt(i)) //i've reached the end with i
        // {
        //     char curr = s.charAt(i);
        //     //store the prev open bracket
        //     if(curr == '[')
        //     {
        //         st.push(i);
        //     }

        //     if(curr == ']')
        //     {
        //         //'resolve' this string. there must have been an open bracket alr
        //         //openInd to i is the substring i need
        //         int openInd = st.pop();//1
        //         String innerString = s.substring(openInd + 1, i);//2-3 = a
        //         int startIndOfNum = getNum(s, openInd-3, openInd);//0

                // String resolvedString = "";
                // // System.out.println("innerstr: " + innerString);
                // // System.out.println("the startInd: " + startIndOfNum);
                // // System.out.println("the openInd: " + openInd);
                // int num = Integer.parseInt(s.substring(startIndOfNum, openInd));
                // // System.out.println("the num: " + num);

                // for(int k = 0; k < num; k++)
                // {
                //     resolvedString += innerString;
                // }

        //         //splice s and put it into there
        //         String partA = s.substring(0, startIndOfNum);
        //         s = partA + resolvedString + s.substring(i+1, s.length());
        //         i = partA.length() + resolvedString.length()-1;
        //         // System.out.println("the new str: " + s);
        //         // System.out.println("new i: " + i);
        //     }

        //     i++;
        // }
        // return s.substring(0, s.length()-1);
    // }

    //take in where number could start to closing bracket index
//     int getNum(String s, int start, int end) 
//     {
//         start = Math.max(start, 0);
//         // s = s.substring(start, end);
//         // System.out.println(s);
//         for(int i = end-1; i >= start; i--)//start = 2,      end = 5
//         {
//             // System.out.println(s.charAt(i));
//             if( !(((int)s.charAt(i)) >= 48 && ((int)s.charAt(i)) <= 57) )   //97-122
//             {
//                 // System.out.println("the III: " + i);
//                 return i+1;//Integer.parseInt(s.substring(i, s.length()));
//             }
//         }
//         return 0; //no number
//     }
// }



//recursive solution:

/*

    boolean isInner = false;
    String method(String s, int i, String retStr)
    {
        if(curr.is number)
        {
            get the rest of the number
            retStr += recurse( int theMultiplierNumber, i = start of opening bracket , retStr = "")
        }
        
        else //so not a number and not a bracket [] then
        {
            retStr += curr;
        }

        // else if(']' == curr)
        // {
        //     //logic to resolve the inner string
        //     return innerString
        // }
    }

*/


class Solution {
    public String decodeString(String s) {
        return method(s, 1);
    }
    
    int i = 0;

    String method(String s, int mult)
    {
        String retStr = "";
        while(i < s.length())
        {
            char curr = s.charAt(i);
            int currAscii = curr;
            System.out.println(i);
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
                System.out.println("recurse!");
                retStr += method(s, theMult);
            }

            else if(']' == curr)
            {
                System.out.println(mult);
                String resolvedString = "";
                for(int k = 0; k < mult; k++)
                {
                    resolvedString += retStr;
                }
                System.out.println(resolvedString);
                return resolvedString;
            }

            else
            {
                retStr += curr;
            }
            i++;
        }
        return retStr;
    }
}