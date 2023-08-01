class Solution {
    public int[][] merge(int[][] intervals) {
        //sort intervals by first number
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        
        //start at 0th interval. Compare ith interval with i+1 interval until i<length-1

        //store current interval
        int left = 10001;
        int right = -1;
        
        //counts how many intervals
        int counter = 0;

        for(int i = 0; i < intervals.length - 1; i++) {
            if(intervals[i][0] == intervals[i+1][0]) {
                // left = Math.min(left, intervals[i][0]);
                // right = Math.max(intervals[i][1], intervals[i+1][1]);

                intervals[i+1][0] = Math.min(left, intervals[i][0]);
                intervals[i+1][1] = Math.max(intervals[i][1], intervals[i+1][1]);

                intervals[i][0] = -1;
                intervals[i][1] = -1;
                counter++;
            }
            else if(intervals[i][1] > intervals[i+1][1]){
                // left = Math.min(left, intervals[i][0]);
                // right = intervals[i][1];

               
                intervals[i+1][0] = Math.min(left, intervals[i][0]);
                intervals[i+1][1] = intervals[i][1];

                intervals[i][0] = -1;
                intervals[i][1] = -1;
                counter++;

            }
            else if(intervals[i+1][0] <= intervals[i][1]) {
                // left = Math.min(left, intervals[i][0]);
                // right = intervals[i+1][1];

                intervals[i+1][0] = Math.min(left, intervals[i][0]);
                intervals[i+1][1] = intervals[i+1][1];

                intervals[i][0] = -1;
                intervals[i][1] = -1;
                counter++;
            }
            else {
                left = 10001;
            }
        }

        //makes return arr from number of combined intervals.
        int[][] retArr = new int[intervals.length - counter][];
        int c = 0;
        for(int i = 0; i < intervals.length; i++)
        {
            if(!(intervals[i][0] == -1)) {
                retArr[c] = intervals[i];
                c++;
            }
        }

        return retArr;
    }
}