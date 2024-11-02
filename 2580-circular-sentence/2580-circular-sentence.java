class Solution {
    public boolean isCircularSentence(String sentence) {
        String[] arr = sentence.split(" ");
        for(int i = 1; i <= arr.length; i++)
        {
            int k = i % arr.length;
            if(arr[i - 1].charAt(arr[i-1].length() - 1) != arr[k].charAt(0))
            {
                return false;
            }
        }

        return true;
    }
}