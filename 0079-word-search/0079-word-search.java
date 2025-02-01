class Solution {

    char[][] grid;
    String w;
    public boolean exist(char[][] board, String word) {
        grid = board;
        w = word;

        if(board.length * board[0].length < word.length()) return false;

        for(int i = 0; i < board.length; i++)
        {
            for(int k = 0; k < board[0].length; k++)
            {
                // if(board[i][k] == word.charAt(0))
                // {
                //     visited = new boolean[grid.length][grid[0].length];
                //     dfs(i, k, 1);
                // }
                visited = new boolean[grid.length][grid[0].length];
                dfs(i, k, 0);
            }
        }

        return ans;
    }

    boolean[][] visited;
    boolean ans = false;
    void dfs(int r, int c, int strInd)
    {
        
        if(ans || w.charAt(strInd) != grid[r][c] || visited[r][c]) // || visited[r][c]
        {
            return;
        }

        if(strInd == w.length() - 1)
        {
            ans = true;
            return;
        }
        // System.out.println(grid[r][c] + "  " + r + ", " + c);
        

        visited[r][c] = true;

        int[] add = {-1, 0, 0, -1, 1, 0, 0, 1};
        for(int i = 0; i < add.length; i += 2)
        {
            // System.out.println("IIIII: " + i);
            int newR = add[i] + r;
            int newC = add[i + 1] + c;

            boolean inXBounds = newR >= 0 && newR < grid.length;
            boolean inYBounds = newC >= 0 && newC < grid[0].length;
            if(inXBounds && inYBounds) //check in bounds and correct char // && !(parentR == newR && parentC == newC)
            {
                // System.out.println("neighbors: " + grid[newR][newC] + "  " + newR + ", " + newC);
                dfs(newR, newC, strInd + 1);
                // visited[newR][newC] = false;
            }
        }
    }
}



// ["A","B","C","E"]
// ["S","F","E","S"]
// ["A","D","E","Z"]

//ABCESZEEFS

