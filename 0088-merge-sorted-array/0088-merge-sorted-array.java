class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int[] sol = new int[m + n];
        int solInd = 0;

        int one = 0;
        int two = 0;

        for(int i = 0; i < m + n; i++)
        {
            if(one >= m)
            {
                                System.out.println("a");

                sol[solInd] = nums2[two];
                two++;
            }
            else if(two >= nums2.length)
            {
                System.out.println("b");

                sol[solInd] = nums1[one];
                one++;
            }
            else if(nums1[one] < nums2[two])
            {

                System.out.println("c");
                sol[solInd] = nums1[one];
                one++;
            }
            else
            {
                System.out.println("d");

                sol[solInd] = nums2[two];
                two++;
            }
            solInd++;
        }

        for(int i = 0; i < sol.length; i++)
        {
            nums1[i] = sol[i];
        }
    }
}