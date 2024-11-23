class Solution {
    public char[][] rotateTheBox(char[][] box) {
        char[][] out = new char[box[0].length][box.length];

        for(int i = 0; i < box.length; i++)
        {
            for(int k = 0; k < box[i].length; k++)
            {
                // System.out.println(i + " " + k + ", \t" + (out[0].length - 1 - i));
                out[k][out[0].length - 1 - i] = box[i][k];
            }
        }

        for(int i = 0; i < out[0].length; i++) //col
        {
            int shiftAmt = 0;
            for(int k = out.length - 1; k >= 0; k--)//row
            {
                char curr = out[k][i];
                if(curr == '.')
                {
                    shiftAmt++;
                }
                else if(curr == '*')
                {
                    shiftAmt = 0;
                }
                else
                {
                    //do the shift
                    out[k][i] = '.';
                    out[k + shiftAmt][i] = '#';
                }
            }
        }

        return out;
    }
}