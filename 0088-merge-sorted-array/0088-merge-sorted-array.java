class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {

        //if nums2 is empty return nums1
        //create index variable in nums2 that iterates through starting at 0
        //create index variable in nums1 that iterates through starting at 0
        //find where nums2 is greater than nums1 and insert before
        //repeat

        // int in1 = 0;
        // int in2 = 0;

        // int shift = 0;
        // int shiftStore = 0;
        // while(ln1 < nums1.length){
        //     if(shift > 0){
        //         nums1[ln1 + shift] = shiftStore;
        //     }

        //     if(nums1[in1] < nums2[in2]){
        //         in1++;
        //     }
        //     else{
        //         shiftStore = nums1[in1];
        //         nums1[in1] = nums2[in2];
        //         shift++;
        //         in2++;
        //     }

        // }
        //at the end add all remaining ln2 to ln1

        if(nums2.length != 0){
            int[] nums3 = new int[m+n];
            int i1 = 0;
            int i2 = 0;

            int k = 0;
            while(i1 < m && i2 < n){
                if(nums1[i1] < nums2[i2]){
                    nums3[k] = nums1[i1];
                    i1++;
                }
                else{
                    nums3[k] = nums2[i2];
                    i2++; 
                }
                k++;
            }

            if(i1 == m){
                for(int i = i2; i < n; i++){
                    nums3[k] = nums2[i];
                    k++;
                }
            }
            if(i2 == n){
                for(int i = i1; i < m; i++){
                    nums3[k] = nums1[i];
                    k++;
                }
            }

            for(int i = 0; i < m+n; i++){
                nums1[i] = nums3[i];
            }
        }
    }
}