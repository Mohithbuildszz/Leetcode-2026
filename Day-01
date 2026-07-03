class Solution {
    public int reverse(int x) {
        boolean sign = true;
        if(x<0){
             sign = false;
        } x = Math.abs(x);
        long total = 0;
        while(x>0){
            total= (total*10) + (x%10);
            x = x/10;
            if(total > Integer.MAX_VALUE || total < Integer.MIN_VALUE)
            return 0;
        }
      if(!sign)  
      return -1*(int) total;
    return (int) total;
        }
} 
