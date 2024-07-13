class Solution {

    int[] size;
    int[] links;

    int rows;
    int cols;
    public int numIslands(char[][] grid) {
        rows = grid.length;
        cols = grid[0].length;

        size = new int[rows * cols];
        links = new int[rows * cols];
        

        for(int i = 0; i < rows * cols; i++)
        {
            links[i] = i;
        }

        //unionize everything that is down and right iterating over grid left to right
        for(int i = 0; i < rows; i++)
        {
            for(int k = 0; k < cols; k++)
            {
                if(grid[i][k] == '1')
                {
                    if(k+1 < cols && grid[i][k+1] == '1')
                    {
                        union(cols * i + k, cols * i + k + 1);
                    }

                    if(i+1 < rows && grid[i+1][k] == '1')
                    {
                        union((i + 1) * cols + k, i * cols + k);
                    }
                }
                else
                {
                    links[i * cols + k] = -1;
                }
            }
        }

        System.out.println(Arrays.toString(links));
        int count = 0;
        for(int i = 0; i < rows * cols; i++)
        {
            if(links[i] == i)
            {
                count++;
            }
        }
        return count;
    }

    int find(int a)
    {
        // while(links[a] != a)
        // {
        //     a = links[a];
        // }
        if(a == links[a])
        {
            return a;
        }
        a = find(links[a]);
        return a;
    }

    void union(int a, int b)
    {
        a = find(a);
        b = find(b);
        if(size[a] > size[b])
        {
            links[b] = a;
            size[a] += size[b];
        }
        else
        {
            links[a] = b;
            size[b] += size[a];
        }
    }
}