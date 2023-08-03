class Solution {
    public int[][] generateMatrix(int n) {
        int left = 0;
        int right = 0;
        int top = 1;
        int bottom = 0;

        int four = 0;
        //0:right
        //1:down
        //2:left
        //3:up
        
        
        int counter = 1;

        int xi = 0;
        int yi = 0;

        //matrix
        int[][] mat = new int[n][n];

        while(counter <= n * n)
        {
            
            mat[xi][yi] = counter;
            counter++;

            if(four % 4 == 0)
            {
                //right
                yi++;
                if(yi == n - 1 - right)
                {
                    four++;
                    right++;
                }
            }

            else if(four % 4 == 1)
            {
                //down
                xi++;
                if(xi == n-1 - bottom)
                {
                    four++;
                    bottom++;
                }
            }

            else if(four % 4 == 2)
            {
                //left
                yi--;

                if(yi == 0 + left)
                {
                    four++;
                    left++;
                }
            }

            else
            {
                //up
                xi--;

                if(xi == 0 + top)
                {
                    four++;
                    top++;
                }
            }
        }

        return mat;


    }
}