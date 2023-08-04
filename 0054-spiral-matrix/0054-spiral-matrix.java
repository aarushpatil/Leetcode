class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {

        


        List<Integer> list = new ArrayList<>();
        int four = 1;
        //1:right
        //2:down
        //3:left
        //4:up

        int xi = 0;
        int yi = 0;

        int right = 0;
        int bottom = 0;
        int left = 0;
        int top = 1;

        if(matrix[0].length == 1)
        {
            four++;
        }


        while(list.size() != matrix.length * matrix[0].length)
        {
            list.add(matrix[xi][yi]);

            if(four % 4 == 1)
            {
                //right
                yi++;
                //block hit
                if(yi == matrix[0].length-1-right)
                {
                    four++;
                    right++;
                }
            }

            else if(four % 4 == 2)
            {
                //down
                xi++;
                //block hit
                if(xi == matrix.length-1-bottom)
                {
                    four++;
                    bottom++;
                }
            }

            else if(four % 4 == 3)
            {
                //left
                yi--;
                if(yi == left)
                {
                    four++;
                    left++;
                }
            }
            else
            {
                //up
                xi--;

                if(xi == top)
                {
                    four++;
                    top++;
                }
            }
        }

        return list;
    }
}