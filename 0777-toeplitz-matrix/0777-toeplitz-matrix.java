class Solution {
    public boolean isToeplitzMatrix(int[][] matrix) {

        //height = matrix[0].length, 4
        //width = matrix.length, 3

        //loop through each number on the top border of matrix
        int row = 0;
        for(int col = 0; col < matrix[0].length; col++)
        {
            //go diagonally and check to see if it the same number
            int temp = matrix[row][col];
            int k = 1;
            while(k < matrix.length && col + k < matrix[0].length)
            {
                if(matrix[k][col + k] != temp)
                {
                    return false;
                }
                k++;
            }
        }
        //loop through each number on the left border of matrix
        int col = 0;
        for(int r = 1; r < matrix.length; r++)
        {
            int temp = matrix[r][col];
            int k = 1;

            while(k < matrix[0].length && r + k < matrix.length)
            {
                if(matrix[k+r][k] != temp)
                {
                    return false;
                }
                k++;
            }
        }

        return true;

    }
}