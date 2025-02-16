class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;

        int[][] direction = {{0, 1},{1, 0},{0, -1},{-1, 0}};
        HashSet<String> visited = new HashSet();

        int dirInd = 0; //start with right
        int curRow = 0;
        int curCol = 0;

        List<Integer> output = new LinkedList();

        visited.add(curRow + " " + curCol);
        output.add(matrix[curRow][curCol]);
        while(visited.size() < rows * cols)
        {
            int newRow = curRow + direction[dirInd][0];
            int newCol = curCol + direction[dirInd][1];
            boolean inBounds = (newRow >= 0 && newRow < rows) && (newCol >= 0 && newCol < cols);
            while(inBounds && !visited.contains(newRow + " " + newCol)) //not oob and not already visited
            {
                //keep moving in dir and adding to visited
                curRow = newRow;
                curCol = newCol;

                visited.add(curRow + " " + curCol);
                // System.out.println(curRow + " " + curCol + "|| " + visited.size());
                output.add(matrix[curRow][curCol]);


                newRow = curRow + direction[dirInd][0];
                newCol = curCol + direction[dirInd][1];
                inBounds = (newRow >= 0 && newRow < rows) && (newCol >= 0 && newCol < cols);
            }
            dirInd = (dirInd + 1) % direction.length;
        }

        return output;
    }
}