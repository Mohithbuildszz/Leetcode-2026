## 509. Fibonacci Number

------
//actually used the fibonacci formulla-- which is f(n) = F(n-1) + F(n-2) 

//1st step is used to check the conditions each number is the sum of the two preceding ones, starting from 0 and 1.

//soo i have used the if condition which is 


if(n == 0){
 return 0;
  }  
if(n == 1){
return 1;
} 

//intialized the varialbe

//then used for loop and iterated from i = 2 

//used Fibonacci forumala 

        int a = 0;
        int b =1;
        int c =0;
        for(int i=2;i<=n;i++){
            c = a + b;
            a = b;
            b = c;
        }
        return c;
    }
}

//at the last i have retured the c which has the final answr 
