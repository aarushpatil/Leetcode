loop through
​
make sliding window.
left++ when bracket completed
right++ per loop
check entire window iterate through right to left every time closing bracket
​
________________________________________________________________
make array -- could make half size for increased efficiency
make int lastEntry variable
loop through
add each opening bracket to array; last entry++
check last opening bracket when closing bracket seen
if not match up return false
else lastEntry--;
​
int[] arr = new int[s.length()];
int lastEntry = 0;
for(int i = 0; i < s.length; i++){
if(str.charAt(i) == '(' || str.charAt(i) == '{' || str.charAt(i) == '['){
arr[lastEntry] = str.charAt(i);
lastEntry++;
}
else{
if(arr[lastEntry-1] != str.charAt(i)){
return false;
}
lastEntry--;
}
}