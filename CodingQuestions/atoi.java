package com.company;

class Solution {
    public int myAtoi(String s) {

        int i = 0;
        int number = 0;
        int sign = 1;

        // if string is empty string, return 0
        if(s.equals(""))
        {
            return 0;
        }

        // get rid of whitespace
        while(i < s.length() && s.charAt(i) == ' ')
        {
            i++;
        }


        // check for sign
        if(i < s.length() &&( s.charAt(i) == '-' || s.charAt(i) == '+'))
        {
            if(s.charAt(i) == '-' )
            {
                sign = -1;
            }
            else
            {
                sign = 1;
            }

            i++;
        }

        while(i < s.length() && s.charAt(i) >='0' && s.charAt(i) <='9')
        {

            if(number > Integer.MAX_VALUE/10 || (number == Integer.MAX_VALUE /10 && s.charAt(i) - '0' > 7))
            {
                if(sign == -1)
                {
                    return Integer.MIN_VALUE;
                }
                return Integer.MAX_VALUE;
            }

            number = number * 10 + (s.charAt(i) - '0');
            i++;
        }

        int output = number * sign;
        return output ;


    }
}

public class Main {

    public static void main(String[] args) {
	// write your code here
    }
}
