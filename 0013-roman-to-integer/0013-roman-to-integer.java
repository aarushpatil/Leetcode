class Solution {
    public int romanToInt(String s) {
        //switch statement with all symbols in separate method
        //check subtraction special cases
        // int sum = symb(s.charAt(0));
        // char prev = s.charAt(0);
        // for(int i = 1; i < s.length(); i++){ 
        //     int add = symb(s.charAt(i));
            // if((prev == 'I') && (s.charAt(i) == 'V' || s.charAt(i) == 'X')){ // could combine these 3 into one if
            //     add = symb(s.charAt(i)) - 1;
            // }

            // if((prev == 'X') && (s.charAt(i) == 'L' || s.charAt(i) == 'C')){
            //     add = symb(s.charAt(i)) - 10;
            // }

            // if((prev == 'C') && (s.charAt(i) == 'D' || s.charAt(i) == 'M')){
            //     add = symb(s.charAt(i)) - 100;
            // }

        //     sum += add;
        //     prev = s.charAt(i);
        // }
        // return sum;



        //better sol. Add all values. Then loop through and check for special cases and subtract twice them 
        int sum = 0;
        for(int i = 0; i < s.length(); i++){
            sum += symb(s.charAt(i));
        }

        for(int i = 0; i < s.length()-1; i++){
            char c = s.charAt(i);
            if((c == 'I') && (s.charAt(i+1) == 'V' || s.charAt(i+1) == 'X')){ 
                sum = sum - 2 * symb(c);
            }

            if((c == 'X') && (s.charAt(i+1) == 'L' || s.charAt(i+1) == 'C')){
                sum = sum - 2 * symb(c);
            }

            if((c == 'C') && (s.charAt(i+1) == 'D' || s.charAt(i+1) == 'M')){
                sum = sum - 2 * symb(c);
            }
        }


        return sum;
        
    }

    private int symb(char s){
        if(s == ('I')){
            return 1;
        }
        else if(s == ('V')){
            return 5;
        }
        else if(s == ('X')){
            return 10;
        }
        else if(s == ('L')){
            return 50;
        }
        else if(s == ('C')){
            return 100;
        }
        else if(s == ('D')){
            return 500;
        }
        else if(s == ('M')){
            return 1000;
        }
        return -1;
    }
}