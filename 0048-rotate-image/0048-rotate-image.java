class Solution {
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        int depth = (n%2==1) ? (n-1)/2 : n/2;
        
        for(int i = 0; i < depth; i++)
	        for(int k = i; k < n-1-i; k++) {
	        	
	        	int tempB = 0;
	        	int tempA = matrix[i][k];
		        for(int a = 0; a < 4; a++)
		        {
		            tempB = matrix[k][n - i - 1];
		            matrix[k][n - i - 1] = tempA;
		            tempA = tempB;
		            int tempI = i;
		            i = k;
		            k = n - tempI - 1;
		        }
	        }
    }

    // public void printArr(int[][] matrix)
    // {
    //     for(int i = 0; i < matrix.length; i++){
    //         for(int k = 0; k < matrix.length; k++)
    //         {
    //             System.out.print(matrix[i][k] + ", ");
    //         }
    //         System.out.println();
    //     }
    // }
}