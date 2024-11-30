class Solution {
    int[][] mat;
    int s;
    HashMap<Integer, int[]> map;
    public int knightDialer(int n) {
        int mod = (int)Math.pow(10, 9) + 7;
        s = n;

        map = new HashMap<>();
        map.put(1, new int[]{6, 8});
        map.put(2, new int[]{7, 9});
        map.put(3, new int[]{4, 8});
        map.put(4, new int[]{0, 3, 9});
        map.put(5, new int[]{});
        map.put(6, new int[]{0, 1, 7});
        map.put(7, new int[]{2, 6});
        map.put(8, new int[]{1, 3});
        map.put(9, new int[]{2, 4});
        map.put(0, new int[]{4, 6});


        int[] arr = new int[10];
        for(int i = 0; i < 10; i++)
        {
            arr[i] = 1;
        }

        for(int k = 1; k < n; k++)
        {
            int[] newArr = new int[10];
            for(int i = 0; i < arr.length; i++)
            {
                for(int num : map.get(i))
                {
                    newArr[num] = (newArr[num] + arr[i]) % mod;
                }
            }
            arr = newArr;
        }

        int ans = 0;
        for (int value : arr) {
            ans = (ans + value) % mod;
        }

        // for(int i = 0; i < 10; i++)
        // {
        //     dfs(1, i);
        // }

        return ans;
    }


    int count = 0;
    void dfs(int steps, int curr)
    {
        if(steps == s)
        {
            count++;
            return;
        }

        //all possible jumps
        int[] next = map.get(curr);
        for(int n : next)
        {
            dfs(steps + 1, n);
        }
        // dfs(steps + 1, );
    }
}