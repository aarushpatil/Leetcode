class Solution {
    public int tribonacci(int n) {
        int a = 0;
        int b = 1;
        int c = 1;

        if(n == 0)
        {
            return a;
        }
        if(n <= 2)
        {
            return b;
        }

        for(int i = 0; i < n; i++)
        {
            int newC = a + b + c;
            a = b;
            b = c;
            c = newC;
        }

        return a;
    }
}