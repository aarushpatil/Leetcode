class Solution {
    public int reverse(int x) {
        try{
            String str = "" + Math.abs(x);
            String s = "";
            for(int i = 0; i < str.length(); i++){
                s += str.substring(str.length()-1-i, str.length()-i);
            }
            if(x < 0){
                s = "-" + s;
            }
            return Integer.parseInt(s);
        }
        catch(Exception e){
            return 0;
        }
    }
}