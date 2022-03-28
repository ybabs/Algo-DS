package com.company;

class Solution
{
    public int StringtoBalancedStrings(String s)
    {
        int balancedCOunt = 0;
        int count = 0;

        for (int i = 0; i < s.length(); i++)
        {
            char current = s.charAt(i);
            if(current == 'L')
            {
                count ++;
            }
            else if ( current == 'R')
            {
                count --;
            }

            if(count == 0)
            {
                balancedCOunt ++;
            }
        }
        return balancedCOunt;
    }
}

public class Main {

    public static void main(String[] args) {
	// write your code here
    }
}
