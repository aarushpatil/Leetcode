class Solution {
    public String convert(String s, int numRows) {

    if(numRows == 1){
        return s;
    }

    //String str = "";//PINALSIGYAHR, P, 

    StringBuilder str = new StringBuilder();

    for(int i = 0; i < numRows; i++){//1
        Boolean alt = true;//true
        int plusBottom = (numRows - i) * 2 - 2;//0
        int plusTop = i * 2;//6
        System.out.println(plusBottom + " , " + plusTop);
        for(int j = i; j < s.length();){//3
            str.append(s.charAt(j));
            //System.out.println(str);

            if(alt || plusTop == 0){//first time use bottom
                j += plusBottom;
            }
            if(!alt || plusBottom == 0){ //use top
                j += plusTop;
            }
            alt = !alt;
        }
    }
    return str.toString();
    }
}