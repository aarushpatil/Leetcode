class Solution {
    public int maximum69Number (int num) {        
        int tens = 1;
        int temp = num;
        
        //store the tens multiple for latest 6
        int latest = -1;
        while(temp != 0) {
            
            if(temp % 10 == 6)
            {
                latest = tens;
            }
            tens *= 10;
            
            temp = temp/10;
        }

        return Math.max(num + latest * 3, num);
    }
}