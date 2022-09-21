class Solution {
  public static boolean isValid(String str) {

      if(str.length() % 2 == 1){
          return false;
      }
      
      
        int[] arr = new int[str.length()];
        int lastEntry = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '(' || str.charAt(i) == '{' || str.charAt(
                i) == '[') {
                arr[lastEntry] = str.charAt(i);
                lastEntry++;
            }

            else {
                if(lastEntry == 0){
                    return false;
                }
                
                if ((arr[lastEntry - 1] == '(' && str.charAt(i) == ')')
                    || (arr[lastEntry - 1] == '[' && str.charAt(i) == ']')
                    || (arr[lastEntry - 1] == '{' && str.charAt(i) == '}')) {
                    lastEntry--;
                }
                else{
                    return false;
                }
            }
        }
        if(lastEntry == 0) {
            return true;
        }
        else {
            return false;
        }
    }
}