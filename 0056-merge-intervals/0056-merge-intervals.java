class Solution {
    public int[][] merge(int[][] intervals) { 
        // case 1: completely inside
        // s ------------------ e
        //        s ------- e

        // case 2: normal 
        //s ------- e
        //     s ------------ e

        // case 3: boundary connected
        //s ------- e
        //          s ------------ e

        // case 3: boundary connected
        //          s ------------ e
        //          s ------- e

        // case 4: same
        //          s ------------ e
        //          s ------------ e



        //unmergeable case

        // case 4: 
        //s ------------ e
        //                   s ------------ e

        //sort the intervals by start.
        //if start is inside or equal previous interval's end, then you can definetly merge

        //if start is > end of previous, then cant merge

        List<int[]> list = new LinkedList<>();

        //[] merge [] merge []
        //[] merge [] no me []
        //[] no.   [].  no. []  need to add last from prev
        //[]. no.  [] merge []. need to add last from prev
        
        int[] prev = new int[]{intervals[0][0], intervals[0][1]};
        for(int i = 1; i < intervals.length; i++)
        {
            int start = intervals[i][0];
            int end = intervals[i][1];
            
            int prevStart = prev[0];
            int prevEnd = prev[1];

            if(start > prevEnd)
            {
                //cant merge
                list.add(prev);
                prev = new int[] {start, end};
            }
            else
            {
                //merge
                int beg = prevStart;
                int en = Math.max(end, prevEnd);
                prev = new int[] {beg, en};
            }
        }

        //add the last one
        list.add(prev);
        // int[] last = intervals[intervals.length - 1];
        // int[] tail = list.get(list.size() - 1);
        // if(tail[0] == last[0] && tail[1] == last[1])
        // {
            
        // }
        int[][] out = new int[list.size()][];
        int c = 0;
        for(int[] ar : list)
        {
            out[c] = ar;
            c++;
        }

        return out;
    }
}