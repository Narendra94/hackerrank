/*
Palindromes are strings that read the same from the left or right, for example madam or 0110.

You will be given a string representation of a number and a maximum number of changes you can make. 
Alter the string, one digit at a time, to create the string representation of the largest number possible given the limit to the number of changes. 
The length of the string may not be altered, so you must consider 's left of all higher digits in your tests. For example  is valid,  is not.

Given a string representing the starting number and a maximum number of changes allowed,
create the largest palindromic string of digits possible or the string -1 if it's impossible to create a palindrome under the contstraints.

I/p: 4 1
     3943
O/p: 3993

I/p:6 3
    092282
O/p:992299
*/
//If k goes below 0, then it is not possible to make string palindrome.

static String highestValuePalindrome(String s, int n, int k) {
        StringBuffer s2=new StringBuffer(s);
        int i=0,j=n-1,a=0,b=n-1,random=k;
        while(i<=j){
            if(s.charAt(i)!=s.charAt(j)){
                k--;
            }
            i++;j--;
        }
        if(k>=0){
        //If characters are not same at index i and j then replace that index value with max of both numbers.
            while(a<=b && random>0){
            if(s.charAt(a)!=s.charAt(b)){
                if(s.charAt(a)>s.charAt(b)){
                    s2.replace(a,a+1,String.valueOf(s.charAt(a)));
                    s2.replace(b,b+1,String.valueOf(s.charAt(a)));
                }else{
                    s2.replace(a,a+1,String.valueOf(s.charAt(b)));
                    s2.replace(b,b+1,String.valueOf(s.charAt(b)));
                }
                random--;
                }
            a++;b--;
            }
            i=0;j=n-1;
            while(i<=j && random>0){
                if(i==j && s.charAt(i)!='9'){
                    s2.replace(i,i+1,"9");random--;
                }else if(s.charAt(i)!=s.charAt(j) && s2.charAt(i)!='9'){  //If character was made palindrome in previous loop but it was not changed to 9.As we had used one k in previous step now we will use only one k to change the variable.
                    s2.replace(i,i+1,"9");
                    s2.replace(j,j+1,"9");
                    random--;
                }else if((s.charAt(i)==s.charAt(j)) && (random>=2) && s.charAt(i)!='9'){  //If variable was already equal,now we will use 2 value of k to change the value to 9.
                    s2.replace(i,i+1,"9");
                    s2.replace(j,j+1,"9");
                    random-=2;
                }
            i++;j--;
            }
            
        }
        
        if(k<0){
            return "-1";
        }
        return s2.toString();

    }
