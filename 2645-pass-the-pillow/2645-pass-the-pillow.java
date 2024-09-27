class Solution {
    public int passThePillow(int n, int time) {
        int roundTrip = 2 * (n-1);

        time = time % roundTrip;

        if(time == n - 1)
        {
            //last one
            return n;
        }
        else if(time > n - 1)
        {
            return n - (time - n + 1);
        }
        else //time < n - 1
        {
            return time + 1;
        }
    }
}