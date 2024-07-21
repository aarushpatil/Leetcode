class Solution {

    int[] links;
    int[] size;
    public int findCircleNum(int[][] isConnected) {

        links = new int[isConnected.length];
        size = new int[isConnected.length];

        for(int i = 0; i < links.length; i++)
        {
            links[i] = i;
        }

        for(int i = 0; i < isConnected.length; i++)
        {
            for(int k = 0; k < isConnected[i].length; k++)
            {
                if(isConnected[i][k] == 1) //node i is connected to node k
                {
                    union(i, k);
                }
            }
        }

        System.out.println(Arrays.toString(links));
        
        int count = 0;
        for(int i = 0; i < links.length; i++)
        {
            if(i == links[i])
            {
                count++;
            }
        }
        return count;
        // return -1;
    }

    void union(int a, int b)
    {
        a = find(a);
        b = find(b);

        if(size[a] > size[b])
        {
            //add b to a
            links[b] = links[a];
            size[a] += size[b];
        }
        else
        {
            links[a] = links[b];
            size[b] += size[a];
        }
    }

    int find(int a)
    {
        while(a != links[a])
        {
            a = links[a];
        }
        
        return a;
    }
}